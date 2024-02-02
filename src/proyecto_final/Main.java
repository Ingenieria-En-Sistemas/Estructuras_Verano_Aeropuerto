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
//public class Main {
//
//    public static void main(String[] args) {
//        Grafo grafo = new Grafo(10);
//
//        Aeropuerto aeropuerto1 = new Aeropuerto(0, "Aeropuerto A");
//        Aeropuerto aeropuerto2 = new Aeropuerto(1, "Aeropuerto B");
//        Aeropuerto aeropuerto3 = new Aeropuerto(2, "Aeropuerto C");
//        Aeropuerto aeropuerto4 = new Aeropuerto(3, "Aeropuerto D");
//        Aeropuerto aeropuerto5 = new Aeropuerto(4, "Aeropuerto E");
//        Aeropuerto aeropuerto6 = new Aeropuerto(5, "Aeropuerto F");
//        Aeropuerto aeropuerto7 = new Aeropuerto(6, "Aeropuerto G");
//        Aeropuerto aeropuerto8 = new Aeropuerto(7, "Aeropuerto H");
//        Aeropuerto aeropuerto9 = new Aeropuerto(8, "Aeropuerto I");
//        Aeropuerto aeropuerto10 = new Aeropuerto(9, "Aeropuerto J");
//
//        grafo.agregarAeropuerto(aeropuerto1);
//        grafo.agregarAeropuerto(aeropuerto2);
//        grafo.agregarAeropuerto(aeropuerto3);
//        grafo.agregarAeropuerto(aeropuerto4);
//        grafo.agregarAeropuerto(aeropuerto5);
//        grafo.agregarAeropuerto(aeropuerto6);
//        grafo.agregarAeropuerto(aeropuerto7);
//        grafo.agregarAeropuerto(aeropuerto8);
//        grafo.agregarAeropuerto(aeropuerto9);
//        grafo.agregarAeropuerto(aeropuerto10);
//
//        grafo.agregarVueloAlosAeropuertos(0, 2, 400);
//        grafo.agregarVueloAlosAeropuertos(2, 1, 200);
//        grafo.agregarVueloAlosAeropuertos(3, 4, 150);
//        grafo.agregarVueloAlosAeropuertos(4, 5, 200);
//        grafo.agregarVueloAlosAeropuertos(5, 6, 300);
//        grafo.agregarVueloAlosAeropuertos(7, 8, 100);
//
//        System.out.println("Matriz de Adyacencia: \n");
//        grafo.mostrarMatrizAdyacenciaConNombres();
//
//        System.out.println("\nRecorrido BFS:");
//        grafo.BFS(0);
//
//        System.out.println("\nRecorrido DFS:");
//        grafo.DFS(0);
//
//        System.out.println("\nRecorrido Dijkstra:");
//        grafo.dijkstra(0);
//
//        System.out.println("\nRecorrido BubbleSort:");
//        grafo.bubbleSort();
//    }
//}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        while (true) {
            System.out.println("\n1. Agregar Aeropuerto");
            System.out.println("2. Agregar Vuelo");
            System.out.println("3. Mostrar Matriz de Adyacencia");
            System.out.println("4. Realizar Recorrido BFS");
            System.out.println("5. Realizar Recorrido DFS");
            System.out.println("6. Realizar Recorrido Dijkstra");
            System.out.println("7. Realizar Recorrido BubbleSort");
            System.out.println("8. Salir");

            System.out.print("Ingrese la opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del aeropuerto: ");
                    String nombreAeropuerto = scanner.nextLine();
                    int idAeropuerto = grafo.obtenerNuevoIdAeropuerto(); 
                    Aeropuerto nuevoAeropuerto = new Aeropuerto(idAeropuerto, nombreAeropuerto);
                    grafo.agregarAeropuerto(nuevoAeropuerto);
                    System.out.println("\nAeropuerto agregado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el índice del aeropuerto de origen: ");
                    int origen = scanner.nextInt();
                    System.out.print("Ingrese el índice del aeropuerto de destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Ingrese la duración del vuelo: ");
                    int duracion = scanner.nextInt();
                    grafo.agregarVueloAlosAeropuertos(origen, destino, duracion);
                    System.out.println("\nVuelo agregado con éxito.");
                    break;
                case 3:
                    System.out.println("Matriz de Adyacencia: \n");
                    grafo.mostrarMatrizAdyacenciaConNombres();
                    break;
                case 4:
                    System.out.println("\nRecorrido BFS:");
                    System.out.print("Ingrese el índice del aeropuerto de inicio: ");
                    int inicioBFS = scanner.nextInt();
                    grafo.BFS(inicioBFS);
                    break;
                case 5:
                    System.out.println("\nRecorrido DFS:");
                    System.out.print("Ingrese el índice del aeropuerto de inicio: ");
                    int inicioDFS = scanner.nextInt();
                    grafo.DFS(inicioDFS);
                    break;
                case 6:
                    System.out.println("\nRecorrido Dijkstra:");
                    System.out.print("Ingrese el índice del aeropuerto de inicio: ");
                    int inicioDijkstra = scanner.nextInt();
                    grafo.dijkstra(inicioDijkstra);
                    break;
                case 7:
                    System.out.println("\nRecorrido BubbleSort:");
                    grafo.bubbleSort();
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
