package tpprograbasica2;

public class NumeroOrdenNoEncontrado extends Exception {
	public void method (Integer nOrden1, Integer nOrden2) throws NumeroOrdenNoEncontrado {
		if(nOrden1!= nOrden2) {
			throw new NumeroOrdenNoEncontrado();
		}
	}
}
