package gestionreclamos1;

import java.util.Scanner;
import java.util.ArrayList;

public class GestionReclamos1{

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        
        Scanner sc = new Scanner(System.in);
        ListaDinamica listaReclamos = new ListaDinamica();
        ArbolReclamos arbolReclamos = new ArbolReclamos();
        ColaPendientes pendientes = new ColaPendientes(); 
        PilaHistorial historial = new PilaHistorial();
        OrdenadorReclamos ordenador = new OrdenadorReclamos();
        ArrayList<Reclamo> listaParaOrdenar = new ArrayList<>();

        // Reclamos de prueba precargados
        Reclamo r1 = new Reclamo(101, "Juan Pérez", "12345678-9", "Alumbrado", "Poste sin luz en calle Lautaro", "10/06/2026", "Pendiente", 1, "30/06/2026");
        Reclamo r2 = new Reclamo(102, "María Soto", "98765432-1", "Residuos", "Basura no retirada hace 2 semanas", "15/06/2026", "Pendiente", 2, "05/07/2026");
        Reclamo r3 = new Reclamo(103, "Pedro Rojas", "11222333\"Residuos\", \"Basura no retirada hace 2 semanas\", \"15/06/2026\", \"Pendiente\", 2, \"05/-4", "Áreas Verdes", "Árbol caído en plaza central", "20/06/2026", "Pendiente", 3, "10/07/2026");

        listaReclamos.agregar(r1);
        arbolReclamos.insertar(r1);
        pendientes.encolar(r1);
        listaParaOrdenar.add(r1);
        historial.apilar("Reclamo ingresado (Código: 101)");

        listaReclamos.agregar(r2);
        arbolReclamos.insertar(r2);
        pendientes.encolar(r2);
        listaParaOrdenar.add(r2);
        historial.apilar("Reclamo ingresado (Código: 102)");

        listaReclamos.agregar(r3);
        arbolReclamos.insertar(r3);
        pendientes.encolar(r3);
        listaParaOrdenar.add(r3);
        historial.apilar("Reclamo ingresado (Código: 103)");

        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE GESTION DE RECLAMOS ---");
            System.out.println("1. Agregar reclamo");
            System.out.println("2. Mostrar todos los reclamos");
            System.out.println("3. Buscar reclamo por código");
            System.out.println("4. Eliminar reclamo");
            System.out.println("5. Modificar reclamo");
            System.out.println("6. Atender proximo reclamo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese Código: ");
                    int codigo = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    
                    String nombre = sc.nextLine();
                    
                    System.out.print("Ingrese RUT: ");
                    String rut = sc.nextLine();
                    System.out.print("Ingrese Tipo: ");
                    String tipo = sc.nextLine();
                    
                    System.out.print("Ingrese Descripción: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Ingrese Fecha Ingreso: ");
                    String fecha = sc.nextLine();
                    System.out.print("Ingrese Prioridad (1-3): ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Ingrese Fecha Límite: ");
                    String fechaLimite = sc.nextLine();

                    Reclamo nuevoReclamo = new Reclamo(codigo, nombre, rut, tipo, descripcion, fecha, "Pendiente", prioridad, fechaLimite);

                    listaReclamos.agregar(nuevoReclamo);
                    arbolReclamos.insertar(nuevoReclamo);
                    pendientes.encolar(nuevoReclamo);
                    listaParaOrdenar.add(nuevoReclamo); 

                    historial.apilar("Reclamo ingresado (Código: " + codigo + ")");
                    System.out.println("-> RECLAMO CREADO CON ÉXITO");
                    break;

                case 2:
                    System.out.println("\n-> TODOS LOS RECLAMOS");
                    listaReclamos.mostrarTodos();
                    break;

                case 3:
                    System.out.print("Ingrese el código a buscar: ");
                    int codBusqueda = sc.nextInt();

                    Reclamo encontrado = arbolReclamos.buscar(codBusqueda);
                    if (encontrado != null) {
                        System.out.println("Reclamo encontrado -> " + "Nombre:" + encontrado.getNombre() + " Tipo: " + encontrado.getTipo()+ " | Prioridad: " + encontrado.getPrioridad());
                    } else {
                        System.out.println("-> No se encontró ningún reclamo.");
                    }
                    break;
                    
                    
                case 4:
                    System.out.print("Código del reclamo a eliminar: ");
                    int codEliminar = sc.nextInt();
                    
                    boolean seElimino = listaReclamos.eliminar(codEliminar);
                    
                    if(seElimino){
                        arbolReclamos.eliminar(codEliminar);
                        
                        historial.apilar("Reclamo eliminado (codigo: " + codEliminar + ")");
                        System.out.println("Reclamo eliminado.");
                    }else{
                        System.out.println("No existe ese reclamo");
                    }
                    break;
                    
                    case 5:
                        System.out.print("Código del reclamo a modificar: ");
                        int codModificar = sc.nextInt(); 
                        sc.nextLine();

                        Reclamo reclamoMod = arbolReclamos.buscar(codModificar);

                        if(reclamoMod != null){
                            System.out.print("Nuevo tipo: ");
                            String tipoNuevo = sc.nextLine();
                            System.out.print("Nueva descripción: ");
                            String descNueva = sc.nextLine();
                            System.out.print("Nueva prioridad (1-3): ");
                            int prioridadNueva = sc.nextInt();
                            sc.nextLine();

                            reclamoMod.setTipo(tipoNuevo);
                            reclamoMod.setDescripcion(descNueva);
                            reclamoMod.setPrioridad(prioridadNueva);

                            historial.apilar("Reclamo modificado (Código: " + codModificar + ")");
                            System.out.println("Reclamo modificado con éxito");
                            }else{
                                  System.out.println("No existe ese reclamo");
                                }
                                break;
                    
                case 6:
                   
                        Reclamo atendido = pendientes.desencolar();

                        if(atendido != null){
                            atendido.setEstado("En revisión");
                            System.out.println("Atendiendo a " + atendido.getNombre() + " (Código: " + atendido.getCodigo() + ")");
                            historial.apilar("Reclamo atendido (Código: " + atendido.getCodigo() + ")");
                        }
                        break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}

