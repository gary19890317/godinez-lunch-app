package clases.godinezlunchapp.com.godinezapplunch;

public class Foto {
	private String foto;
	private int recurso;
	
	public Foto(String foto, int recurso) {
		this.foto = foto;
		this.recurso = recurso;
	}
	
	public Foto(String foto) {
		this.foto = foto;
	}
	
	public Foto(int recurso) {
		this.recurso = recurso;
	}
	
	public Foto() {
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getRecurso() {
		return recurso;
	}
	public void setRecurso(int recurso) {
		this.recurso = recurso;
	}
	
	
}
