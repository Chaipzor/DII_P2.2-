package DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.servicios;

import java.util.ArrayList;

import DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.dao.ContactDAO;
import DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.model.Contact;

public class ContactService {

	public static ContactDAO udao = new ContactDAO();

	// Devuelve -1 si no existe el email o id en caso de que exista.
	public static int comprobarEmail(String email) {
		for (int i = 0; i < udao.listarContactos().size(); i++) {
			if (email.equalsIgnoreCase(udao.listarContactos().get(i).getEmail())) {
				return udao.listarContactos().get(i).getId();
			}
		}
		return -1;
	}

	// Obtener usuario por ID.
	public static Contact obtener(int id) {
		for (int i = 0; i < udao.listarContactos().size(); i++) {
			Contact c = listarContactos().get(i);
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	public static void eliminar(int id) {
		udao.eliminar(id);
	}

	public static ArrayList<Contact> listarContactos() {
		return udao.listarContactos();
	}

	public static boolean crearContacto(Contact c) {
		int resultado = comprobarEmail(c.getEmail()); // -1 no existe, cualquier otro devuelve: id.
		if (resultado == -1) {
			udao.crearContacto(c);
			return false;
		}
		return true;
	}

	//Se chequea los campos que han sido editados y sólamente se modifican esos en el contacto.
	public static String modificarUsuario(int id, Contact c) {
		int flag = 0;
		Contact viejo = ContactService.obtener(id);
		String camposEditados = "Campos editados: ";
		if (c.getNombre() != null && !c.getNombre().equalsIgnoreCase("")) {
			viejo.setNombre(c.getNombre());
			camposEditados = camposEditados + "Nombre +";
			flag++;
		}
		if (c.getApellidos() != null && !c.getApellidos().equalsIgnoreCase("")) {
			viejo.setApellidos(c.getApellidos());
			camposEditados = camposEditados + " Apellidos +";
			flag++;
		}
		if (c.getEmail() != null && !c.getEmail().equalsIgnoreCase("")) {
			viejo.setEmail(c.getEmail());
			camposEditados = camposEditados + " Email +";
			flag++;
		}
		if (c.getTelefono() != 0) {
			viejo.setTelefono(c.getTelefono());
			camposEditados = camposEditados + " Teléfono +";
			flag++;
		}
		if (c.getComentario() != null && !c.getComentario().equalsIgnoreCase("")) {
			viejo.setComentario(c.getComentario());
			camposEditados = camposEditados + " Comentarios.";
			flag++;
		}
		if (flag != 0) {
			udao.modificarUsuario(id, viejo);
			return "Total campos editados: " + flag + " " + camposEditados;
		} else {
			return "No se ha editado ningún registro. Revisa los datos introducidos";
		}

	}

	// Devuelve la posición en la lista del usuario con esa id.
	public static int obtenerPosicion(int id) {
		for (int i = 0; i < udao.listarContactos().size(); i++) {
			if (listarContactos().get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
}
