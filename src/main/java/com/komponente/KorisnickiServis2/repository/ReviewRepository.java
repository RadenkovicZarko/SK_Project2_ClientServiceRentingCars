package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Review;
import com.komponente.KorisnickiServis2.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query(value="select review.* from company join review on (company.id=review.id_company_id) WHERE company.city=?1",nativeQuery = true)
    Optional<List<Review>> findAllReviewForCity(String city);

    @Query(value="select review.* from company join review on (company.id=review.id_company_id) WHERE company.name=?1",nativeQuery = true)
    Optional<List<Review>> findAllReviewForCompany(String companyName);

}
