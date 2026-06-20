package gestionreclamos1;

public class Reclamo {
    private int codigo;
    private String nombre;
    private String rut;
    private String tipo;
    private String descripcion;
    private String fechaIngreso;
    private String estado;
    private int prioridad;
    private String fechaLimite;

    public Reclamo(int codigo, String nombre, String rut, String tipo, String descripcion, String fechaIngreso, String estado, int prioridad, String fechaLimite) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.rut = rut;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.estado = "Pendiente";
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    
    @Override
    public String toString() {
        return "Reclamo -> " + codigo + " | " + tipo + " | Estado: " + estado + " | Prioridad: " + prioridad;
    }
    
    
    
    
    
    
}
