package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.domain.Users;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryPort {
    public void save(Users user);
    public UUID findIdByUserName(String userName);
    public void changePassword(String userName, String password);
    public String findFirstUserNameById(UUID id);
    public Users findUserByUserName(String userName);
    public void updateUser(Users user);
    public Boolean login(String userName, String password);
    public List<Addresses> getAddressesByUserId(UUID id);
}
