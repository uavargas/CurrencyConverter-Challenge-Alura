public class Moneda {
    private String codigo;
    private String nombre;
    private double tasaCambio;


    //constructor
    public Moneda(String codigo, String nombre, double tasaCambio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tasaCambio = tasaCambio;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

    public String toString() {
        return "Moneda{" + "codigo=" + codigo + ", nombre=" + nombre + ", tasaCambio=" + tasaCambio + '}';
    }

}
