package init.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	private String usuario;
	
	private String password;
	
	private String email;
	
	private String telefono;
	
	public Cliente(String usuario, String email, String telefono) {
		this.usuario = usuario;
		this.email = email;
		this.telefono = telefono;
	}
	
	
}
