package gestionreclamos1;

public class ArbolAVL {
    private NodoAVL raiz;
    
    
    
    public ArbolAVL(){
        this.raiz = null;
        
    }
    
    private int altura(NodoAVL nodo){
        if(nodo == null) return 0;
        return nodo.getAltura();
        
    }
     
    private int getBalance(NodoAVL nodo){
        if(nodo == null) return 0;
        return altura(nodo.getIzquierda()) - altura(nodo.getDerecha());
        
    }
    
    private void actualizarAltura(NodoAVL nodo){
        int h1 = altura(nodo.getIzquierda());
        int h2 = altura(nodo.getDerecha());
        nodo.setAltura(1 + Math.max(h1, h2));
        
    }
    
    private NodoAVL rotarDerecha(NodoAVL y){
        NodoAVL x = y.getIzquierda();
        NodoAVL temp = x.getDerecha();
        
        x.setDerecha(y);
        y.setIzquierda(temp);
        
        actualizarAltura(y);
        actualizarAltura(x);
        
        return x;
        
    }
    
    private NodoAVL rotarIzquierda(NodoAVL x){
        NodoAVL y = x.getDerecha();
        NodoAVL temp = y.getIzquierda();
        
        y.setIzquierda(x);
        x.setDerecha(temp);
        
        actualizarAltura(x);
        actualizarAltura(y);
        
        return y;
        
    }
    
    public void insertar(Reclamo reclamo){
        raiz = insertarRec(raiz, reclamo);
        
    }
    
    private NodoAVL insertarRec(NodoAVL nodo, Reclamo reclamo){
        
        if(nodo == null){
            return new NodoAVL(reclamo);
            
        }
        
        int codigoNuevo = reclamo.getCodigo();
        int codigoActual = nodo.getReclamo().getCodigo();
        
        if(codigoNuevo < codigoActual){
            nodo.setIzquierda(insertarRec(nodo.getIzquierda(), reclamo));
        }else if(codigoNuevo > codigoActual){
            
            nodo.setDerecha(insertarRec(nodo.getDerecha(), reclamo));
        }else{
            
            return nodo;
            
        }
        
        
        actualizarAltura(nodo);
        
        
        int balance = getBalance(nodo);
        
        if(balance > 1 && codigoNuevo < nodo.getIzquierda().getReclamo().getCodigo()){
            return rotarDerecha(nodo);
            
        }
        
        if(balance < -1 && codigoNuevo > nodo.getDerecha().getReclamo().getCodigo()){
            return rotarIzquierda(nodo);
            
        }
        
        if(balance > 1 && codigoNuevo > nodo.getIzquierda().getReclamo().getCodigo()){
            nodo.setIzquierda(rotarIzquierda(nodo.getIzquierda()));
            return rotarDerecha(nodo);
            
        }
        
        if(balance < -1 && codigoNuevo < nodo.getDerecha().getReclamo().getCodigo()){
            nodo.setDerecha(rotarDerecha(nodo.getDerecha()));
            return rotarIzquierda(nodo);
            
        }
        
        return nodo;
    }
    
    public Reclamo buscar(int codigo){
        return buscarRec(raiz, codigo);
    }
    
    private Reclamo buscarRec(NodoAVL nodo, int codigo){
        if(nodo == null){
            return null;
        }
        
        int codigoActual = nodo.getReclamo().getCodigo();
        
        if(codigo == codigoActual){
            return nodo.getReclamo();
        }else if(codigo < codigoActual){
            return buscarRec(nodo.getIzquierda(), codigo);
        }else{
            return buscarRec(nodo.getDerecha(), codigo);
        }
    }
    
    public void mostrarInOrden(){
        if(raiz == null){
            System.out.println("No hay reclamos registrados");
        }else{
            inOrden(raiz);
        }
    }
    
    private void inOrden(NodoAVL nodo){
        if(nodo != null){
            inOrden(nodo.getIzquierda());
            System.out.println(nodo.getReclamo().toString());
            inOrden(nodo.getDerecha());
        }
    }
    
    public void mostrarPreOrden(){
        if(raiz == null){
            System.out.println("No hay reclamos registrados");
        }else{
            preOrden(raiz);
            
        }
    }
    
    private void preOrden(NodoAVL nodo){
        if(nodo != null){
            System.out.println(nodo.getReclamo().toString());
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
    
    private void postOrden(NodoAVL nodo){
        if(nodo != null){
            postOrden(nodo.getIzquierda());
            postOrden(nodo.getDerecha());
            System.out.println(nodo.getReclamo().toString());
            
            
        }
        
    }
    
}
