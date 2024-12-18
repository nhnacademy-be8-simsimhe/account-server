package com.simsimbookstore.accountserver.repository;

import com.simsimbookstore.accountserver.entity.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalUserRepository extends JpaRepository<LocalUser, Long> {

    public LocalUser findByLoginId(String loginId);
}
