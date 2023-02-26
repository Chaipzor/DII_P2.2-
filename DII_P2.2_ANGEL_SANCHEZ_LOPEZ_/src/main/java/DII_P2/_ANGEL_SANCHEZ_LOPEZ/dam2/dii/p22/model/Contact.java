package DII_P2._ANGEL_SANCHEZ_LOPEZ.dam2.dii.p22.model;

public class Contact {
	private int id;
	private static int idGlobal = 0;
	private String nombre;
	private String apellidos;
	private String email;
	private int telefono;
	private String comentario;
	

	public Contact(String nombre, String apellidos, String email, int telefono, String comentario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.comentario = comentario;
		idGlobal++;
		this.id = idGlobal;

	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
