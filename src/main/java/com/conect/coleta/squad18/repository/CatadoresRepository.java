package com.conect.coleta.squad18.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conect.coleta.squad18.model.Catadores;

@Repository
public interface CatadoresRepository extends JpaRepository<Catadores, Long>{

}
