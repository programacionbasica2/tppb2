package tpprograbasica2;

public class Pedido {
	private Integer nOrden;
	private Integer nMesa;
	
	//coleccion de productos pedidos en la orden
	public Pedido (Integer nOrden, Integer nMesa, Integer contadorOrdenes) {
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
}
