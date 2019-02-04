package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long>{
	
	Collection<Calificacion> findBytienda(String tienda);

}
