package com.komponente.KorisnickiServis2.repository;

import com.komponente.KorisnickiServis2.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
