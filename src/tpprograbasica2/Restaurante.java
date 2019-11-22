package tpprograbasica2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Restaurante {
	ArrayList<Producto> listaProductos = new ArrayList<Producto>(); // Listas
	ArrayList<Producto> pedidoproductos = new ArrayList<Producto>();
	HashSet<Usuario> listaUsuarios = new HashSet<Usuario>();
	HashSet<Admin> listaAdmins = new HashSet<Admin>();
	Set<Pedido> listapedidos = new TreeSet<Pedido>();
	Set<Pedido> listapedidosasignados = new TreeSet<Pedido>();
	private Integer contadorOrdenes = 0;
	private Integer resultado;

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
		 resultado = -1;
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
	
	public void agregarProducto(String descripcion, Integer id, Double precio) throws IdEnUso {
		Boolean idDisponible=true;
		for(Producto daux: listaProductos) {
			if(id == daux.getId()) {
				idDisponible=false;
			}
		}
		if(idDisponible) {
		Producto producto= new Producto (descripcion, id, precio);
		listaProductos.add(producto);
		}else {
			throw new IdEnUso();
		}
		
	}
	
	public void eliminarProducto(Integer id)throws IdNoEncontrado {
		Iterator <Producto> itr= listaProductos.iterator();
		Boolean idLibre= true;
		while(itr.hasNext() && idLibre) {
		Producto aux=itr.next();
			if(id==aux.getId()) {
				listaProductos.remove(aux);
				idLibre=false;
			}else {
				throw new IdNoEncontrado();
			}
		}
	}

	public void generarnumeropedido(Pedido pedido) {
//genera numeros de pedido para despues poder brindar una mesa al cliente 


		listapedidos.add(pedido);


	}
	public void asignarmesausuario(Integer ped)
	{//le asigna su mesa para posteriormente
		//solicitar el pedido

		for(Pedido daux: listapedidos)
	{
		if(daux.getnMesa()==ped)
		{
			
			listapedidosasignados.add(daux);//movi lo de generar nro de pedido a este metodo
			daux.setnOrden(contadorOrdenes);
			contadorOrdenes++;
			
			
		}}}

	public void pedirproducto(Producto ped) {
		//recorre la lista de productos disponible para luego solicitar el producto
		for (Producto daux : listaProductos) {
			if (daux.getId() == ped.getId()) {
				pedidoproductos.add(ped);

			}
		}
	}

	public void mostarHistorialPedidos() {//muestra los pedidos que fueron procesados
		for (Pedido daux : listapedidosasignados) {
			 System.out.println(daux);
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
	
	public void mostrarCarta () {//muestra la carta de productos disponibles
		for(Producto aux: listaProductos) {
			System.out.println(aux.getId()+aux.getDescripcion()+aux.getPrecio());
		}
		
	
	}
	public void mesasdisponibles(){
		for(Pedido aux:listapedidos)
		{
			for(Pedido aux2:listapedidosasignados)
			{
			if(aux.getClass()==aux2.getClass())
			{
				
			}else{
				System.out.println(aux.getnMesa());
			}
				
				
				
			}
			
			
		}
		
		
	}
	
	
}
