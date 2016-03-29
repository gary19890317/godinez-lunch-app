package com.mx.udev.godinez.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HORARIO_SERVICIO")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "SEQ_ID_HORARIO", sequenceName = "SEQ_ID_HORARIO", allocationSize = 1, initialValue = 1)
public class HorarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_HORARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_HORARIO")
	private Long id;
	
	@Basic
	@Column(name = "HORARIO_APERTURA")
	private String horarioApertura;

	@Basic
	@Column(name = "HORARIO_CIERRE")
	private String horarioCierre;
	
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
	 * @return the restaurants
	 */
	/*public List<FondaDTO> getRestaurants() {
		return restaurants;
	}*/

	/**
	 * @param restaurants the restaurants to set
	 */
	/*public void setRestaurants(List<FondaDTO> restaurants) {
		this.restaurants = restaurants;
	}*/

	/**
	 * @return the horarioApertura
	 */
	public String getHorarioApertura() {
		return horarioApertura;
	}

	/**
	 * @param horarioApertura the horarioApertura to set
	 */
	public void setHorarioApertura(String horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	/**
	 * @return the horarioCierre
	 */
	public String getHorarioCierre() {
		return horarioCierre;
	}

	/**
	 * @param horarioCierre the horarioCierre to set
	 */
	public void setHorarioCierre(String horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

}
