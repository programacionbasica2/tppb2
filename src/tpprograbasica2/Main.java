package tpprograbasica2;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IdEnUso {
		// TODO Auto-generated method stub
		Restaurante UnlamResto = new Restaurante();
		Usuario test1 = new Usuario("Juan", "Rugna", "juanrugna@hotmail.com", "asd");
		Admin test2 = new Admin("Roman", "Riquelme", "romanriquelme@hotmail.com", "asd");
		Pedido pedido1 = new Pedido(1, 1);
		Pedido pedido2 = new Pedido(3, 3);
		Pedido pedido3 = new Pedido(4, 4);
		Producto cocacola = new Producto ("Coca-Cola", 1, 30.0);
		Producto pepsi = new Producto ("Pepsi", 2, 20.0);
		Scanner teclado = new Scanner(System.in);
		UnlamResto.listapedidos.add(pedido1);
		UnlamResto.listapedidos.add(pedido2);
		UnlamResto.listapedidos.add(pedido3);
		UnlamResto.listaUsuarios.add(test1);
		UnlamResto.listaAdmins.add(test2);
		UnlamResto.listaProductos.add(cocacola);
		Integer opcionlogin = 0;

		System.out.println("Seleccione 1 para ingresar en el sistema");
		System.out.println("Seleccione 2 para registrarse en el sistema");
		Integer opcion = teclado.nextInt();
		switch (opcion) {
		case 1: 								// ** Login **
			System.out.println("Ingrese el mail");
			String mail = teclado.next();
			System.out.println("Ingrese la contraseña");
			String contrasena = teclado.next();

			try {
				opcionlogin = UnlamResto.ingresarAlSistema(mail, contrasena);
			} catch (DatosInvalidos e1) {
				// TODO Auto-generated catch1 block
				e1.printStackTrace();
			}

			switch (opcionlogin) {
			case 1: 						// **Menu usuario//
				System.out.println("Bienvenido usuario");
				System.out.println("Seleccione 1 para ver la carta");
				System.out.println("Seleccione 0 para desconectarse");
				Integer opcionUsuario = teclado.nextInt();
				switch (opcionUsuario) {
				case 1:
					UnlamResto.mostrarCarta();

					break;
				case 2:
					break;
				default:
					break;
				}
				while (opcionUsuario != 0)
					;

				break;

			case 2: 						// **Menu admin//
				
				System.out.println("Bienvenido admin");
				System.out.println("Seleccione 0 para desconectarse");
				System.out.println("Seleccione 1 para agregar un producto a la carta");
				System.out.println("Seleccione 2 para eliminar un producto de la carta");
				System.out.println("Seleccione 3 para ver el historial de pedidos");
				Integer opcionAdmin = teclado.nextInt();
				switch (opcionAdmin) {
				case 1:
					System.out.println("Ingrese la descripcion del producto");
					String descripcion= teclado.next();
					System.out.println("Ingrese la id del producto");
					Integer id= teclado.nextInt();
					System.out.println("Ingrese el precio del producto");
					Double precio= teclado.nextDouble();
					try {
						UnlamResto.agregarProducto(descripcion, id, precio);
						System.out.println("Producto agregado correctamente");
						
						
					} catch (IdEnUso e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("Ingrese otro ID");
						Integer id2=teclado.nextInt();
						UnlamResto.agregarProducto(descripcion, id2, precio);
					}
					break;
				case 2:
					System.out.println("Ingrese la ID del producto que desea eliminar de la carta");
					Integer idEliminar= teclado.nextInt();
					try {
						UnlamResto.eliminarProducto(idEliminar);
						System.out.println("El producto ha sido eliminado correctamente");
					} catch (IdNoEncontrado e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 3:
					System.out.println("El historial de pedidos es:");
					UnlamResto.mostarHistorialPedidos();
					break;
				
				default:
					break;
				}
				while (opcionAdmin!= 0)
					;
				break;
			default:
				break;
			}

			break;

		case 2: 						// **Registro**
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