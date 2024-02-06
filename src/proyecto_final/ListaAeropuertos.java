/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

/**
 *
 * @author josue
 */
public class ListaAeropuertos {

    public NodoAeropuerto nodoInicial;

    public ListaAeropuertos() {
        this.nodoInicial = null;
    }

    public NodoAeropuerto getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(NodoAeropuerto nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public boolean listaVacia() {
        return this.nodoInicial == null;
    }

    public void agregarAeropuerto(Aeropuerto aeropuerto) {
        NodoAeropuerto nuevoNodo = new NodoAeropuerto(aeropuerto);
        if (nodoInicial == null) {
            nodoInicial = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(nodoInicial);
            nodoInicial = nuevoNodo;
        }
    }
    
     public Aeropuerto obtenerAeropuertoPorIndice(int indice) {
        NodoAeropuerto actual = nodoInicial;
        int contador = 0;

        while (actual != null) {
            if (contador == indice) {
                return actual.getAeropuerto();
            }
            actual = actual.getSiguiente();
            contador++;
        }

        return null; // Si no se encuentra el aeropuerto en el índice dado
    }


    public void mostrarAeropuertos() {
        NodoAeropuerto temp = nodoInicial;
        int totalAeropuertos = 0;

        while (temp != null) {
            System.out.println("ID: " + temp.getAeropuerto().getId() + ", Nombre: " + temp.getAeropuerto().getNombre());
            totalAeropuertos++;
            temp = temp.getSiguiente();
        }

        System.out.println("Total de aeropuertos: " + totalAeropuertos);

        if (listaVacia()) {
            System.out.println("La lista de aeropuertos está vacía.");
        }
    }

}