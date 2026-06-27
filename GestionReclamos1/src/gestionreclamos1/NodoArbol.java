
package gestionreclamos1;


public class NodoArbol {
    private Reclamo reclamo;
    private NodoArbol izquierda;
    private NodoArbol derecha;
    
    public NodoArbol(Reclamo reclamo){
        this.reclamo = reclamo;
        this.izquierda = null;
        this.derecha = null;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }
    
    
    
    
}
    

