package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.domain.Users;
import com.tuandang.ecommerce_api.core.exception.AccountAlreadyExitsException;
import com.tuandang.ecommerce_api.core.exception.AccountNotFoundException;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServices {
    private final UserRepositoryPort userRepositoryPort;
    UserServices(UserRepositoryPort userRepositoryPort
    ) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public void createUser(Users user){
        if (userRepositoryPort.findIdByUserName(user.getUserName()) != null)
            throw new AccountAlreadyExitsException(HttpStatus.NOT_FOUND.value(), "This account already exists!");
        else
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

    public Boolean login(String username, String password){
        return userRepositoryPort.login(username, password);
    }

    public List<Addresses> getAddressesByUserId(UUID id){
        return  userRepositoryPort.getAddressesByUserId(id);
    }
}
