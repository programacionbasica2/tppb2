package tpprograbasica2;

public class Producto {
private String descripcion;
private Double precio;
private Integer id;

public Producto( String descripcion,Integer id, Double precio)


	{	this.descripcion=descripcion;
		this.id=id;
		this.precio=precio;
	

	}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Double getPrecio() {
	return precio;
}

public void setPrecio(Double precio) {
	this.precio = precio;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}




}
