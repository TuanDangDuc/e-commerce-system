package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.api.dto.response.VoucherDtoResponse;
import com.tuandang.ecommerce_api.core.domain.*;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryPort {
    public void save(Users user);
    public UUID findIdByUserName(String userName);
    public void changePassword(String userName, String password);
    public String findFirstUserNameById(UUID id);
    public Users findUserByUserName(String userName);
    public void updateUser(Users user);
    public String login(String userName, String password);
    public List<Addresses> getAddressesByUserId(UUID id);
    public Users findUserById(UUID id);
    public Users findUserByEmail(String email);

    public List<Products> findAllProductById(UUID userId);

    public Carts findCartByUserId(UUID userId);

    public List<Vouchers> getVoucherByUserId(UUID userId);

}
