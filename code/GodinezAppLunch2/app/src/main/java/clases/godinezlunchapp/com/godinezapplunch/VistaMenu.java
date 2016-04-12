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

public class VistaMenu extends Activity {
	private long id;
	private MenuComida menu;

	private ImageView imageView;
	final static int RESULTADO_EDITAR = 1;
	final static int RESULTADO_GALERIA = 2;
	final static int RESULTADO_FOTO = 3;

	private Uri uriFoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vista_menu);
		Bundle extras = getIntent().getExtras();
		id = extras.getLong("id", -1);
		menu = Menus.elemento((int) id);
		imageView = (ImageView) findViewById(R.id.foto);
		actualizarVistas();
	}

	private void actualizarVistas() {
		TextView comida = (TextView) findViewById(R.id.comida);
		comida.setText(menu.getComida());
		if (menu.getPrecio() <= 0D) {
			findViewById(R.id.v_precio).setVisibility(View.GONE);
		} else {
			TextView precio = (TextView) findViewById(R.id.precio);
			precio.setText(String.valueOf(menu.getPrecio()));
		}
		if (menu.getDescripcion() == null || menu.getDescripcion().isEmpty()) {
			findViewById(R.id.v_descripcion).setVisibility(View.GONE);
		} else {
			TextView descripcion = (TextView) findViewById(R.id.descripcion);
			descripcion.setText(menu.getDescripcion());
		}
		
		RatingBar valoracion = (RatingBar) findViewById(R.id.valoracion);
		valoracion.setRating(menu.getValoracion());
		valoracion
				.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
					@Override
					public void onRatingChanged(RatingBar ratingBar,
							float valor, boolean fromUser) {
						menu.setValoracion(valor);
					}
				});
		ponerFoto(imageView, menu.getFoto());
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
					menu.getComida() + " " + menu.getPrecio());
			startActivity(intent);
			return true;
		case R.id.accion_llegar:
			
			return true;
		case R.id.accion_editar:
			
			return true;
		case R.id.accion_borrar:
			new AlertDialog.Builder(this)
					.setTitle("Borrado de lugar")
					.setMessage(
							"�Est�s seguro que quieres eliminar este Menu?")
					.setNegativeButton("Cancelar", null)
					.setPositiveButton("Confirmar",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int whichButton) {
									Menus.borrar((int) id);
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
			menu.setFoto(new Foto(data.getDataString()));
			Menus.elemento(Integer.valueOf("" + id)).setFoto(menu.getFoto());
			ponerFoto(imageView, menu.getFoto());
		} else if (requestCode == RESULTADO_FOTO
				&& resultCode == Activity.RESULT_OK && menu != null
				&& uriFoto != null) {
			menu.setFoto(new Foto(uriFoto.toString()));
			Menus.elemento(Integer.valueOf("" + id)).setFoto(menu.getFoto());
			ponerFoto(imageView, menu.getFoto());
		}
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
		menu.setFoto(null);
		ponerFoto(imageView, null);
	}
}

