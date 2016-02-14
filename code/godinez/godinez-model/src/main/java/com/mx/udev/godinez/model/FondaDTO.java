package com.mx.udev.godinez.model;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "FONDA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FondaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_FONDA")
	private Long id;
	
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Basic
	@Column(name = "LATITUD")
	private String latitud;
	
	@Basic
	@Column(name = "LONGITUD")
	private String longitud;
	
	@Basic
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Basic
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Basic
	@Column(name = "HABILITADO")
	private Long habilitado;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the habilitado
	 */
	public Long getHabilitado() {
		return habilitado;
	}

	/**
	 * @param habilitado the habilitado to set
	 */
	public void setHabilitado(Long habilitado) {
		this.habilitado = habilitado;
	}
	
}
