
package gestionreclamos1;

import java.util.ArrayList;


public class PilaHistorial {
    
    private ArrayList<String> pila;
    
    
    public PilaHistorial(){
        this.pila = new ArrayList<>();
    }
    
    public void apilar(String cambio){
       pila.add(cambio);
    }
    
    
    public String desapilar(){
        if(estaVacia()){
            System.out.println("No hay historial registrado");
            return null;
        }
        return pila.remove(pila.size() -1);
        
    }
    
    public String verTope(){
        if(estaVacia()){
            return null;
        }
        
        return pila.get(pila.size()-1);
    }
    
    
    
    public boolean estaVacia(){
        return pila.isEmpty();
    }
    
    
    public void mostrarHistorial(){
        if(estaVacia()){
            System.out.println("No hay datos que mostrar");
        }else{
            
            for(int i = pila.size()-1; i>=0;i--){
                System.out.println("- " + pila.get(i));
            }
            
        }
    }
    
}
