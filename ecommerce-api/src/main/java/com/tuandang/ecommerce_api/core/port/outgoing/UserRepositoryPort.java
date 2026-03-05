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
    public Users findUserById(UUID id);
    public Users findUserByEmail(String email);


    public Carts findCartByUserId(UUID userId);


    public void changeRole(UUID userId);

    public String findStatusOfAccountByUsername(String username);
}
