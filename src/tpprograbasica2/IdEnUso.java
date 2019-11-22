package tpprograbasica2;

public class IdEnUso extends Exception {
	public static void method (Integer id1, Integer id2) throws IdEnUso {
		if(id1==id2) {
			throw new IdEnUso();
		}
	}
}
