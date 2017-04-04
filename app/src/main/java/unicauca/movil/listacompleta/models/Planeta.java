package unicauca.movil.listacompleta.models;

/**
 * Created by Dario Chamorro on 28/03/2017.
 */

public class Planeta {

    private String nombre;
    private float gravedad;

    public Planeta(String nombre, float gravedad) {
        this.nombre = nombre;
        this.gravedad = gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        this.gravedad = gravedad;
    }
}
