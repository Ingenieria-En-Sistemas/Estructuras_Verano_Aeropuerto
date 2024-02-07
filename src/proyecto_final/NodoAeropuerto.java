/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final;

/**
 *
 * @author josue
 */
public class NodoAeropuerto {

    private Aeropuerto aeropuerto;
    private NodoAeropuerto siguiente;

    public NodoAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
        this.siguiente = null;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public NodoAeropuerto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAeropuerto siguiente) {
        this.siguiente = siguiente;
    }
}
