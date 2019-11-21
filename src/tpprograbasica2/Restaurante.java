package tpprograbasica2;

import java.util.ArrayList;
import java.util.HashSet;

public class Restaurante {
	ArrayList<Producto> listaProductos = new ArrayList<Producto>(); // Listas
	HashSet<Usuario> listaUsuarios = new HashSet<Usuario>();
	HashSet<Admin> listaAdmins = new HashSet<Admin>();

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
		for(Usuario daux: listaUsuarios) {
			if(daux.getMail().equals(mail) && daux.getContrasena().equals(contrasena)){
				resultado= 1;
			}
		}
		for(Admin daux1: listaAdmins) {
			if(daux1.getMail().equals(mail) && daux1.getContrasena().equals(contrasena)) {
				resultado= 2;
			}
		}
		if(resultado==-1) {
			throw new DatosInvalidos();
		}
	return resultado;
	}
}
