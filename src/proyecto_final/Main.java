/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_final;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();
        Grafo grafo2 = new Grafo();

        grafo2.agregarAeropuerto(new Aeropuerto(0, "\tA"));
        grafo2.agregarAeropuerto(new Aeropuerto(1, "\tB"));
        grafo2.agregarAeropuerto(new Aeropuerto(2, "\tC"));
        grafo2.agregarAeropuerto(new Aeropuerto(3, "\tD"));


        grafo2.agregarVueloAlosAeropuertos(0, 1, 2); // Desde 0 hasta 1, distancia 2
        grafo2.agregarVueloAlosAeropuertos(0, 2, 5); // Desde 0 hasta 2, distancia 5
        grafo2.agregarVueloAlosAeropuertos(1, 0, 2); // Desde 1 hasta 0, distancia 2
        grafo2.agregarVueloAlosAeropuertos(1, 2, 1); // Desde 1 hasta 2, distancia 1
        grafo2.agregarVueloAlosAeropuertos(1, 3, 7); // Desde 1 hasta 3, distancia 7
        grafo2.agregarVueloAlosAeropuertos(2, 0, 5); // Desde 2 hasta 0, distancia 5
        grafo2.agregarVueloAlosAeropuertos(2, 1, 1); // Desde 2 hasta 1, distancia 1
        grafo2.agregarVueloAlosAeropuertos(2, 3, 3); // Desde 2 hasta 3, distancia 3
        grafo2.agregarVueloAlosAeropuertos(3, 1, 7); // Desde 3 hasta 1, distancia 7
        grafo2.agregarVueloAlosAeropuertos(3, 2, 3); // Desde 3 hasta 2, distancia 3

        while (true) {
            System.out.println("\n*********************************");
            System.out.println("          🛫 Menú Principal 🛬        ");
            System.out.println("*********************************");
            System.out.println("1. ✈️ Agregar Aeropuerto");
            System.out.println("2. 🌐 Agregar Vuelo");
            System.out.println("3. 📊 Mostrar Matriz de Adyacencia");
            System.out.println("4. 🚀 Mostrar Vuelos");
            System.out.println("5. 🗑️ Eliminar Aeropuerto");
            System.out.println("6. 🗑️ Eliminar Vuelo.");
            System.out.println("7. 🔄 Realizar Recorrido BubbleSort");
            System.out.println("8. 🛰️ Realizar Recorrido DFS");
            System.out.println("9. 🚀 Realizar Recorrido BFS.");
            System.out.println("10. 🌐 Realizar Recorrido Dijkstra");
            System.out.println("11. 🚪 Salir");
            System.out.println("*********************************\n");

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
                    System.out.println("\n//////// Aeropuerto agregado con éxito. ✈️ ////////\n");
                    break;

                case 2:
                    System.out.print("Ingrese el índice del aeropuerto de origen: ");
                    int origen = scanner.nextInt();
                    System.out.print("Ingrese el índice del aeropuerto de destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Ingrese la duración del vuelo: ");
                    int duracion = scanner.nextInt();
                    grafo.agregarVueloAlosAeropuertos(origen, destino, duracion);
                    System.out.println("\n//////// Vuelo agregado con éxito. 🌐 ////////\n");
                    break;

                case 3:
                    System.out.println("Matriz de Adyacencia: \n");
                    grafo.mostrarMatrizAdyacenciaConNombres();
                    break;

                case 4:
                    System.out.println("Vuelos: ");
                    grafo.mostrarTodosLosVuelos();
                    break;

                case 5:
                    System.out.print("Ingrese el índice del aeropuerto a eliminar: ");
                    int idAeropuertoAEliminar = scanner.nextInt();
                    grafo.eliminarAeropuerto(idAeropuertoAEliminar);
                    System.out.println("\n//////// Aeropuerto eliminado con éxito. 🚪 ////////\n");
                    break;

                case 6:
                    System.out.print("Ingrese el ID del vuelo a eliminar: ");
                    int idVueloAEliminar = scanner.nextInt();
                    grafo.eliminarVuelo(idVueloAEliminar);
                    System.out.println("\n//////// Vuelo eliminado con éxito. 🚪 ////////\n");

                    break;

                case 7:
                    System.out.println("\nRecorrido BubbleSort: 🔄");
                    grafo.bubbleSort();
                    break;

                case 8:
                    System.out.println("\nRecorrido DFS: 🛰️");
                    try {
                        System.out.print("Ingrese el índice del aeropuerto de inicio: ");
                        int inicioDFS = scanner.nextInt();
                        grafo.DFS(inicioDFS);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: Índice fuera de rango. Inténtelo de nuevo.");
                        scanner.nextLine();
                    }
                    break;

                case 9:
                    System.out.println("\nRecorrido BFS: 🚀");
                    try {
                        System.out.print("Ingrese el índice del aeropuerto de inicio: ");
                        int inicioBFS = scanner.nextInt();
                        grafo.BFS(inicioBFS);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: Índice fuera de rango. Inténtelo de nuevo.");
                        scanner.nextLine();
                    }

                    break;

                case 10:
                    System.out.println("\nRecorrido Dijkstra: 🌐");
                    try {
                        System.out.print("Ingrese el índice del aeropuerto de inicio: ");
                        int inicioDijkstra = scanner.nextInt();
                        grafo.dijkstra(inicioDijkstra);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: Índice fuera de rango. Inténtelo de nuevo.");
                        scanner.nextLine();
                    }
                    break;

                case 11:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        }
    }
}
