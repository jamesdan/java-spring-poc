package com.jamesdan.java_spring_poc.repository;

import com.jamesdan.java_spring_poc.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
