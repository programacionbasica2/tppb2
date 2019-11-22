package tpprograbasica2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Restaurante {
	ArrayList<Producto> listaProductos = new ArrayList<Producto>(); // Listas
	ArrayList<Producto> pedidoproductos = new ArrayList<Producto>();
	HashSet<Usuario> listaUsuarios = new HashSet<Usuario>();
	HashSet<Admin> listaAdmins = new HashSet<Admin>();
	Set<Pedido> listapedidos = new TreeSet<Pedido>();
	Set<Pedido> listadepedidosasignados = new TreeSet<Pedido>();
	private int contadorOrdenes = 0;

	public Boolean registroUsuario(String nombre, String apellido, String mail, String contrasena) throws Exception {

		Usuario usuario = new Usuario("", "", "", "");

		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		for (Usuario daux : listaUsuarios) {
			if (daux.getMail().equals(mail)) {
				throw new Exception("El mail ya se encuentra en uso");
			} else {
				usuario.setMail(mail);
			}
		}
		usuario.setContrasena(contrasena);
		return true;
	}

	public Integer ingresarAlSistema(String mail, String contrasena) throws DatosInvalidos {
		Integer resultado = -1;
		for (Usuario daux : listaUsuarios) {
			if (daux.getMail().equals(mail) && daux.getContrasena().equals(contrasena)) {
				resultado = 1;
			}
		}
		for (Admin daux1 : listaAdmins) {
			if (daux1.getMail().equals(mail) && daux1.getContrasena().equals(contrasena)) {
				resultado = 2;
			}
		}
		if (resultado == -1) {
			throw new DatosInvalidos();
		}
		return resultado;
	}

	public void generarnumeropedido(Pedido pedido) {

		pedido.setnOrden(contadorOrdenes);
		listapedidos.add(pedido);
		contadorOrdenes++;

	}

	public void pedirproducto(Producto ped) {
		for (Producto daux : listaProductos) {
			if (daux.getId() == ped.getId()) {
				pedidoproductos.add(ped);

			}
		}
	}

	public void mostarHistorialPedidos() {
		for (Pedido daux : listapedidos) {
			daux.toString();
		}
	}

	public Double pagarConEfectivo() throws NoHayProductosPedidos {
		Double sumatoriaEfectivo = 0.0;
		for (Producto daux : pedidoproductos) {
			sumatoriaEfectivo = daux.getPrecio() + sumatoriaEfectivo;
		}
		if (sumatoriaEfectivo == 0.0) {
			throw new NoHayProductosPedidos();
		} else {
			return sumatoriaEfectivo;
		}
	}

	public Double pagarConTarjeta() throws NoHayProductosPedidos {
		Double sumatoriaTarjeta = 0.0;
		for (Producto daux : pedidoproductos) {
			sumatoriaTarjeta = daux.getPrecio() + sumatoriaTarjeta;
		}
		sumatoriaTarjeta = sumatoriaTarjeta + (sumatoriaTarjeta * 0.10);
		if (sumatoriaTarjeta == 0) {
			throw new NoHayProductosPedidos();
		} else {
			return sumatoriaTarjeta;
		}
	}
}
