package clases.godinezlunchapp.com.godinezapplunch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdaptadorMenus extends BaseAdapter {
	private LayoutInflater inflador; // Crea Layouts a partir del XML
	TextView comida, precio;
	ImageView foto;
	RatingBar valoracion;

	public AdaptadorMenus(Context contexto) {
		inflador = (LayoutInflater) contexto
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public View getView(int posicion, View vistaReciclada, ViewGroup padre) {
		MenuComida menuComida = Menus.elemento(posicion);
		if (vistaReciclada == null) {
			vistaReciclada = inflador.inflate(R.layout.elemento_menu, null);
		}
		Log.d("cd", menuComida.getComida());
		comida = (TextView) vistaReciclada.findViewById(R.id.comida);
		precio = (TextView) vistaReciclada.findViewById(R.id.precio);
		foto = (ImageView) vistaReciclada.findViewById(R.id.foto);
		valoracion = (RatingBar) vistaReciclada.findViewById(R.id.valoracion);
		comida.setText(menuComida.getComida());
		precio.setText(String.valueOf(menuComida.getPrecio()));
		ponerFoto(menuComida);
		valoracion.setRating(menuComida.getValoracion());

		return vistaReciclada;
	}

	public void ponerFoto(MenuComida m) {
		if (m.getFoto() != null) {
			if(m.getFoto().getFoto() != null && !m.getFoto().getFoto().isEmpty()){
			}else if(m.getFoto().getRecurso() > 0D){
			foto.setImageResource(m.getFoto().getRecurso());
			foto.setScaleType(ImageView.ScaleType.FIT_END);
			}else{
				foto.setImageResource(R.drawable.no_imagen);
			}
		}else{

			foto.setImageResource(R.drawable.no_imagen);
		}
	}

	public int getCount() {
		return Menus.size();
	}

	public Object getItem(int posicion) {
		return Menus.elemento(posicion);
	}

	public long getItemId(int posicion) {
		return posicion;
	}
}
