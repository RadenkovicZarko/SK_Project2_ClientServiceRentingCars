package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Company;
import com.komponente.KorisnickiServis2.domain.Review;
import com.komponente.KorisnickiServis2.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query(value="select AVG(review.rating) from company join review on (company.id=review.company_id) WHERE company.name=?1",nativeQuery = true)
    Optional<Long> findAllReviewForCompany(String companyName);

    @Query(value="select * from company where company.name=?1",nativeQuery = true)
    Optional<Company> findByName(String companyName);

    @Query(value = "select * from company where id_manager IS NULL",nativeQuery = true)
    List<Company> findAllAvailable();

    @Query(value = "select * from company where id_manager =?1",nativeQuery = true)
    Company findCompanyByManagerId(Long id);

}
