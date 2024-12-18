package com.simsimbookstore.accountserver.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "local_users")
@Entity
public class LocalUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long localUserId;

//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    @Column(nullable = false)
    @JoinColumn(name = "userId", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;
}
