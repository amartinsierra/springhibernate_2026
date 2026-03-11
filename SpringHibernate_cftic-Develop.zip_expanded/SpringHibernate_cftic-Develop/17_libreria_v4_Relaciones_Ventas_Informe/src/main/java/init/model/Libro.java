package init.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@ManyToOne()
	@JoinColumn(name="idTema",referencedColumnName = "idTema")
	private Tema temaRelacionado;
	
}
