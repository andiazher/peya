package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calificacion {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private Long usuario;
	private Long tienda;
	private Long compra;
	private String comentario;
	private int calificacion;
	private Date fecha;
	
	public Calificacion() {
	}

	public Calificacion(Long usuario, Long tienda, Long compra, String comentario, int calificacion) {
		this.usuario = usuario;
		this.tienda = tienda;
		this.compra = compra;
		this.comentario = comentario;
		this.calificacion = calificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public Long getTienda() {
		return tienda;
	}

	public void setTienda(Long tienda) {
		this.tienda = tienda;
	}

	public Long getCompra() {
		return compra;
	}

	public void setCompra(Long compra) {
		this.compra = compra;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Calificacion [id=" + id + ", usuario=" + usuario + ", tienda=" + tienda + ", compra=" + compra
				+ ", comentario=" + comentario + ", calificacion=" + calificacion + "]";
	}
	
	
	
	
}
