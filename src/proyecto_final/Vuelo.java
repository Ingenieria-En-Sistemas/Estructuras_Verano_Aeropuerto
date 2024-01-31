package proyecto_final;

public class Vuelo {

    private Aeropuerto origen;
    private Aeropuerto destino;
    private int duracion;

    public Vuelo(Aeropuerto origen, Aeropuerto destino, int duracion) {
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vuelo{");
        sb.append("origen=").append(origen.getNombre());
        sb.append(", destino=").append(destino.getNombre());
        sb.append(", duracion=").append(duracion);
        sb.append('}');
        return sb.toString();
    }
}
