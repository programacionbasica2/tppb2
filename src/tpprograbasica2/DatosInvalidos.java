package tpprograbasica2;

public class DatosInvalidos extends Exception {
	public static void method (String mail, String contrasena, String mail2, String contrasena2) throws DatosInvalidos {
	if(mail==mail2 && contrasena==contrasena2) {
	}else
		{throw new DatosInvalidos();
	}
	}
}
