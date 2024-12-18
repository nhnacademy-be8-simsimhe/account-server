package com.simsimbookstore.accountserver.repository;

import com.simsimbookstore.accountserver.entity.OauthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthUserRepository extends JpaRepository<OauthUser, Long> {
}
