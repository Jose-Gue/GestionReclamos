package gestionreclamos1;

/**
 *
 * @author salaz
 */
public class ArbolReclamos {
    private NodoArbol raiz;
    
    public ArbolReclamos(){
        this.raiz = null;
    }
    
    public void insertar(Reclamo reclamo){
        raiz = insertarRec(raiz, reclamo);
    }
    
    public NodoArbol insertarRec(NodoArbol nodo, Reclamo reclamo){
        if(nodo == null){
            return new NodoArbol(reclamo);
        }
        
        int codigoIngresado = reclamo.getCodigo();
        int codigoActual = nodo.getReclamo().getCodigo();
        
        //Comparamos codigos
        
        if(codigoIngresado < codigoActual){
            nodo.setIzquierda(insertarRec(nodo.getIzquierda(), reclamo));
        }
        else if(codigoIngresado> codigoActual){
            nodo.setDerecha(insertarRec(nodo.getDerecha(), reclamo));
        }
        return nodo;
        
    }
    
    public Reclamo buscar(int codigo){
        return buscarRec(raiz, codigo);
    }
    
    public Reclamo buscarRec(NodoArbol nodo, int codigo){
        if(nodo == null){
            return null;
            
        }
        
        int codigoActual = nodo.getReclamo().getCodigo();
        
        if(codigo  == codigoActual){
            return nodo.getReclamo();
        }
        
        else if(codigo < codigoActual){
            return buscarRec(nodo.getIzquierda(), codigo);
            
        }else{
            return buscarRec(nodo.getDerecha(), codigo);
        }
    }
    
    
}
