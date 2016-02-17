package com.godinezlunchapp.clases;


public class MenuComida {
	private String comida;
	private double precio;
	private String descripcion;
	private float valoracion;
	private Foto foto;
	
	public MenuComida(String comida, double precio, String descripcion, float valoracion) {
		this.comida = comida;
		this.precio = precio;
		this.descripcion = descripcion;
		this.valoracion = valoracion;
	}
	
	public MenuComida(String comida, double precio, String descripcion, float valoracion, Foto foto) {
		this.comida = comida;
		this.precio = precio;
		this.descripcion = descripcion;
		this.valoracion = valoracion;
		this.setFoto(foto);
	}
	
	public MenuComida() {
	}
	
	public String getComida() {
		return comida;
	}
	public void setComida(String comida) {
		this.comida = comida;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
	
}
