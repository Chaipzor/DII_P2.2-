package DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.dao.ContactDAO;
import DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.model.Contact;
import DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.servicios.ContactService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("contact")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	// Lista todos los contactos en formato JSON
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Contact> listarContactos() {
		return ContactService.listarContactos();
	}

	// Muestra el tamaño de la agenda.
	@GET
	@Path("size")
	@Produces(MediaType.TEXT_PLAIN)
	public String contarContactos() {
		return "El total de contactos guardados es de: " + ContactService.listarContactos().size();
	}

	
	//Inserta un nuevo contacto
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String insertarContacto(@QueryParam("nombre") String nombre, @QueryParam("apellidos") String apellidos,
			@QueryParam("email") String email, @QueryParam("telefono") int telefono,
			@QueryParam("comentario") String comentario) {
		String resultado = "";
		Contact contact = new Contact(nombre, apellidos, email, telefono, comentario);
		boolean estado = ContactService.crearContacto(contact); // false no creado (email existe), true creado.
		if (!estado) {
			resultado = "Los datos se han añadido correctamente";
		} else {
			resultado = "Los datos no se añadieron a la agenda. Ese email ya está en uso.";
		}
		return resultado;
	}

	
	//Modifica un contacto existente
	@PUT
	@Path("{codigo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String modificarContacto(@PathParam("codigo") int codigo, @QueryParam("nombre") String nombre,
			@QueryParam("apellidos") String apellidos, @QueryParam("email") String email,
			@QueryParam("telefono") int telefono, @QueryParam("comentario") String comentario) {
		String resultado = ContactService.modificarUsuario(codigo,
				new Contact(nombre, apellidos, email, telefono, comentario));
		return resultado;
	}

	
	//Elimina un contacto
	@DELETE
	@Path("{codigo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteContact(@PathParam("codigo") int codigo) {
		String resultadoCadena = "";
		if (ContactService.obtener(codigo) != null) {
			ContactService.eliminar(codigo);
			resultadoCadena = "El registro con id: " + codigo + " se ha eliminado correctamente.";
		} else {
			resultadoCadena = "El registro con id: " + codigo + " no existe.";
		}
		return resultadoCadena;
	}

}
