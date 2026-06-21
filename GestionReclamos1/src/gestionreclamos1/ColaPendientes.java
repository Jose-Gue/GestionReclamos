
package gestionreclamos1;

import java.util.ArrayList;

public class ColaPendientes {
    private ArrayList<Reclamo> cola;
    
    public ColaPendientes(){
        this.cola = new ArrayList<>();
    }
    
    public void encolar(Reclamo reclamo){
        cola.add(reclamo);
    }
    
    
    public boolean estaVacia(){
        return cola.isEmpty();
    }
    
    public Reclamo desencolar(){
        if(estaVacia()){
            System.out.println("No hay reclamos pendientes");
            return null;
        }
        return cola.remove(0);
        
    }
    
    public Reclamo verFrente(){
        if(estaVacia()){
            return null;
        }
        
        return cola.get(0);
    }
    
    public int tamanio(){
        return cola.size();
    }
    
    
}
