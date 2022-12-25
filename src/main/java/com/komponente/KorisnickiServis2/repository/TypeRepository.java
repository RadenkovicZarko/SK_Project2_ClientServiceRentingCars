package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Type;
import com.komponente.KorisnickiServis2.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type,Long> {


}
