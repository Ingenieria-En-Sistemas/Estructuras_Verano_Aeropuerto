package proyecto_final;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        while (true) {
            System.out.println("\n*****************************************************************");
            System.out.println("          🛫 Menú Principal 🛬        ");
            System.out.println("*****************************************************************\n");
            System.out.println("1. ✈️ Agregar Aeropuerto");
            System.out.println("2. 🌐 Agregar Vuelo");
            System.out.println("3. 🗑️ Eliminar Aeropuerto");
            System.out.println("4. 🗑️ Eliminar Vuelo.");
            System.out.println("5. 📊 Mostrar Matriz de Adyacencia");
            System.out.println("6. 🚀 Mostrar Vuelos");
            System.out.println("7. 🚀 Mostrar Aeropuertos");
            System.out.println("8. 🔄 Realizar Recorrido BubbleSort por Frecuencia de Vuelos.");
            System.out.println("9. 🚀 Relizar Recorrido BubbleSort por Promedio de Duracion de Vuelos.");
            System.out.println("10. 🛰️ Realizar Recorrido DFS");
            System.out.println("11. 🚀 Realizar Recorrido BFS.");
            System.out.println("12. 🌐 Realizar Recorrido Dijkstra digitando indice de comienzo.");
            System.out.println("13. 🚪 Salir");
            System.out.println("*****************************************************************\n");

            System.out.print("Ingrese la opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarAeropuerto(scanner, grafo);
                    break;
                case 2:
                    agregarVuelo(scanner, grafo);
                    break;
                case 3:
                    eliminarAeropuerto(scanner, grafo);
                    break;
                case 4:
                    eliminarVuelo(scanner, grafo);
                    break;
                case 5:
                    mostrarMatrizAdyacencia(grafo);
                    break;
                case 6:
                    mostrarTodosLosVuelos(grafo);
                    break;
                case 7:
                    mostrarTodosLosAeropuertos(grafo);
                    break;
                case 8:
                    bubbleSortByFlightFrequency(grafo);
                    break;
                case 9:
                    bubbleSortByAverageFlightDuration(grafo);
                    break;
                case 10:
                    realizarRecorridoDFS(scanner, grafo);
                    break;
                case 11:
                    realizarRecorridoBFS(scanner, grafo);
                    break;
                case 12:
                    realizarRecorridoDijkstra(scanner, grafo);
                    break;
                case 13:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        }
    }

    private static void agregarAeropuerto(Scanner scanner, Grafo grafo) {
        System.out.print("Ingrese el nombre del aeropuerto: ");
        String nombreAeropuerto = scanner.nextLine();
        int idAeropuerto = grafo.obtenerNuevoIdAeropuerto();
        Aeropuerto nuevoAeropuerto = new Aeropuerto(idAeropuerto, nombreAeropuerto);
        grafo.agregarAeropuerto(nuevoAeropuerto);
        System.out.println("\n//////// Aeropuerto agregado con éxito. ✈️ ////////\n");
    }

    private static void agregarVuelo(Scanner scanner, Grafo grafo) {
        System.out.print("Ingrese el índice del aeropuerto de origen: ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el índice del aeropuerto de destino: ");
        int destino = scanner.nextInt();
        System.out.print("Ingrese la duración del vuelo: ");
        int duracion = scanner.nextInt();
        grafo.agregarVueloAlosAeropuertos(origen, destino, duracion);
        System.out.println("\n//////// Vuelo agregado con éxito. 🌐 ////////\n");
    }

    private static void eliminarAeropuerto(Scanner scanner, Grafo grafo) {
        System.out.print("Ingrese el índice del aeropuerto a eliminar: ");
        int idAeropuertoAEliminar = scanner.nextInt();
        grafo.eliminarAeropuerto(idAeropuertoAEliminar);
        System.out.println("\n//////// Aeropuerto eliminado con éxito. 🚪 ////////\n");
    }

    private static void eliminarVuelo(Scanner scanner, Grafo grafo) {
        System.out.print("Ingrese el ID del vuelo a eliminar: ");
        int idVueloAEliminar = scanner.nextInt();
        grafo.eliminarVuelo(idVueloAEliminar);
        System.out.println("\n//////// Vuelo eliminado con éxito. 🚪 ////////\n");
    }

    private static void mostrarMatrizAdyacencia(Grafo grafo) {
        System.out.println("Matriz de Adyacencia: \n");
        grafo.mostrarMatrizAdyacenciaConNombres();
    }

    private static void mostrarTodosLosVuelos(Grafo grafo) {
        System.out.println("Vuelos: ");
        grafo.mostrarTodosLosVuelos();
    }

    private static void mostrarTodosLosAeropuertos(Grafo grafo) {
        System.out.println("Aeropuertos: ");
        grafo.mostrarTodosLosAeropuertos();
    }

    private static void bubbleSortByFlightFrequency(Grafo grafo) {
        System.out.println("\nRecorrido BubbleSort por Frecuencua de Vuelos: 🔄");
        grafo.bubbleSort();
    }

    private static void bubbleSortByAverageFlightDuration(Grafo grafo) {
        System.out.println("\nRecorrido BubbleSort por duracion promedio del Vuelo.: 🔄");
        grafo.bubbleSortByAverageFlightDuration();
    }

    private static void realizarRecorridoDFS(Scanner scanner, Grafo grafo) {
        System.out.println("\nRecorrido DFS: 🛰️");
        try {
            System.out.print("Ingrese el índice del aeropuerto de inicio: ");
            int inicioDFS = scanner.nextInt();
            grafo.DFS(inicioDFS);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de rango. Inténtelo de nuevo.");
            scanner.nextLine();
        }
    }

    private static void realizarRecorridoBFS(Scanner scanner, Grafo grafo) {
        System.out.println("\nRecorrido BFS: 🚀");
        try {
            System.out.print("Ingrese el índice del aeropuerto de inicio: ");
            int inicioBFS = scanner.nextInt();
            grafo.BFS(inicioBFS);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de rango. Inténtelo de nuevo.");
            scanner.nextLine();
        }
    }

    private static void realizarRecorridoDijkstra(Scanner scanner, Grafo grafo) {
        System.out.println("\nRecorrido Dijkstra: 🌐");
        try {
            System.out.print("Ingrese el índice del aeropuerto de inicio: ");
            int inicioDijkstra = scanner.nextInt();
            grafo.dijkstra(inicioDijkstra);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de rango. Inténtelo de nuevo.");
            scanner.nextLine();
        }
    }
}
