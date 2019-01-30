package com.homecontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homecontrol.domain.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}
