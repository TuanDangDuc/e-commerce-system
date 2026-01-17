package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.api.dto.response.VoucherDtoResponse;
import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.domain.UserPrincipal;
import com.tuandang.ecommerce_api.core.domain.Users;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import com.tuandang.ecommerce_api.core.exception.AccountAlreadyExitsException;
import com.tuandang.ecommerce_api.core.exception.AccountNotFoundException;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepositoryPort userRepositoryPort;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void createUser(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        if (userRepositoryPort.findIdByUserName(user.getUserName()) != null)
            throw new AccountAlreadyExitsException(HttpStatus.NOT_FOUND.value(), "UserName has already been used");
        else if (userRepositoryPort.findUserByEmail(user.getEmail()) != null)
            throw new AccountAlreadyExitsException(HttpStatus.NOT_FOUND.value(), "Email has already been used");
        else
            userRepositoryPort.save(user);
    }

    public void save(Users user){
        userRepositoryPort.save(user);
    }

    public void changePassword(String userName, String password) {
        if (userRepositoryPort.findIdByUserName(userName) == null)
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.value(), "This account does not exist to changePassword!");
        else
            userRepositoryPort.changePassword(userName, password);
    }

    public Users getUser(String userName){
        return userRepositoryPort.findUserByUserName(userName);
    }
    public void updateUser(Users user){
        var base =  userRepositoryPort.findUserById(user.getId());
        if (base == null)
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.value(), "This account does not exist!");
        if (user.getEmail() == null)
            user.setEmail(base.getEmail());
        if (user.getFullName() == null)
            user.setFullName(base.getFullName());
        if (user.getSex() == null)
            user.setSex(base.getSex());
        if (user.getDateOfBirth() == null)
            user.setDateOfBirth(base.getDateOfBirth());
        if (user.getAvatarUrl() == null)
            user.setAvatarUrl(base.getAvatarUrl());

        userRepositoryPort.updateUser(user);
    }

    public String login(String username, String password){

        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));


            if (auth.isAuthenticated()) {
                UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
                return jwtService.generateToken(userPrincipal);
            }
        } catch (AuthenticationException e) {
            throw new AccountNotFoundException(HttpStatus.UNAUTHORIZED.value(), "ERROR: " + e.getMessage() );
        }


        return "Fail";
    }

    public List<Addresses> getAddressesByUserId(UUID id){
        return  userRepositoryPort.getAddressesByUserId(id);
    }


    public List<Vouchers> getVoucherByUserId(UUID userId) {
        return userRepositoryPort.getVoucherByUserId(userId);
    }

}
