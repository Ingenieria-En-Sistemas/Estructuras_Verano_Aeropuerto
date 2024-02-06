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

    

}
