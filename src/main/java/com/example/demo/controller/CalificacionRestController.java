package com.example.demo.controller;

import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CalificacioneNotFoundException;
import com.example.demo.model.Calificacion;
import com.example.demo.repository.CalificacionRepository;

@RestController
public class CalificacionRestController {
	
	@GetMapping("/calificaciones")
	Collection<Calificacion> calificaciones(){
		return this.calificacionRepository.findAll();
	}
	
	@GetMapping("/calificaciones/compra/{id}")
	Collection<Calificacion> byCompra(@PathVariable Long id) {

		return calificacionRepository.findBycompra(id);
	}
	
	@GetMapping("/calificaciones/compra")
	Collection<Calificacion> byCompra2(@RequestParam("id") Long id) {

		return calificacionRepository.findBycompra(id);
	}
	
	@GetMapping("/calificaciones/usuario")
	Collection<Calificacion> byUsuario(@RequestParam("id") Long id, 
			@RequestParam("fechai") Date fechai,
			@RequestParam("fechaf") Date fechaf) {

		return calificacionRepository.findByusuario(id, fechai, fechaf);
	}
	
	@PostMapping("/calificaciones")
	Calificacion newCalificacion(@RequestBody Calificacion newCalificacion) {
		return calificacionRepository.save(newCalificacion);
	}
	
	@GetMapping("/calificaciones/{id}")
	Calificacion byId(@PathVariable Long id) {

		return calificacionRepository.findById(id)
			.orElseThrow(() -> new CalificacioneNotFoundException(id));
	}
	
	@GetMapping("/calificaciones/tienda")
	Collection<Calificacion> byTienda(@RequestParam("id") Long id, 
			@RequestParam("fechai") Date fechai,
			@RequestParam("fechaf") Date fechaf) {

		return calificacionRepository.findByTiendaAndFecha(id, fechai, fechaf);
	}
	
	@PutMapping("/calificaciones/{id}")
	Calificacion replaceEmployee(@RequestBody Calificacion newCalificacion, @PathVariable Long id) {

		return calificacionRepository.findById(id)
			.map(calificacion -> {
				calificacion.setUsuario(newCalificacion.getUsuario());
				calificacion.setTienda(newCalificacion.getTienda());
				calificacion.setCompra(newCalificacion.getCompra());
				calificacion.setComentario(newCalificacion.getComentario());
				calificacion.setCalificacion(newCalificacion.getCalificacion());
				calificacion.setFecha(newCalificacion.getFecha());
				return calificacionRepository.save(calificacion);
			})
			.orElseGet(() -> {
				newCalificacion.setId(id);
				return calificacionRepository.save(newCalificacion);
			});
	}
	
	@DeleteMapping("/calificaciones/{id}")
	Calificacion deleteEmployee(@PathVariable Long id) {
		
		return calificacionRepository.findById(id)
				.map(calificacion -> {
					calificacion.setEliminado(true);
					return calificacionRepository.save(calificacion);
				}).orElseThrow(() -> new CalificacioneNotFoundException(id));
	}
	
	@Autowired CalificacionRepository calificacionRepository;
	
}
