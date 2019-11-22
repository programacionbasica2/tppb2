package tpprograbasica2;

import java.util.Comparator;

public class Ordenpedido implements Comparator<Pedido>{

	@Override
	public int compare(Pedido pedido1, Pedido pedido2) {
	return	pedido1.getnOrden().compareTo(pedido2.getnOrden())*-1;
	}

}
