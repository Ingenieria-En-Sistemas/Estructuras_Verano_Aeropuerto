/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

/**
 *
 * @author josue
 */
public class Aeropuerto {
    private int id;
    private String nombre;
    private ListaVuelos vuelos;

    public Aeropuerto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.vuelos = new ListaVuelos();
    }

    public int getId() {
        return id;
    }

    public String setNombre(String nombre) {
        return this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ListaVuelos getVuelos() {
        return vuelos;
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.agregarVuelo(vuelo);
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", vuelos=" + vuelos +
                '}';
    }
}
