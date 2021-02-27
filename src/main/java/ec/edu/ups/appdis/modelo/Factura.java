package ec.edu.ups.appdis.modelo;

import java.util.List;


public class Factura {
	
	private int id;
	private double totalCompra;
	private List<CabeceraDetalle> listaDestalles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}

	public List<CabeceraDetalle> getListaDestalles() {
		return listaDestalles;
	}

	public void setListaDestalles(List<CabeceraDetalle> listaDestalles) {
		this.listaDestalles = listaDestalles;
	}
	
	
}
