package init;

public class Ficha {

	private String name;
	private String email;
	private int edad;
	public Ficha(String name, String email, int edad) {
		super();
		this.name = name;
		this.email = email;
		this.edad = edad;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Ficha() {
		super();
	}
	
}
