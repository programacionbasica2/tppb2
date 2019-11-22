package tpprograbasica2;

public class NoHayProductosPedidos extends Exception {
	public static void method (Double sumatoria) throws NoHayProductosPedidos {
		
		if(sumatoria==0.0) {
			throw new NoHayProductosPedidos();
		}
	}
}
