package com.simsimbookstore.accountserver.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String mobile_number;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date birthday;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime latestLoginDate;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "gradeId", nullable = false)
//    private UserGrade grade;

    @Column(nullable = false)
    private Long gradeId = 1l;

    @Column(nullable = false)
    private Long roleId = 1l;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private OauthUser oauthUser;
//

    public enum State{
        ACTIVE,
        INACTIVE,
        SLEEP
    }

    public enum Gender{
        MALE,
        FEMALE
    }
}
