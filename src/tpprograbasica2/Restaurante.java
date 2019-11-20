package tpprograbasica2;

import java.util.ArrayList;

public class Restaurante {
	ArrayList <Producto> listaProductos = new ArrayList <Producto>();
	ArrayList <Usuario> listaUsuarios = new ArrayList <Usuario>();
	
	public void realizarPedido(Integer id) {
		for(Producto daux: listaProductos) {
			if(daux.getId()==id) {
				
			}
		}
	}
	
}
