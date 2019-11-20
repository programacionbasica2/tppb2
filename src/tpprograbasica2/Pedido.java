package tpprograbasica2;

public class Pedido {
	private Integer nOrden;
	private Integer nMesa;
	
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
}
