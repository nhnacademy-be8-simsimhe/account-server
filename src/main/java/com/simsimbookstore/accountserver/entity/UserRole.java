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
@Table(name = "user_roles")
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role roleName;

    public enum Role{
        USER(1L),
        ADMIN(2L);

        private final Long index;
        Role(Long index){
            this.index =index;
        }
    }

    public static UserRole getDefault(){
        UserRole role = new UserRole();
        role.setRoleName(Role.USER);
        return role;
    }
}
