package gestionreclamos1;


import java.util.Scanner;
import java.util.ArrayList;

public class GestionReclamos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDinamica listaReclamos = new ListaDinamica();
        ArbolReclamos arbolReclamos = new ArbolReclamos();
        ColaPendientes pendientes = new ColaPendientes();
        PilaHistorial historial = new PilaHistorial();
        OrdenadorReclamos ordenador = new OrdenadorReclamos();
        ArrayList<Reclamo> listaParaOrdenar = new ArrayList<>();
        ArbolAVL arbolAVL = new ArbolAVL();

        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE GESTION DE RECLAMOS ---");
            System.out.println("1. Agregar reclamo");
            System.out.println("2. Mostrar todos los reclamos");
            System.out.println("3. Buscar reclamo por codigo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese Codigo: ");
                    int codigo = sc.nextInt(); sc.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese RUT: ");
                    String rut = sc.nextLine();
                    System.out.print("Ingrese Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Ingrese Descripcion: ");
                    String desc = sc.nextLine();
                    System.out.print("Ingrese Fecha Ingreso: ");
                    String fecha = sc.nextLine();
                    System.out.print("Ingrese Prioridad (1-3): ");
                    int prioridad = sc.nextInt(); sc.nextLine();
                    System.out.print("Ingrese Fecha Limite: ");
                    String fechaLimite = sc.nextLine();

                    Reclamo nuevoReclamo = new Reclamo(codigo, nombre, rut, tipo, desc, fecha, "Pendiente", prioridad, fechaLimite);

                    listaReclamos.agregar(nuevoReclamo);
                    arbolReclamos.insertar(nuevoReclamo);
                    pendientes.encolar(nuevoReclamo);
                    listaParaOrdenar.add(nuevoReclamo);
                    arbolAVL.insertar(nuevoReclamo);

                    historial.apilar("Reclamo ingresado (Codigo: " + codigo + ")");
                    System.out.println("-> RECLAMO CREADO CON EXITO");
                    break;

                case 2:
                    System.out.println("\n-> TODOS LOS RECLAMOS");
                    listaReclamos.mostrarTodos();
                    break;
                    
                case 3:
                    System.out.println("Ingrese codigo a buscar");
                    int codigoBuscar = sc.nextInt(); sc.nextLine();
                    Reclamo resultado = arbolAVL.buscar(codigoBuscar);
                    if(resultado != null) {
                    System.out.println("Reclamo encontrado: " + resultado);
                    }else{
                        System.out.println("Reclamo no encontrado");
                    }
                    break;
                            
                

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}
