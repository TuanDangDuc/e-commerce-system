package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.users.ChangePasswordDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.users.LoginDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.users.RegisterUserDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.users.UpdateUserDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.AddressesDtoResponse;
import com.tuandang.ecommerce_api.api.dto.response.UserDtoResponse;
import com.tuandang.ecommerce_api.api.mapper.AddressMapper;
import com.tuandang.ecommerce_api.api.mapper.UserMapper;
import com.tuandang.ecommerce_api.core.service.UserServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserControllers {
    private final UserServices userServices;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    public UserControllers(
            UserServices userServices,
            UserMapper userMapper,
            AddressMapper addressMapper
    ) {
        this.userServices = userServices;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
    }
    // register
    @PostMapping
    public ResponseEntity<Void> CreateUser(
            @Valid @RequestBody RegisterUserDtoRequest request
    ){
        userServices.createUser(userMapper.toUsers(request));
        return ResponseEntity.ok().build();
    }
    // change password
    @PatchMapping("/change-password")
    public ResponseEntity<Void> ChangePassword(
            @RequestBody ChangePasswordDtoRequest request
    ){
      userServices.changePassword(request.userName(), request.password());
      return ResponseEntity.ok().build();
    }
    // get User
    @GetMapping("/{userName}")
    public UserDtoResponse getUser(
            @PathVariable("userName") String userName
    ){
        return userMapper.toUserDtoResponse(userServices.getUser(userName));
    }
    // modify user
    @PutMapping
    public ResponseEntity<Void> UpdateUser(
            @RequestBody UpdateUserDtoRequest request
    ) {
        userServices.updateUser(userMapper.toUsersUpdate(request));
        return ResponseEntity.ok().build();
    }

    // login
    @PostMapping("/login")
    public Boolean Login(
            @RequestBody LoginDtoRequest request
    ) {
        return userServices.login(request.userName(), request.password());
    }
    //
    // display of all address for one user
    @GetMapping("/address/{userId}")
    public List<AddressesDtoResponse> getUserAddress(
            @PathVariable("userId") UUID userId
    ) {
        return userServices.getAddressesByUserId(userId)
                .stream()
                .map(addressMapper::toAddressDtoResponse)
                .toList();
    }
}
