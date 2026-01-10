package com.tuandang.ecommerce_api.infrastructure.configuration;

import com.tuandang.ecommerce_api.core.Enum.Role;
import com.tuandang.ecommerce_api.core.domain.UserPrincipal;
import com.tuandang.ecommerce_api.core.domain.Users;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import com.tuandang.ecommerce_api.core.service.JwtService;
import com.tuandang.ecommerce_api.core.service.UserServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final UserServices userServices;
    private final UserRepositoryPort userRepositoryPort;
    private final JwtService jwtService;
    @Value("${app.oauth2.redirect-uri}")
    private String redirectUri;

    public OAuth2LoginSuccessHandler(
            JwtService jwtService,
            @Lazy UserServices userServices,
            UserRepositoryPort userRepositoryPort
    ) {
        this.jwtService = jwtService;
        this.userServices = userServices;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException  {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        OAuth2AuthenticationToken authToken =  (OAuth2AuthenticationToken) authentication;
        String provider = authToken.getAuthorizedClientRegistrationId();
        assert oAuth2User != null;
        String email = oAuth2User.getAttribute("email");
        String username =  oAuth2User.getAttribute("login");
        if ("google".equals(provider)) {
            username = email;
        }
        Users user = Users.builder()
                .role(Role.SELLER)
                .userName(username)
                .email(email)
                .build();
        if (userRepositoryPort.findUserByEmail(email) == null) {
            userServices.save(user);
        }
        UserPrincipal userPrincipal = new UserPrincipal(user);

        String token = jwtService.generateToken(userPrincipal);

        String targetUrl = redirectUri + "?token=" + token;

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
