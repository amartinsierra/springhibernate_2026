package init.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

	private int idCliente;
	
	private String usuario;
	
	private String password;
	
	private String email;
	
	private String telefono;
	
	
}