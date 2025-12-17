package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.domain.Users;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IUserMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UsersRepository usersRepository;
    private final IUserMapper iUserMapper;
    public UserRepositoryAdapter(
            UsersRepository usersRepository,
            IUserMapper iUserMapper
    ) {
        this.usersRepository = usersRepository;
        this.iUserMapper = iUserMapper;
    }

    @Override
    public void save(Users user) {
        if (user == null)
            throw new NullPointerException("user should not be null!");
        usersRepository.save(iUserMapper.toUsersEntity(user));
    }

    @Override
    public UUID findIdByUserName(String userName){
        return usersRepository.findIdByUserName(userName);
    }

    @Override
    public String findFirstUserNameById(UUID id) {
        return usersRepository.findFirstUserNameById(id);
    }

    @Override
    public void changePassword(String userName, String password) {
        usersRepository.changePasswordByUserName(userName, password);
    }

    @Override
    public Users findUserByUserName(String userName){
        return iUserMapper.toUsers(usersRepository.findFirstUserNameByUserName(userName));
    }

    @Override
    public void updateUser(Users user) {
        usersRepository.updateUserById(user.getId(), user.getEmail(), user.getFullName(), user.getSex(), user.getDateOfBirth(), user.getAvatarUrl());
    }

    @Override
    public Boolean login(String userName, String password) {
        String corPassword = usersRepository.findPasswordByUserName(userName);
        return corPassword.equals(password);
    }

    @Override
    public List<Addresses> getAddressesByUserId(UUID id){
        return usersRepository.findAddressById(id)
                .stream()
                .map(iUserMapper::toAddresses)
                .toList();
    }
}
