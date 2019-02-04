package com.example.demo.repository;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long>{
	
	@Query("SELECT t FROM Calificacion t where t.tienda = :tienda AND t.eliminado=0")
	Collection<Calificacion> findBytienda(@Param("tienda") Long tienda);
	
	@Query("SELECT t FROM Calificacion t where t.compra = :compra AND t.eliminado=0")
	Collection<Calificacion> findBycompra(@Param("compra") Long compra);
	
	@Query("SELECT t FROM Calificacion t where t.usuario = :usuario AND t.eliminado=0")
	Collection<Calificacion> findByusuario(@Param("usuario") Long usuario);
	
	@Query("SELECT t FROM Calificacion t where t.tienda = :tienda AND t.fecha BETWEEN :fechai AND :fechaf AND t.eliminado=0")
    public Collection<Calificacion> findByTiendaAndFecha(@Param("tienda") Long id, 
                                                    @Param("fechai") Date fechai,
                                                    @Param("fechaf") Date fechaf);

}
