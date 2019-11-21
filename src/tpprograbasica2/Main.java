package tpprograbasica2;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurante UnlamResto = new Restaurante();
		Usuario test1 = new Usuario("Juan", "Rugna", "juanrugna@hotmail.com", "asd");
		Admin test2 = new Admin("Roman", "Riquelme", "romanriquelme@hotmail.com", "asd");
		Scanner teclado = new Scanner(System.in);
		UnlamResto.listaUsuarios.add(test1);
		UnlamResto.listaAdmins.add(test2);
		 Integer opcionlogin;

		System.out.println("Seleccione 1 para ingresar en el sistema");
		System.out.println("Seleccione 2 para registrarse en el sistema");
		Integer opcion = teclado.nextInt();
		switch (opcion) {
		case 1: // Login
			System.out.println("Ingrese el mail");
			String mail = teclado.next();
			System.out.println("Ingrese la contraseña");
			String contrasena = teclado.next();
			
			try {
				opcionlogin= UnlamResto.ingresarAlSistema(mail, contrasena);
			} catch (DatosInvalidos e1) {
				// TODO Auto-generated catch1 block
				e1.printStackTrace();
			}
			
				
			
			
			break;

		case 2:  //Registro
			System.out.println("Ingrese su nombre");
			String nombre = teclado.next();
			System.out.println("Ingrese su apellido");
			String apellido = teclado.next();
			System.out.println("Ingrese su mail");
			String mail2 = teclado.next();
			System.out.println("Ingrese su contraseña");
			String contrasena2 = teclado.next();
			try {
				UnlamResto.registroUsuario(nombre, apellido, mail2, contrasena2);
				System.out.println("Usuario registrado correctamente");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			break;

		default:
			break;
		}
	
	}

	
}