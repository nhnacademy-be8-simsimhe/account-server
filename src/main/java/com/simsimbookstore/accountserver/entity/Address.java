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
@Table(name = "addresses")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne()
    @JoinColumn(name ="userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String roadAddress;

    @Column(nullable = false)
    private String detailedAddress;
}
