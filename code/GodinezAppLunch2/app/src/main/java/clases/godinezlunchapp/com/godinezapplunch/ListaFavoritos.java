package clases.godinezlunchapp.com.godinezapplunch;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ListaFavoritos extends ListActivity implements LocationListener {

	private static final long DOS_MINUTOS = 2 * 60 * 1000;

	public AdaptadorLugares adaptador;
	private LocationManager manejador;
	private Location mejorLocaliz;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_lugares);
		adaptador = new AdaptadorLugares(this);
		setListAdapter(adaptador);
		manejador = (LocationManager) getSystemService(LOCATION_SERVICE);
		if (manejador.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			actualizaMejorLocaliz(manejador
					.getLastKnownLocation(LocationManager.GPS_PROVIDER));
		}
		if (manejador.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			actualizaMejorLocaliz(manejador
					.getLastKnownLocation(LocationManager.NETWORK_PROVIDER));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		// if (id == R.id.a) {
		// return true;
		// }
		switch (id) {
		case R.id.menu_buscar:
			lanzarVistaLugar(null);
			return true;
		case R.id.menu_mapa:
			Intent intent = new Intent(this, Mapa.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	public void lanzarVistaLugar(View view) {
		// Intent i = new Intent(this, VistaLugar.class);
		// i.putExtra("id", (long)0);
		// startActivity(i);
		final EditText entrada = new EditText(this);
		entrada.setText("0");
		new AlertDialog.Builder(this).setTitle("Selecci�n de lugar")
				.setMessage("indica su id:").setView(entrada)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						long id = Long.parseLong(entrada.getText().toString());
						Intent i = new Intent(ListaFavoritos.this, VistaLugar.class);
						i.putExtra("id", id);
						startActivity(i);
					}
				}).setNegativeButton("Cancelar", null).show();
	}

	@Override
	protected void onListItemClick(ListView listView, View vista, int position,
			long id) {
		super.onListItemClick(listView, vista, position, id);
		Intent i = new Intent(this, VistaLugar.class);
		i.putExtra("id", id);
		startActivity(i);
	}

	@Override
	protected void onResume() {
		super.onResume();
		activarProveedores();
	}

	private void activarProveedores() {
		if (manejador.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			manejador.requestLocationUpdates(LocationManager.GPS_PROVIDER,
					20 * 1000, 5, this);
		}
		if (manejador.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			manejador.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
					10 * 1000, 10, this);
		}
	}

	private void actualizaMejorLocaliz(Location localiz) {
		if (localiz != null
				&& (mejorLocaliz == null
						|| localiz.getAccuracy() < 2 * mejorLocaliz
								.getAccuracy() || localiz.getTime()
						- mejorLocaliz.getTime() > DOS_MINUTOS)) {
			Log.d(Lugares.TAG, "Nueva mejor localizaci�n");
			mejorLocaliz = localiz;
			Lugares.posicionActual.setLatitud(localiz.getLatitude());
			Lugares.posicionActual.setLongitud(localiz.getLongitude());
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		manejador.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {
		Log.d(Lugares.TAG, "Nueva localizaci�n: " + location);
		actualizaMejorLocaliz(location);
	}

	@Override
	public void onProviderDisabled(String proveedor) {
		Log.d(Lugares.TAG, "Se deshabilita: " + proveedor);
		activarProveedores();
	}

	@Override
	public void onProviderEnabled(String proveedor) {
		Log.d(Lugares.TAG, "Se habilita: " + proveedor);
		activarProveedores();
	}

	@Override
	public void onStatusChanged(String proveedor, int estado, Bundle extras) {
		Log.d(Lugares.TAG, "Cambia estado: " + proveedor);
		activarProveedores();
	}
}