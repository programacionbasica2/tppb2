package tpprograbasica2;

public class Producto {
private String descripcion;
private Integer precio;
private Integer id;

public Producto( String descripcion,Integer id, Integer precio)


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

public Integer getPrecio() {
	return precio;
}

public void setPrecio(Integer precio) {
	this.precio = precio;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}




}
