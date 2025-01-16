package com.simsimbookstore.accountserver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class JwtGenerateRequestDto {
    private Long userId;
    private String subject;
    private boolean isSocial;
}
