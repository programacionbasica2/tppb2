package tpprograbasica2;

public class Producto implements Comparable<Producto>{
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Producto other = (Producto) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
public int compareTo(Producto arg0) {
	// TODO Auto-generated method stub
	return 0;
}




}
