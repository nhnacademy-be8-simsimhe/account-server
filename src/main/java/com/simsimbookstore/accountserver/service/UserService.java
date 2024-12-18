package com.simsimbookstore.accountserver.service;

import com.simsimbookstore.accountserver.entity.LocalUser;
import com.simsimbookstore.accountserver.request.LocalUserRequest;
import com.simsimbookstore.accountserver.entity.User;
import com.simsimbookstore.accountserver.repository.LocalUserRepository;
import com.simsimbookstore.accountserver.repository.OauthUserRepository;
import com.simsimbookstore.accountserver.repository.UserRepository;
import com.simsimbookstore.accountserver.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final LocalUserRepository localUserRepository;
    private final OauthUserRepository oauthUserRepository;

    public User save(LocalUserRequest userRequest) {
        User user = new User();
        LocalUser localUser = new LocalUser();

        user.setName(userRequest.getName());
        user.setMobile_number(userRequest.getMobile_number());
        user.setEmail(userRequest.getEmail());
        user.setBirthday(userRequest.getBirthday());
        user.setGender(userRequest.getGender());
        user.setState(userRequest.getState());
        user.setGradeId(userRequest.getGradeId());
        user.setRoleId(userRequest.getRoleId());
        user.setCreatedAt(userRequest.getCreatedAt());

        userRepository.save(user);

        localUser.setPassword(userRequest.getPassword());
        localUser.setUserId(user.getUserId());
        localUser.setLoginId(userRequest.getLoginId());
        localUserRepository.save(localUser);
        return user;
    }

    public LocalUser findByLoginId(String loginId){
        LocalUser localUser = localUserRepository.findByLoginId(loginId);
        return localUser;
    }

    public boolean login(LoginRequest loginRequest) {
        LocalUser localUser = localUserRepository.findByLoginId(loginRequest.getLoginId());
        if (Objects.isNull(localUser)) {
            return false;
        }
        return loginRequest.getPassword().equals(localUser.getPassword());
    }
}
