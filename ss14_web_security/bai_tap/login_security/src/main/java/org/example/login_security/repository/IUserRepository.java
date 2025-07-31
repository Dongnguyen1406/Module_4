package org.example.login_security.repository;

import org.example.login_security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
