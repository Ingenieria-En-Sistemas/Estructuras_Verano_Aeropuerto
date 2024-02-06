/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Aeropuerto {
    private int id;
    private String nombre;
    private List<Vuelo> vuelos;

    public Aeropuerto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.vuelos = new ArrayList<>();
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

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
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
