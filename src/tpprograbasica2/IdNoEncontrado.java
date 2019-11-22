package tpprograbasica2;

public class IdNoEncontrado extends Exception {
	public static void method (Integer id1, Integer id2) throws IdNoEncontrado {
		if(id1!=id2) {
			throw new IdNoEncontrado();
		}
	}
}
