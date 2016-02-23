package com.mx.udev.godinez.model;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "SEQ_ID_USUARIO", sequenceName = "SEQ_ID_USUARIO", allocationSize = 1, initialValue = 1)
public class UsuarioDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_USUARIO")
	private Long id;
	
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Basic
	@Column(name = "USUARIO")
	private String usuario;
	
	@Basic
	@Column(name = "CONTRASENA")
	private String contrasena;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "FONDA_FAVORITO", 
		joinColumns = @JoinColumn(name = "ID_USUARIO"), 
		inverseJoinColumns = @JoinColumn(name = "ID_FONDA"))
	private List<FondaDTO> restaurants;

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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * @return the restaurants
	 */
	public List<FondaDTO> getRestaurants() {
		return restaurants;
	}

	/**
	 * @param restaurants the restaurants to set
	 */
	public void setRestaurants(List<FondaDTO> restaurants) {
		this.restaurants = restaurants;
	}
	
}
