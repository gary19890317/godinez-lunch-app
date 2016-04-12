package clases.godinezlunchapp.com.godinezapplunch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

import java.io.File;

public class VistaLugar extends Activity {
	private long id;
	private Lugar lugar;

	private ImageView imageView;
	final static int RESULTADO_EDITAR = 1;
	final static int RESULTADO_GALERIA = 2;
	final static int RESULTADO_FOTO = 3;

	private Uri uriFoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vista_lugar);
		Bundle extras = getIntent().getExtras();
		id = extras.getLong("id", -1);
		lugar = Lugares.elemento((int) id);
		imageView = (ImageView) findViewById(R.id.foto);
		actualizarVistas();
	}

	private void actualizarVistas() {
		TextView nombre = (TextView) findViewById(R.id.nombre);
		nombre.setText(lugar.getNombre());
		ImageView logo_tipo = (ImageView) findViewById(R.id.logo_tipo);
		logo_tipo.setImageResource(lugar.getTipo().getRecurso());
		TextView tipo = (TextView) findViewById(R.id.tipo);
		tipo.setText(lugar.getTipo().getTexto());
		if (lugar.getDireccion().length() == 0) {
			findViewById(R.id.v_direccion).setVisibility(View.GONE);
		} else {
			TextView direccion = (TextView) findViewById(R.id.direccion);
			direccion.setText(lugar.getDireccion());
		}
		if (lugar.getTelefono() == 0) {
			findViewById(R.id.v_telefono).setVisibility(View.GONE);
		} else {
			TextView telefono = (TextView) findViewById(R.id.telefono);
			telefono.setText(Long.toString(lugar.getTelefono()));
		}
		if (lugar.getUrl().length() == 0) {
			findViewById(R.id.v_url).setVisibility(View.GONE);
		} else {
			TextView url = (TextView) findViewById(R.id.url);
			url.setText(lugar.getUrl());
		}
		if (lugar.getComentario().length() == 0) {
			findViewById(R.id.v_comentario).setVisibility(View.GONE);
		} else {
			TextView comentario = (TextView) findViewById(R.id.comentario);
			comentario.setText(lugar.getComentario());
		}
		
		RatingBar valoracion = (RatingBar) findViewById(R.id.valoracion);
		valoracion.setRating(lugar.getValoracion());
		valoracion
				.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
					@Override
					public void onRatingChanged(RatingBar ratingBar,
							float valor, boolean fromUser) {
						lugar.setValoracion(valor);
					}
				});
		ponerFoto(imageView, lugar.getFoto());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.vista_lugar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.accion_compartir:
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT,
					lugar.getNombre() + " " + lugar.getUrl());
			startActivity(intent);
			return true;
		case R.id.accion_llegar:
			verMapa(null);
			return true;
		case R.id.accion_editar:
			Intent i = new Intent(VistaLugar.this, EdicionLugar.class);
			i.putExtra("id", id);
			startActivityForResult(i, RESULTADO_EDITAR);
			return true;
		case R.id.accion_borrar:
			new AlertDialog.Builder(this)
					.setTitle("Borrado de lugar")
					.setMessage(
							"�Est�s seguro que quieres eliminar este lugar?")
					.setNegativeButton("Cancelar", null)
					.setPositiveButton("Confirmar",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int whichButton) {
									Lugares.borrar((int) id);
									finish();
								}
							}).show();

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == RESULTADO_EDITAR) {
			actualizarVistas();
			findViewById(R.id.scrollView1).invalidate();
		} else if (requestCode == RESULTADO_GALERIA
				&& resultCode == Activity.RESULT_OK) {
			lugar.setFoto(new Foto(data.getDataString()));
			Lugares.elemento(Integer.valueOf("" + id)).setFoto(lugar.getFoto());
			ponerFoto(imageView, lugar.getFoto());
		} else if (requestCode == RESULTADO_FOTO
				&& resultCode == Activity.RESULT_OK && lugar != null
				&& uriFoto != null) {
			lugar.setFoto(new Foto(uriFoto.toString()));
			Lugares.elemento(Integer.valueOf("" + id)).setFoto(lugar.getFoto());
			ponerFoto(imageView, lugar.getFoto());
		}
	}

	public void verMapa(View view) {
		Uri uri;
		double lat = lugar.getPosicion().getLatitud();
		double lon = lugar.getPosicion().getLongitud();
		if (lat != 0 || lon != 0) {
			uri = Uri.parse("geo:" + lat + "," + lon);
		} else {
			uri = Uri.parse("geo:0.0?q=" + lugar.getDireccion());
		}
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}

	public void llamadaTelefono(View view) {
		startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
				+ lugar.getTelefono())));
	}

	public void pgView(View view) {
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(lugar.getUrl())));
	}

	public void galeria(View view) {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		intent.setType("image/*");
		startActivityForResult(intent, RESULTADO_GALERIA);
	}

	protected void ponerFoto(ImageView imageView, Foto uri) {
		if (uri != null) {
			if (uri.getFoto() != null && !uri.getFoto().isEmpty())
				imageView.setImageURI(Uri.parse(uri.getFoto()));
			else
				imageView.setImageResource(uri.getRecurso());
		} else {
//			imageView.setImageBitmap(null);
			imageView.setImageResource(R.drawable.no_imagen);
		}
	}

	public void tomarFoto(View view) {
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		uriFoto = Uri.fromFile(new File(Environment
				.getExternalStorageDirectory()
				+ File.separator
				+ "img_"
				+ (System.currentTimeMillis() / 1000) + ".jpg"));
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto);
		startActivityForResult(intent, RESULTADO_FOTO);
	}

	public void eliminarFoto(View view) {
		lugar.setFoto(null);
		ponerFoto(imageView, null);
	}
	
	public void lanzarMenus(View view) {
		Intent i = new Intent(this,ListaMenus.class);
		startActivity(i);
	}
}
