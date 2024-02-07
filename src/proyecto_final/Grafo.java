/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Grafo {

    private int vertices;
    private final ListaAeropuertos aeropuertos;
    private int[][] matrizAdyacencia;

    public Grafo() {
        this.vertices = 0;
        this.aeropuertos = new ListaAeropuertos();
        this.matrizAdyacencia = new int[vertices][vertices];
    }

    public void agregarAeropuerto(Aeropuerto aeropuerto) {
        aeropuertos.agregarAeropuerto(aeropuerto);

        vertices++;

        int[][] nuevaMatriz = new int[vertices][vertices];
        for (int i = 0; i < vertices - 1; i++) {
            System.arraycopy(matrizAdyacencia[i], 0, nuevaMatriz[i], 0, vertices - 1);
        }
        matrizAdyacencia = nuevaMatriz;
    }

    public void eliminarAeropuerto(int id) {
        aeropuertos.eliminarAeropuerto(id);

        vertices--;

        int[][] nuevaMatriz = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                nuevaMatriz[i][j] = matrizAdyacencia[i < id ? i : i + 1][j < id ? j : j + 1];
            }
        }
        matrizAdyacencia = nuevaMatriz;
    }

    public void eliminarVuelo(int id) {
        for (int i = 0; i < vertices; i++) {
            Aeropuerto aeropuerto = aeropuertos.obtenerAeropuertoPorIndice(i);
            for (int j = 0; j < aeropuerto.getVuelos().size(); j++) {
                Vuelo vuelo = aeropuerto.getVuelos().obtenerVueloPorIndice(j);
                if (vuelo.getId() == id) {
                    aeropuerto.getVuelos().eliminarVuelo(id);
                    matrizAdyacencia[i][aeropuertos.obtenerIndiceAeropuerto(vuelo.getDestino().getId())] = 0;
                    matrizAdyacencia[aeropuertos.obtenerIndiceAeropuerto(vuelo.getDestino().getId())][i] = 0;
                    break;
                }
            }
        }
    }

    public void mostrarTodosLosVuelos() {
        for (int i = 0; i < vertices; i++) {
            Aeropuerto aeropuerto = aeropuertos.obtenerAeropuertoPorIndice(i);
            System.out.println("\nVuelos desde " + aeropuerto.getNombre() + " (" + aeropuerto.getId() + "):");
            for (int j = 0; j < aeropuerto.getVuelos().size(); j++) {
                Vuelo vuelo = aeropuerto.getVuelos().obtenerVueloPorIndice(j);
                System.out.println("ID de Vuelo: " + vuelo.getId() + ", " + vuelo.getOrigen().getNombre() + " ("
                        + vuelo.getOrigen().getId() + ") -> "
                        + vuelo.getDestino().getNombre() + " (" + vuelo.getDestino().getId() + ") en "
                        + vuelo.getDuracion()
                        + " minutos");
            }
        }
    }

    public int obtenerNuevoIdAeropuerto() {
        return aeropuertos.size();
    }

    public void agregarVueloAlosAeropuertos(int origen, int destino, int duracion) {
        matrizAdyacencia[origen][destino] = duracion;
        matrizAdyacencia[destino][origen] = duracion;

        Aeropuerto aeropuertoOrigen = aeropuertos.obtenerAeropuertoPorIndice(origen);
        Aeropuerto aeropuertoDestino = aeropuertos.obtenerAeropuertoPorIndice(destino);

        Vuelo vuelo = new Vuelo(aeropuertoOrigen, aeropuertoDestino, duracion);
        aeropuertoOrigen.agregarVuelo(vuelo);
        aeropuertoDestino.agregarVuelo(vuelo);
    }

    public void mostrarMatrizAdyacenciaConNombres() {
        System.out.print("\t");
        for (int i = 0; i < vertices; i++) {
            System.out.print(aeropuertos.obtenerAeropuertoPorIndice(i).getNombre() + " ("
                    + aeropuertos.obtenerAeropuertoPorIndice(i).getId() + ")\t");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) {
            System.out.print(aeropuertos.obtenerAeropuertoPorIndice(i).getNombre() + " ("
                    + aeropuertos.obtenerAeropuertoPorIndice(i).getId() + ")\t");
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
            System.out.print(aeropuertos.obtenerAeropuertoPorIndice(actual).getNombre() + "->");

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
        System.out.print(aeropuertos.obtenerAeropuertoPorIndice(v).getNombre() + "->");

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

        System.out.println("\nDistancias minimas desde el aeropuerto "
                + aeropuertos.obtenerAeropuertoPorIndice(inicio).getNombre() + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println(aeropuertos.obtenerAeropuertoPorIndice(i).getNombre() + ": "
                    + (distancias[i] == Integer.MAX_VALUE ? "No alcanzable" : distancias[i]));
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
        for (int i = 0; i < vertices; i++) {
            Aeropuerto aeropuerto = aeropuertos.obtenerAeropuertoPorIndice(i);
            System.out.println(aeropuerto.getNombre() + ": " + aeropuerto.getVuelos().size() + " vuelos");
        }
    }

}
