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
    
    
    public void eliminar(int codigo){
        raiz = eliminarRec(raiz, codigo);
        
    }
    
    public NodoArbol eliminarRec(NodoArbol nodo, int codigo){
        if(nodo == null){
            return null;
        }
        
        int codigoActual = nodo.getReclamo().getCodigo();
        
        if(codigo < codigoActual){
            
            nodo.setIzquierda(eliminarRec(nodo.getIzquierda(), codigo));
            
        }else if(codigo > codigoActual){
            
            nodo.setDerecha(eliminarRec(nodo.getDerecha(), codigo));
        }else{
            
            if(nodo.getIzquierda() == null){
                return nodo.getDerecha();
            }
            if(nodo.getDerecha() == null){
                return nodo.getIzquierda();
            }
            
            NodoArbol sucesor = nodo.getDerecha();
            
            while(sucesor.getIzquierda() != null){
                
                sucesor = sucesor.getIzquierda();
            }
            nodo.setReclamo(sucesor.getReclamo());
            
            nodo.setDerecha(eliminarRec(nodo.getDerecha(), sucesor.getReclamo().getCodigo()));
        }
        return nodo;
        
    }
    
    public void mostrarInOrden(){
        if(raiz== null){
            System.out.println("No hay reclamos registrados");
        }else{
            inOrden(raiz);
        }
    }
    
    private void inOrden(NodoArbol nodo){
        if(nodo != null){
            
           inOrden(nodo.getIzquierda());
           
           System.out.println(nodo.getReclamo().getCodigo());
           
           inOrden(nodo.getDerecha());
            
        }
        
    }
    
    public void mostrarPreOrden(){
        if(raiz == null){
            System.out.println("No hay reclamos registrados");
        }
        else{
            preOrden(raiz);
        }
        
    }
    
    private void preOrden(NodoArbol nodo){
        if(nodo != null){
            
            System.out.println(nodo.getReclamo().getCodigo());
            
            preOrden(nodo.getIzquierda());
            
            preOrden(nodo.getDerecha());
        }
        
    }
    
    public void mostrarPostOrden(){
        if(raiz == null){
            System.out.println("No hay reclamos registrados");
            
        }else{
            postOrden(raiz);
        }
    }
    
    private void postOrden(NodoArbol nodo){
        if(nodo != null){
            
            postOrden(nodo.getIzquierda());
            postOrden(nodo.getDerecha());
            System.out.println(nodo.getReclamo().getCodigo());
            
        }
    }
    
}
