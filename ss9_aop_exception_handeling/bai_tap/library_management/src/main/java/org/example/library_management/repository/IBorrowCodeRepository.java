package org.example.library_management.repository;

import org.example.library_management.entity.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode, Long> {
    Optional<BorrowCode> findByCode(String code);
}
