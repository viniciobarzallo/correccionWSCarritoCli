package ec.edu.ups.appdis.modelo;

import java.io.Serializable;
import java.util.List;


public class Parametros implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String cedula;
	private String nombre;
	private String correo;
	private List<Detalles> listaDetalles;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public List<Detalles> getListaDetalles() {
		return listaDetalles;
	}
	public void setListaDetalles(List<Detalles> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}


	
	
}
