/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

/**
 *
 * @author josue
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Grafo {

    private int vertices;
    private final List<Aeropuerto> aeropuertos;
    private int[][] matrizAdyacencia;

    public Grafo() {
        this.vertices = 0;
        this.aeropuertos = new ArrayList<>();
        this.matrizAdyacencia = new int[vertices][vertices];
    }

    public void agregarAeropuerto(Aeropuerto aeropuerto) {
        aeropuertos.add(aeropuerto);

        vertices++;

        int[][] nuevaMatriz = new int[vertices][vertices];
        for (int i = 0; i < vertices - 1; i++) {
            System.arraycopy(matrizAdyacencia[i], 0, nuevaMatriz[i], 0, vertices - 1);
        }
        matrizAdyacencia = nuevaMatriz;
    }

    public int obtenerNuevoIdAeropuerto() {
        return aeropuertos.size();
    }

    public void agregarVueloAlosAeropuertos(int origen, int destino, int duracion) {
        matrizAdyacencia[origen][destino] = duracion;
        matrizAdyacencia[destino][origen] = duracion;

        Aeropuerto aeropuertoOrigen = aeropuertos.get(origen);
        Aeropuerto aeropuertoDestino = aeropuertos.get(destino);

        Vuelo vuelo = new Vuelo(aeropuertoOrigen, aeropuertoDestino, duracion);
        aeropuertoOrigen.agregarVuelo(vuelo);
        aeropuertoDestino.agregarVuelo(vuelo);
    }

    public void mostrarMatrizAdyacencia() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void mostrarMatrizAdyacenciaConNombres() {

        System.out.print("\t");
        for (Aeropuerto aeropuerto : aeropuertos) {
            System.out.print(aeropuerto.getNombre() + " (" + aeropuerto.getId() + ")\t");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) {
            System.out.print(aeropuertos.get(i).getNombre() + " (" + aeropuertos.get(i).getId() + ")\t");
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    public void BFS(int inicio) {
        boolean[] visitados = new boolean[vertices];
        Queue<Integer> cola = new LinkedList<>();

        visitados[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(aeropuertos.get(actual).getNombre() + " ");

            for (int i = 0; i < vertices; i++) {
                if (matrizAdyacencia[actual][i] != 0 && !visitados[i]) {
                    cola.add(i);
                    visitados[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void DFS(int inicio) {
        boolean[] visitados = new boolean[vertices];
        DFSUtil(inicio, visitados);
        System.out.println();
    }

    private void DFSUtil(int v, boolean[] visitados) {
        visitados[v] = true;
        System.out.print(aeropuertos.get(v).getNombre() + " ");

        for (int i = 0; i < vertices; i++) {
            if (matrizAdyacencia[v][i] != 0 && !visitados[i]) {
                DFSUtil(i, visitados);
            }
        }
    }

    public void dijkstra(int inicio) {
        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicio] = 0;

        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(i -> distancias[i]));

        colaPrioridad.add(inicio);

        while (!colaPrioridad.isEmpty()) {
            int actual = colaPrioridad.poll();

            for (int i = 0; i < vertices; i++) {
                int peso = matrizAdyacencia[actual][i];
                if (peso != 0 && distancias[actual] + peso < distancias[i]) {
                    distancias[i] = distancias[actual] + peso;
                    colaPrioridad.add(i);
                }
            }
        }

        System.out.println("\nDistancias mínimas desde el aeropuerto " + aeropuertos.get(inicio).getNombre() + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println(aeropuertos.get(i).getNombre() + ": " + (distancias[i] == Integer.MAX_VALUE ? "No alcanzable" : distancias[i]));
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < vertices - 1; i++) {
            for (int j = 0; j < vertices - i - 1; j++) {
                int vuelosA = aeropuertos.get(j).getVuelos().size();
                int vuelosB = aeropuertos.get(j + 1).getVuelos().size();

                if (vuelosA > vuelosB) {
                    Aeropuerto temp = aeropuertos.get(j);
                    aeropuertos.set(j, aeropuertos.get(j + 1));
                    aeropuertos.set(j + 1, temp);
                }
            }
        }

        System.out.println("\nAeropuertos ordenados por cantidad de vuelos (Bubble Sort):");
        for (Aeropuerto aeropuerto : aeropuertos) {
            System.out.println(aeropuerto.getNombre() + ": " + aeropuerto.getVuelos().size() + " vuelos");
        }
    }

}
