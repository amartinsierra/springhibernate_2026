package init.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibroDto {

	private Long isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	private TemaDto temaRelacionado;
	
}