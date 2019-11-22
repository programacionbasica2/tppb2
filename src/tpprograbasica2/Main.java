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
		Pedido pedido2 = new Pedido(2, 2);
		Pedido pedido3 = new Pedido(3, 3);
		Producto cocacola = new Producto ("Coca-Cola", 1, 30.0);
		Producto pepsi = new Producto ("Pepsi", 2, 20.0);
		Scanner teclado = new Scanner(System.in);
		UnlamResto.listapedidos.add(pedido1);
		UnlamResto.listapedidos.add(pedido2);
		UnlamResto.listapedidos.add(pedido3);
		UnlamResto.listapedidosasignados.add(pedido2);
		UnlamResto.listaUsuarios.add(test1);
		UnlamResto.listaAdmins.add(test2);
		UnlamResto.listaProductos.add(cocacola);
		UnlamResto.listaProductos.add(pepsi);
		Integer opcionlogin = 0;
		Boolean opcionAdminVolverMenu = true;

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
					Integer opcionpedido;
					System.out.println("desea encargar algo?");
					
					System.out.println("Seleccione 1 si");
					System.out.println("Seleccione 0 no");
					opcionpedido=teclado.nextInt();
				switch(opcionpedido){
				case 1:
				System.out.println("elija un numero de mesa estas estan disponibles:");
				UnlamResto.mesasdisponibles();
				
				
				}
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
				do {
				System.out.println("Bienvenido admin");
				System.out.println("Seleccione 1 para agregar un producto a la carta");
				System.out.println("Seleccione 2 para eliminar un producto de la carta");
				System.out.println("Seleccione 3 para ver el historial de pedidos");
				System.out.println("Seleccione 4 para completar un pedido");
				System.out.println("Seleccione 0 para desconectarse");
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
						System.out.println("Desea regresar al menu? 1-Sí 2-No");
						Integer opcionRegresarMenu=teclado.nextInt();
						if(opcionRegresarMenu==2) {
							opcionAdminVolverMenu=false;
						}
						
						
					} catch (IdEnUso e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("Ingrese otro ID");
						Integer id2=teclado.nextInt();
						UnlamResto.agregarProducto(descripcion, id2, precio);
						System.out.println("Desea regresar al menu? 1-Sí 2-No");
						Integer opcionRegresarMenu=teclado.nextInt();
						if(opcionRegresarMenu==2) {
							opcionAdminVolverMenu=false;
						}
					}
					break;
				case 2:
					for(Producto daux:UnlamResto.listaProductos) {
							System.out.println(daux.toString());
					}
					System.out.println("Ingrese la ID del producto que desea eliminar de la carta");
					Integer idEliminar= teclado.nextInt();
					try {
						UnlamResto.eliminarProducto(idEliminar);
						System.out.println("El producto ha sido eliminado correctamente");
						System.out.println("Desea regresar al menu? 1-Sí 2-No");
						Integer opcionRegresarMenu=teclado.nextInt();
						if(opcionRegresarMenu==2) {
							opcionAdminVolverMenu=false;
						}
					} catch (IdNoEncontrado e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("Desea regresar al menu? 1-Sí 2-No");
						Integer opcionRegresarMenu=teclado.nextInt();
						if(opcionRegresarMenu==2) {
							opcionAdminVolverMenu=false;
						}
					}
					break;
				case 3:
					System.out.println("El historial de pedidos es:");
					UnlamResto.mostrarHistorialPedidos();
					System.out.println("Desea regresar al menu? 1-Sí 2-No");
					Integer opcionRegresarMenu=teclado.nextInt();
					if(opcionRegresarMenu==2) {
						opcionAdminVolverMenu=false;
					}
					break;
				case 4:
					System.out.println("Los pedidos en curso son: ");
					for(Pedido daux: UnlamResto.listapedidosasignados)
					System.out.println(daux.toString());
					System.out.println("Ingrese el numero de orden del pedido completado");
					Integer pedidoCompletado=teclado.nextInt();
					try {
						UnlamResto.completarPedido(pedidoCompletado);
						System.out.println("Pedido quitado de la lista con exito");
						System.out.println("Desea regresar al menu? 1-Sí 2-No");
						Integer opcionRegresarMenu1=teclado.nextInt();
						if(opcionRegresarMenu1==2) {
							opcionAdminVolverMenu=false;
						}
					} catch (NumeroOrdenNoEncontrado e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				
				default:
					break;
				}
				}while (opcionAdminVolverMenu)
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