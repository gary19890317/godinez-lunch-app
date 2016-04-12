package clases.godinezlunchapp.com.godinezapplunch;

import java.util.ArrayList;
import java.util.List;

public class Lugares {
	
	final static String TAG = "GodinezLunchApp";
	
	protected static GeoPunto posicionActual = new GeoPunto(0, 0);
	protected static List<Lugar> vectorLugares = ejemploLugares();
	
    public Lugares() {
        vectorLugares = ejemploLugares();
    }
    
    static Lugar elemento(int id){
        return vectorLugares.get(id);
    }
    
    static void anyade(Lugar lugar){
        vectorLugares.add(lugar);
    }
    
    static int nuevo(){
        Lugar lugar = new Lugar();
        vectorLugares.add(lugar);
        return vectorLugares.size()-1;
    }
    
    static void borrar(int id){
        vectorLugares.remove(id);
    }
    
    public static int size() {
        return vectorLugares.size();
    }
    
    public static ArrayList<Lugar> ejemploLugares() {
        ArrayList<Lugar> lugares = new ArrayList<Lugar>();
        lugares.add(new Lugar("Yenee' Gendaroo",
         "Barajas Lozano local B",  -99.150904,19.404724,
         TipoLugar.RESTAURANTE,5563212649L, "https://www.facebook.com/Gendaroo",
         "Yenee guendaroo Es un rincon istme�o ubicado en la popular colonia Buenos Aires.", 3,new Foto(R.drawable.yenee)));
        
         lugares.add(new Lugar("Fonda Argentina Viaducto",
         "Viaducto M. Alem�n #80,Benito Juarez,Atenor Salas,03010 Ciudad de M�xico, D.F.",
         -99.1548012,19.404738, TipoLugar.RESTAURANTE, 5524540045L, "http://www.fondaargentina.com",
         "Desde 1993.", 3, new Foto(R.drawable.argentina)));
         
         lugares.add(new Lugar("Toks Parque Delta",
         "Av. Cuauht�moc 462,Benito Ju�rez,Parque Delta,Piedad Narvarte, 03000 Ciudad de M�xico, D.F.", 
         -99.1545602,19.4027756, TipoLugar.BAR, 
         5554403379L, "http://www.toks.com.mx",
         "Lo mejor.", 5));
         
         lugares.add(new Lugar("Restaurante Todo Bueno",
         "Calz Legaria,11410 Ciudad de M�xico, D.F.", 
         -99.1968206,19.455112, TipoLugar.RESTAURANTE,
         5559148187L, "",
         "Esl buen sason.", 4));
         
         lugares.add(new Lugar("La Caba�a del Rey",
         "Calz Legaria 46-A,Torre Blanca, Miguel Hidalgo,11280 Ciudad de M�xico, D.F.", 
         -99.1932084,19.457016, TipoLugar.BAR,
         5553866202L, "",
         "El mejor bar.", 2));
         
         return lugares;
      }
}
