package DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.dao;

import java.util.ArrayList;

import DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.model.Contact;
import DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.servicios.ContactService;

public class ContactDAO {

	private static ArrayList<Contact> listaContactos = new ArrayList<Contact>() {
		{
			add(new Contact("Angel", "Sanchez Lopez", "chaip@gmail.com", 666555444, "Comentario 1"));
			add(new Contact("Michael", "Jackson", "MJ@gmail.com", 111111111, "Comentario 2"));
			add(new Contact("Paco", "Hernandez", "PH@gmail.com", 999999999, "Comentario 3"));
			add(new Contact("A", "A", "A@gmail.com", 999999999, "Comentario 4"));
			add(new Contact("B", "B", "B@gmail.com", 999999999, "Comentario 5"));
			add(new Contact("C", "C", "C@gmail.com", 999999999, "Comentario 6"));
		}
	};

	public ArrayList<Contact> listarContactos() {
		return listaContactos;
	}

	public void crearContacto(Contact c) {
		listaContactos.add(c);
	}

	public void modificarUsuario(int id, Contact c) {
		int posicion = ContactService.obtenerPosicion(id);
		listaContactos.get(posicion).setNombre(c.getNombre());
		listaContactos.get(posicion).setApellidos(c.getApellidos());
		listaContactos.get(posicion).setEmail(c.getEmail());
		listaContactos.get(posicion).setTelefono(c.getTelefono());
		listaContactos.get(posicion).setComentario(c.getComentario());
	}

	public void eliminar(int id) {

		listaContactos.remove(ContactService.obtenerPosicion(id));
	}

	public Contact obtener(int id) {
		return listaContactos.get(ContactService.obtenerPosicion(id));
	}


}
