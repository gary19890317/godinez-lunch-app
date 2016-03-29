package com.mx.udev.godinez.vo;

import java.io.Serializable;

/**
 * The Class HorarioVO.
 */
public class HorarioVO implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Long id;
	
	/** The horario apertura. */
	private String horarioApertura;
	
	/** The horario cierre. */
	private String horarioCierre;

	/** The dia. */
	private DiaVO dia;
	
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

	/**
	 * @return the dia
	 */
	public DiaVO getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(DiaVO dia) {
		this.dia = dia;
	}
	
}
