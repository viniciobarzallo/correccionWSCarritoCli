package ec.edu.ups.appdis.modelo;

import java.util.List;

public class Producto {
	private int codigoProducto;
	private String nombreProducto ;
	private double precio;
	private List<CabeceraDetalle> listaCabecera;
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public List<CabeceraDetalle> getListaCabecera() {
		return listaCabecera;
	}
	public void setListaCabecera(List<CabeceraDetalle> listaCabecera) {
		this.listaCabecera = listaCabecera;
	}
	
	
}
