package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.api.dto.response.VoucherDtoResponse;
import com.tuandang.ecommerce_api.core.domain.*;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.ICartMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IProductMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IUserMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IVoucherMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UsersRepository usersRepository;
    private final IUserMapper iUserMapper;
    private final IProductMapper iProductMapper;
    private final ICartMapper iCartMapper;
    private final IVoucherMapper iVoucherMapper;

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
    public String login(String userName, String password) {
        return usersRepository.findPasswordByUserName(userName).filter(pass -> pass.equals(password)).map(pass -> usersRepository.findRoleByUserName(userName)).orElse(null);
    }

    @Override
    public List<Addresses> getAddressesByUserId(UUID id){
        return usersRepository.findAddressById(id)
                .stream()
                .map(iUserMapper::toAddresses)
                .toList();
    }

    @Override
    public Users findUserById(
        UUID id
    ) {
        return iUserMapper.toUsers(usersRepository.findUsersEntitiesById(id));
    }

    @Override
    public Users findUserByEmail(String email) {
        return iUserMapper.toUsers(usersRepository.findUsersEntitiesByEmail(email));
    }

    @Override
    public List<Products> findAllProductById(UUID userId) {
        return usersRepository.findProductByUserId(userId)
                .stream()
                .map(iProductMapper::toProduct)
                .toList();
    }

    @Override
    public Carts findCartByUserId(UUID userId) {
        return iCartMapper.toCart(usersRepository.findCartByUserId(userId));
    }

    @Override
    public List<Vouchers> getVoucherByUserId(UUID userId) {
        return usersRepository.getVoucherByUserId(userId)
                .stream()
                .map(iVoucherMapper::toVoucher)
                .toList();
    }

}
