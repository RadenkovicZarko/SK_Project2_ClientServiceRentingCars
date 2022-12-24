package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
