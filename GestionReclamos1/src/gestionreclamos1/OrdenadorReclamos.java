package gestionreclamos1;

import java.util.ArrayList;

public class OrdenadorReclamos {

    public void ordenarBurbujaPorPrioridad(ArrayList<Reclamo> lista) {
        int n = lista.size();
        
        for (int i = 0;i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getPrioridad() > lista.get(j + 1).getPrioridad()) {
                    Reclamo temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
        System.out.println("Lista ordenada por prioridad (Bubble Sort).");
    }

    public void quickSortPorCodigo(ArrayList<Reclamo> lista, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(lista, inicio, fin);
            
            quickSortPorCodigo(lista, inicio, indiceParticion - 1);
            quickSortPorCodigo(lista, indiceParticion + 1, fin);
        }
    }

    private int particion(ArrayList<Reclamo> lista, int inicio, int fin) {
        int pivote = lista.get(fin).getCodigo();
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            if (lista.get(j).getCodigo() <= pivote) {
                i++;
                Reclamo temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }
        Reclamo temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(fin));
        lista.set(fin, temp);
        
        return i + 1;
    }

    public void ordenarInsercionPorFechaLimite(ArrayList<Reclamo> lista) {
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            Reclamo actual = lista.get(i);
            int j = i - 1;
            
            while (j >= 0 && lista.get(j).getFechaLimite().compareTo(actual.getFechaLimite()) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, actual);
        }
        System.out.println("Lista ordenada por fecha límite (Insertion Sort).");
    }

    public Reclamo busquedaBinariaPorCodigo(ArrayList<Reclamo> listaOrdenada, int codigoBuscado) {
        int inicio = 0;
        int fin = listaOrdenada.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int codigoMedio = listaOrdenada.get(medio).getCodigo();

            if (codigoMedio == codigoBuscado) {
                return listaOrdenada.get(medio);
            }
            if (codigoMedio < codigoBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }
}