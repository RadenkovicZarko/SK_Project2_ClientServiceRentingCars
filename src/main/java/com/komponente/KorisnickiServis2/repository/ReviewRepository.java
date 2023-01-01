package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Review;
import com.komponente.KorisnickiServis2.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query(value="select review.* from company join review on (company.id=review.id_company_id) WHERE company.city=?1",nativeQuery = true)
    Optional<List<Review>> findAllReviewForCity(String city);

    @Query(value="select review.* from company join review on (company.id=review.id_company_id) WHERE company.name=?1",nativeQuery = true)
    Optional<List<Review>> findAllReviewForCompany(String companyName);


//    @Modifying
//    @Query(value = "update review r set r.description = ?1 , r.rating = ?2 where u.id = ?3", nativeQuery = true)
//    void updateReview(String description,  String rating, String id);

}
