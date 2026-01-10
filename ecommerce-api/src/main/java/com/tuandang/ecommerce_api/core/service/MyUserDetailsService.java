package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.core.domain.Accounts;
import com.tuandang.ecommerce_api.core.domain.UserPrincipal;
import com.tuandang.ecommerce_api.core.domain.Users;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepositoryPort userRepositoryPort;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepositoryPort.findUserByUserName(username);

        if (user == null)
            throw new UsernameNotFoundException(username);

        return new UserPrincipal(user);
    }
}
