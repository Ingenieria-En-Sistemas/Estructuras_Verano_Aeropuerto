package proyecto_final;

public class ListaVuelos {
    public NodoVuelo nodoInicial;

    public ListaVuelos() {
        this.nodoInicial = null;
    }

    public NodoVuelo getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(NodoVuelo nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public boolean listaVacia() {
        return this.nodoInicial == null;
    }

    public int size() {
        int contador = 0;
        NodoVuelo temp = nodoInicial;
        while (temp != null) {
            contador++;
            temp = temp.getSiguiente();
        }
        return contador;
    }

    public void agregarVuelo(Vuelo vuelo) {
        NodoVuelo nuevoNodo = new NodoVuelo(vuelo);
        if (nodoInicial == null) {
            nodoInicial = nuevoNodo;
        } else {
            NodoVuelo temp = nodoInicial;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }
    }

    public void eliminarVuelo(int id) {
        NodoVuelo temp = nodoInicial;
        NodoVuelo prev = null;

        if (temp != null && temp.getVuelo().getId() == id) {
            nodoInicial = temp.getSiguiente();
            return;
        }

        while (temp != null && temp.getVuelo().getId() != id) {
            prev = temp;
            temp = temp.getSiguiente();
        }

        if (temp == null) {
            return;
        }

        prev.setSiguiente(temp.getSiguiente());
    }

    public Vuelo obtenerVueloPorIndice(int indice) {
        NodoVuelo temp = nodoInicial;
        for (int i = 0; i < indice; i++) {
            temp = temp.getSiguiente();
        }
        return temp.getVuelo();
    }

}
