package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/calificaciones")
	Calificacion newCalificacion(@RequestBody Calificacion newCalificacion) {
		return calificacionRepository.save(newCalificacion);
	}
	
	@GetMapping("/calificaciones/{id}")
	Calificacion one(@PathVariable Long id) {

		return calificacionRepository.findById(id)
			.orElseThrow(() -> new CalificacioneNotFoundException(id));
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
				return calificacionRepository.save(calificacion);
			})
			.orElseGet(() -> {
				newCalificacion.setId(id);
				return calificacionRepository.save(newCalificacion);
			});
	}
	
	@DeleteMapping("/calificaciones/{id}")
	void deleteEmployee(@PathVariable Long id) {
		calificacionRepository.deleteById(id);
	}
	
	@Autowired CalificacionRepository calificacionRepository;
	
}
