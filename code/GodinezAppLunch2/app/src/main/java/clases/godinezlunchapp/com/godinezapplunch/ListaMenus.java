package clases.godinezlunchapp.com.godinezapplunch;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class ListaMenus extends ListActivity {

	public AdaptadorMenus adaptador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_menu);
		adaptador = new AdaptadorMenus(this);
		setListAdapter(adaptador);
		
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
//        if (id == R.id.a) {
//            return true;
//        }
        switch(id){
        case R.id.menu_buscar: 
            lanzarVistaMenuComida(null);
            return true;
        case R.id.menu_mapa:
        	
        	return true;
        default: return super.onOptionsItemSelected(item);
      }
        
    }

	public void lanzarVistaMenuComida(View view) {
		// Intent i = new Intent(this, VistaMenuComida.class);
		// i.putExtra("id", (long)0);
		// startActivity(i);
		final EditText entrada = new EditText(this);
		entrada.setText("0");
		new AlertDialog.Builder(this).setTitle("Selecci�n de MenuComida")
				.setMessage("indica su id:").setView(entrada)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						long id = Long.parseLong(entrada.getText().toString());
						Intent i = new Intent(ListaMenus.this,
								VistaMenu.class);
						i.putExtra("id", id);
						startActivity(i);
					}
				}).setNegativeButton("Cancelar", null).show();
	}

	@Override
	protected void onListItemClick(ListView listView, View vista, int position,
			long id) {
		super.onListItemClick(listView, vista, position, id);
		Intent i = new Intent(this, VistaMenu.class);
		i.putExtra("id", id);
		startActivity(i);
	}

	
}
