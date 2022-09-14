package net.codejava.spring.model;

public class Cliente {
	private int id;
	private String Nombre;
	private String ModCoche;
	private String Placa;
	private String Consideraciones;
	private String Telefono;

	public Cliente() {
	}

	public Cliente(String Nombre, String ModCoche, String Placa, String Consideraciones, String Telefono) {
		this.Nombre = Nombre;
		this.ModCoche = ModCoche;
		this.Placa = Placa;
		this.Consideraciones = Consideraciones;
		this.Telefono = Telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public String getModCoche() {
		return ModCoche;
	}

	public void setModCoche(String ModCoche) {
		this.ModCoche = ModCoche;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String Placa) {
		this.Placa = Placa;
	}

	public String getConsideraciones() {
		return Consideraciones;
	}

	public void setConsideraciones(String Consideraciones) {
		this.Consideraciones = Consideraciones;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}

}
