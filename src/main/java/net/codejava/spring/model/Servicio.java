package net.codejava.spring.model;

public class Servicio {
    private int id;
    private int id_cliente;
    private String Servicio;
    private String Fecha;
    private String Mecanico;
    private int Importe;
    private String name;

    public Servicio() {
    }

    public Servicio(int id_cliente, String Servicio, String Fecha, String Mecanico, int Importe, String name) {
        this.id_cliente = id_cliente;
        this.Servicio = Servicio;
        this.Fecha = Fecha;
        this.Mecanico = Mecanico;
        this.Importe = Importe;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getMecanico() {
        return Mecanico;
    }

    public void setMecanico(String Mecanico) {
        this.Mecanico = Mecanico;
    }

    public int getImporte() {
        return Importe;
    }

    public void setImporte(int Importe) {
        this.Importe = Importe;
    }

    public String getname(){return name;}

    public void setname(String name){this.name = name;}

}
