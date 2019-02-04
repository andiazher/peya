package com.example.demo.repository;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long>{
	
	Collection<Calificacion> findBytienda(Long tienda);
	Collection<Calificacion> findBycompra(Long compra);
	
	@Query("SELECT t FROM Calificacion t where t.tienda = :tienda AND t.fecha BETWEEN :fechai AND :fechaf")
    public Collection<Calificacion> findByTiendaAndFecha(@Param("tienda") Long id, 
                                                    @Param("fechai") Date fechai,
                                                    @Param("fechaf") Date fechaf);

}
