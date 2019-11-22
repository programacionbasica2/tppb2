package tpprograbasica2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRestaurante {
@Test
	public void testRegistroUsuarioCorrecto() throws Exception {
	Restaurante unlamResto = new Restaurante();
	String nombre= "Matias";
	String apellido= "Caceres";
	String mail= "maticaceres@hotmail.com";
	String contrasena= "asd";

	String nombre1= "Matias";
	String apellido1= "Caceres";
	String mail1= "maticaceres2@hotmail.com";
	String contrasena1= "asd";
	unlamResto.registroUsuario(nombre, apellido, mail, contrasena);
	unlamResto.registroUsuario(nombre1, apellido1, mail1, contrasena1);
	
	assertEquals(2, unlamResto.listaUsuarios.size());
	
}

@Test
	public void testIngresoUsuarioCorrecto() throws DatosInvalidos {
	Restaurante unlamResto = new Restaurante();
	Usuario matias= new Usuario ("Matias", "Caceres", "maticaceres@hotmail.com", "asd");
	unlamResto.listaUsuarios.add(matias);
	String mail= "maticaceres@hotmail.com";
	String contrasena= "asd";
	Integer resultado=unlamResto.ingresarAlSistema(mail, contrasena);
	assertEquals((Integer)1,(Integer)resultado);
	
}

@Test (expected= DatosInvalidos.class)
	public void testIngresoUsuarioIncorrecto() throws DatosInvalidos{
	Restaurante unlamResto = new Restaurante();
	Usuario matias= new Usuario ("Matias", "Caceres", "maticaceres@hotmail.com", "asd");
	String mail= "maticaceres@hotmail.com";
	String contrasena= "asd";
	unlamResto.ingresarAlSistema(mail, contrasena);
}

@Test 
	public void agregarProducto() throws IdEnUso {
	Restaurante unlamResto = new Restaurante();
	String descripcion= "asd";
	Integer id=1;
	Double precio= 20.0;
	unlamResto.agregarProducto(descripcion, id, precio);
	assertEquals(1, unlamResto.listaProductos.size());
}
@Test (expected=IdEnUso.class)
	public void agregarProductoIdRepetido() throws IdEnUso {
	Restaurante unlamResto = new Restaurante();
	Producto producto1 = new Producto("asd", 1 ,20.0);
	unlamResto.listaProductos.add(producto1);
	String descripcion= "asd";
	Integer id=1;
	Double precio= 20.0;
	unlamResto.agregarProducto(descripcion, id, precio);
	
}
@Test 
	public void eliminarProducto() throws IdNoEncontrado {
	Restaurante unlamResto = new Restaurante();
	Producto producto1 = new Producto("asd", 1 ,20.0);
	unlamResto.listaProductos.add(producto1);
	unlamResto.eliminarProducto(1);
	assertEquals(0,unlamResto.listaProductos.size());
}
@Test (expected= IdNoEncontrado.class)
	public void eliminarProductoIdNoEncontrada() throws IdNoEncontrado {
	Restaurante unlamResto = new Restaurante();
	Producto producto1 = new Producto("asd", 1 ,20.0);
	unlamResto.listaProductos.add(producto1);
	unlamResto.eliminarProducto(2);
}
@Test
	public void testPagarConEfectivo() throws NoHayProductosPedidos {
	Restaurante unlamResto = new Restaurante();
	Producto producto1 = new Producto("asd", 1 ,20.0);
	Producto producto2 = new Producto("asd", 2 ,30.0);
	unlamResto.pedidoproductos.add(producto1);
	unlamResto.pedidoproductos.add(producto2);
	Double resultadoEfectivo= unlamResto.pagarConEfectivo();
	assertEquals((Double)50.0, (Double)resultadoEfectivo);
}
@Test (expected= NoHayProductosPedidos.class)
	public void testPagarConEfectivoError() throws NoHayProductosPedidos {
		Restaurante unlamResto = new Restaurante();
		unlamResto.pagarConEfectivo();
	}
@Test
	public void testPagarConTarjeta() throws NoHayProductosPedidos {
	Restaurante unlamResto = new Restaurante();
	Producto producto1 = new Producto("asd", 1 ,20.0);
	Producto producto2 = new Producto("asd", 2 ,30.0);
	unlamResto.pedidoproductos.add(producto1);
	unlamResto.pedidoproductos.add(producto2);
	Double resultadoTarjeta= unlamResto.pagarConTarjeta();
	assertEquals(55.0, resultadoTarjeta, 0.01);
	
}
@Test (expected= NoHayProductosPedidos.class)
	public void testPagarConTarjetaError() throws NoHayProductosPedidos {
	Restaurante unlamResto = new Restaurante();
	unlamResto.pagarConTarjeta();
}

@Test
	public void testPedidoCompletado() {
	Restaurante unlamResto = new Restaurante();
	Pedido pedido1 = new Pedido (1, 1);
	Pedido pedido2 = new Pedido (2, 2);
	unlamResto.listapedidosasignados.add(pedido1);
	unlamResto.listapedidosasignados.add(pedido2);
	
	assertEquals(1, unlamResto.listapedidosasignados.size());
}
@Test (expected= NumeroOrdenNoEncontrado.class)
	public void testPedidoCompletadoNoEncontrado() throws NumeroOrdenNoEncontrado {
	Restaurante unlamResto = new Restaurante();
	Pedido pedido1 = new Pedido (1, 1);
	Pedido pedido2 = new Pedido (2, 2);
	unlamResto.listapedidosasignados.add(pedido1);
	unlamResto.listapedidosasignados.add(pedido2);
	unlamResto.completarPedido(3);

}
}
