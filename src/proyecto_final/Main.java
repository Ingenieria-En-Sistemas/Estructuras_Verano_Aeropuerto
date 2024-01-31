/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;

/**
 *
 * @author josue
 */
// ...

// ...

public class Main {

    public static void main(String[] args) {
        Grafo grafo = new Grafo(10);

        Aeropuerto aeropuerto1 = new Aeropuerto(0, "Aeropuerto A");
        Aeropuerto aeropuerto2 = new Aeropuerto(1, "Aeropuerto B");
        Aeropuerto aeropuerto3 = new Aeropuerto(2, "Aeropuerto C");
        Aeropuerto aeropuerto4 = new Aeropuerto(3, "Aeropuerto D");
        Aeropuerto aeropuerto5 = new Aeropuerto(4, "Aeropuerto E");
        Aeropuerto aeropuerto6 = new Aeropuerto(5, "Aeropuerto F");
        Aeropuerto aeropuerto7 = new Aeropuerto(6, "Aeropuerto G");
        Aeropuerto aeropuerto8 = new Aeropuerto(7, "Aeropuerto H");
        Aeropuerto aeropuerto9 = new Aeropuerto(8, "Aeropuerto I");
        Aeropuerto aeropuerto10 = new Aeropuerto(9, "Aeropuerto J");


        grafo.agregarAeropuerto(aeropuerto1);
        grafo.agregarAeropuerto(aeropuerto2);
        grafo.agregarAeropuerto(aeropuerto3);
        grafo.agregarAeropuerto(aeropuerto4);
        grafo.agregarAeropuerto(aeropuerto5);
        grafo.agregarAeropuerto(aeropuerto6);
        grafo.agregarAeropuerto(aeropuerto7);
        grafo.agregarAeropuerto(aeropuerto8);
        grafo.agregarAeropuerto(aeropuerto9);
        grafo.agregarAeropuerto(aeropuerto10);

      
        grafo.agregarVueloAlosAeropuertos(0, 1, 500);
        grafo.agregarVueloAlosAeropuertos(1, 0, 500);
        grafo.agregarVueloAlosAeropuertos(1, 2, 300);
        grafo.agregarVueloAlosAeropuertos(2, 3, 250);
      
        System.out.println("Matriz de Adyacencia: \n");
        grafo.mostrarMatrizAdyacenciaConNombres();

     
        System.out.println("\nRecorrido BFS:");
        grafo.BFS(0);


        System.out.println("\nRecorrido DFS:");
        grafo.DFS(0);

     
        System.out.println("\nRecorrido Dijkstra:");
        grafo.dijkstra(0);

 
        System.out.println("\nRecorrido BubbleSort:");
        grafo.bubbleSort();
    }
}




