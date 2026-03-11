package init.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDto {
	
	private String dni;
	private String nombre;
	private String email;
	private int edad;
	
		
}