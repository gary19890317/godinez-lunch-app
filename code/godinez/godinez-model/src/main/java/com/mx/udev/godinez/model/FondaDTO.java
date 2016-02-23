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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FONDA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "SEQ_ID_FONDA", sequenceName = "SEQ_ID_FONDA", allocationSize = 1, initialValue = 1)
public class FondaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_FONDA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_FONDA")
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

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "HORARIO_SERVICIO", 
		joinColumns = @JoinColumn(name = "ID_FONDA"), 
		inverseJoinColumns = @JoinColumn(name = "ID_HORARIO"))
	private List<HorarioDTO> horarios;
	
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

	/**
	 * @return the horarios
	 */
	public List<HorarioDTO> getHorarios() {
		if(horarios == null){
			return new ArrayList<HorarioDTO>(); 
		}
		return horarios;
	}

	/**
	 * @param horarios the horarios to set
	 */
	public void setHorarios(List<HorarioDTO> horarios) {
		this.horarios = horarios;
	}
	
}
