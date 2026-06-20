package gestionreclamos1;

public class ListaDinamica {
    private NodoReclamo cabeza;
    
    public ListaDinamica(){
        this.cabeza = null;
    }
    
    public void agregar(Reclamo reclamo){
        NodoReclamo nuevoNodo = new NodoReclamo(reclamo);
        
        if(cabeza == null){
            cabeza = nuevoNodo;
            
        }else{
            NodoReclamo nodoActual = cabeza;
            
            while(nodoActual.getSiguiente() != null){
                nodoActual = nodoActual.getSiguiente();
            }
            
            nodoActual.setSiguiente(nuevoNodo);
            
        }
        
    }
    
    
    public boolean eliminar(int codigo){
        if(cabeza == null){
            return false;
            
        }
        
        if(cabeza.getReclamo().getCodigo() == codigo){
            cabeza = cabeza.getSiguiente();
            return true;
        }
        
        NodoReclamo anterior = cabeza;
        NodoReclamo actual = cabeza.getSiguiente();
        
        while(actual != null){
            if(actual.getReclamo().getCodigo() == codigo){
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    
    public void mostrarTodos(){
        if(cabeza == null){
            System.out.println("No hay reclamos registrados.");
            return;
        }
        
        NodoReclamo actual = cabeza;
        while(actual != null){
            System.out.println(actual.getReclamo().toString());
            actual = actual.getSiguiente();
        }
    }

    
}
