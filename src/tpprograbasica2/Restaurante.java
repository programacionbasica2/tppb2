package tpprograbasica2;

import java.util.ArrayList;
import java.util.HashSet;

public class Restaurante {
	ArrayList <Producto> listaProductos = new ArrayList <Producto>(); //Listas
	HashSet <Usuario> listaUsuarios = new HashSet <Usuario>();
	HashSet <Admin> listaAdmins = new HashSet <Admin>();
	
	
	public Boolean registroUsuario(String nombre, String apellido, String mail, String contrasena) throws Exception {
		Usuario usuario =new Usuario("","","","");
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		for(Usuario daux: listaUsuarios) {
			if(daux.getMail().equals(mail)) {
				throw new Exception ("El mail ya se encuentra en uso");
			}else {
				usuario.setMail(mail);
			}
		}
		usuario.setContrasena(contrasena);
		return true;
	}
	
	
	public Integer ingresarAlSistema(String mail, String contrasena) throws Exception {
		
		for(Usuario daux: listaUsuarios) {
			if(daux.getMail()==mail && daux.getContrasena()==contrasena) {
				return 1;
			}else {
				for(Admin daux2: listaAdmins) {
					if(daux2.getMail()==mail && daux2.getContrasena()==contrasena) {
						return 2;
					}else {
						throw new Exception ("Datos invalidos");
					}
					
				}
			}
		}
	return -1;
	}
	
}
