package tpprograbasica2;

public class Pedido implements Comparable {
	

	private Integer nOrden;
	private Integer nMesa;
	
	//coleccion de productos pedidos en la orden
	public Pedido (Integer nOrden, Integer nMesa) {
		this.nOrden=nOrden;
		this.nMesa=nMesa;
		
	}

	public Integer getnOrden() {
		return nOrden;
	}

	public void setnOrden(Integer nOrden) {
		this.nOrden = nOrden;
	}

	public Integer getnMesa() {
		return nMesa;
	}

	public void setnMesa(Integer nMesa) {
		this.nMesa = nMesa;
	}

	@Override
	public int compareTo(Object o) {
		
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "Pedido [nOrden=" + nOrden + ", nMesa=" + nMesa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nMesa == null) ? 0 : nMesa.hashCode());
		result = prime * result + ((nOrden == null) ? 0 : nOrden.hashCode());
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
		Pedido other = (Pedido) obj;
		if (nMesa == null) {
			if (other.nMesa != null)
				return false;
		} else if (!nMesa.equals(other.nMesa))
			return false;
		if (nOrden == null) {
			if (other.nOrden != null)
				return false;
		} else if (!nOrden.equals(other.nOrden))
			return false;
		return true;
	}
}

