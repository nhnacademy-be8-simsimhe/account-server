package com.simsimbookstore.accountserver.request;


import com.simsimbookstore.accountserver.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LocalUserRequest {
    private Long id;
    private String name;
    private String mobile_number;
    private String email;
    private Date birthday;
    private User.Gender gender;
    private User.State state = User.State.ACTIVE;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime latestLoginDate;

    private String loginId;
    private String password;

    private Long gradeId = 1l;

    private Long roleId = 1l;
}
