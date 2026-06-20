
package gestionreclamos1;


public class NodoReclamo {
    private Reclamo reclamo;
    private NodoReclamo siguiente;
    
    public NodoReclamo(Reclamo reclamo){
        this.reclamo = reclamo;
        this.siguiente = null;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public NodoReclamo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoReclamo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
