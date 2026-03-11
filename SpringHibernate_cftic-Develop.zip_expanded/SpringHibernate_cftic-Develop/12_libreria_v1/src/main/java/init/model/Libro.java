package init.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="libros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	private int idTema;
	
}
