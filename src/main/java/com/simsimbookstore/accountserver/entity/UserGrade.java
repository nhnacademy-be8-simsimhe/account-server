package com.simsimbookstore.accountserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

// 유저 테이블과 단방향 유저만 티어를 알고 있으면 된다

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "user_grades")
@Entity
public class UserGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tier tier;

    @Column(nullable = false)
    private Long minAmount;

    private Long maxAmount;

    @Column(nullable = false)
    private BigDecimal pointRate;

    public enum Tier{
    //일반: Standard
    //로얄: Royal
    //골드: Gold
    //플래티넘: Platinum
        STANDARD(1L),
        ROYAL(2L),
        GOLD(3L),
        PLATINUM(4L);

        private final Long index;

        Tier(Long index) {
            this.index = index;
        }

        public static Tier fromTierId(Long tierId) {
            for (Tier tier : Tier.values()) {
                if (tier.index.equals(tierId)) {
                    return tier;
                }
            }
            throw new IllegalArgumentException("Invalid tier ID: " + tierId);
        }
    }
}
