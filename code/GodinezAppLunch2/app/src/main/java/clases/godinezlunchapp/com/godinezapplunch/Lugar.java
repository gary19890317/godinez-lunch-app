package clases.godinezlunchapp.com.godinezapplunch;


public class Lugar {
	private String nombre;
	private String direccion;
	private GeoPunto posicion;
	private Foto foto;
	private long telefono;
	private String url;
	private String comentario;
	private long fecha;
	private float valoracion;
	private TipoLugar tipo;

	public Lugar(String nombre, String direccion, double longitud,
			double latitud, TipoLugar tipo, long telefono, String url,
			String comentario, int valoracion) {
		this.tipo = tipo;
		fecha = System.currentTimeMillis();
		posicion = new GeoPunto(longitud, latitud);
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.url = url;
		this.comentario = comentario;
		this.valoracion = valoracion;
	}
	
	public Lugar(String nombre, String direccion, double longitud,
			double latitud, TipoLugar tipo, long telefono, String url,
			String comentario, int valoracion, Foto foto) {
		this.tipo = tipo;
		fecha = System.currentTimeMillis();
		posicion = new GeoPunto(longitud, latitud);
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.url = url;
		this.comentario = comentario;
		this.valoracion = valoracion;
		this.foto = foto;
	}
	
	public Lugar() {
	     fecha = System.currentTimeMillis();
	     posicion = new GeoPunto(0,0);
	     tipo = TipoLugar.OTROS;
	 }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public GeoPunto getPosicion() {
		return posicion;
	}

	public void setPosicion(GeoPunto posicion) {
		this.posicion = posicion;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
		this.fecha = fecha;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
	
	public TipoLugar getTipo() {
		return tipo;
	}

	public void setTipo(TipoLugar tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Lugar [nombre=" + nombre + ", direccion=" + direccion
				+ ", posicion=" + posicion + ", foto=" + foto + ", telefono="
				+ telefono + ", url=" + url + ", comentario=" + comentario
				+ ", fecha=" + fecha + ", valoracion=" + valoracion + ", tipo="
				+ tipo + "]";
	}

}
