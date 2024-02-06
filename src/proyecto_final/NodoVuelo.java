package proyecto_final;

public class NodoVuelo {
    private Vuelo vuelo;
    private NodoVuelo siguiente;

    public NodoVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
        this.siguiente = null;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public NodoVuelo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVuelo siguiente) {
        this.siguiente = siguiente;
    }
}
