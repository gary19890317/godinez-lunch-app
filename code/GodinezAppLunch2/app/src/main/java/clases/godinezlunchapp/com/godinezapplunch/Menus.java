package clases.godinezlunchapp.com.godinezapplunch;

import java.util.ArrayList;
import java.util.List;

public class Menus {
	protected static List<MenuComida> vectorMenus = ejemploMenus();
	
    public Menus() {
        vectorMenus = ejemploMenus();
    }
    
    static MenuComida elemento(int id){
        return vectorMenus.get(id);
    }
    
    static void anyade(MenuComida menu){
        vectorMenus.add(menu);
    }
    
    static int nuevo(){
    	MenuComida menu = new MenuComida();
        vectorMenus.add(menu);
        return vectorMenus.size()-1;
    }
    
    static void borrar(int id){
        vectorMenus.remove(id);
    }
    
    public static int size() {
        return vectorMenus.size();
    }
    
    public static ArrayList<MenuComida> ejemploMenus() {
        ArrayList<MenuComida> menus = new ArrayList<MenuComida>();
        menus.add(new MenuComida("Chiles Rellenos",
          100.00,"delicioso chile relleno"
         , 3,new Foto(R.drawable.chiles)));
        
         menus.add(new MenuComida("Milanesa",45.00,
         "Milanesa con ensalada",
          3, new Foto(R.drawable.milanesa)));
         
         menus.add(new MenuComida("Enchiladas",19.4027756,
         "Enchiladas con frijoles.", 
          5));     
        
         
         return menus;
      }
}
