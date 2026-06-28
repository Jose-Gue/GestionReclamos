package gestionreclamos1;

public class NodoAVL {
    
    private Reclamo reclamo;
    private NodoAVL izquierda;
    private NodoAVL derecha;
    private int altura;
    

    public NodoAVL(Reclamo reclamo){
        
        this.reclamo = reclamo;
        this.izquierda = null;
        this.derecha = null;
        this.altura = 1;
        
    }

    public Reclamo getReclamo() {
        return reclamo; }
    
    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo; }
    
    public NodoAVL getIzquierda() {
        return izquierda; }
    
    
    public void setIzquierda(NodoAVL izq) {
        this.izquierda = izq; }
    
    public NodoAVL getDerecha() {
        return derecha; }
    
    public void setDerecha(NodoAVL der) {
        this.derecha = der; }
    
    public int getAltura() {
        return altura; }
    
    
    public void setAltura(int altura) {
        this.altura = altura; }
    
    
    
}