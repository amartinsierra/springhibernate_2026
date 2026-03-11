package init.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="temas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTema;
	private String tema;
	
	@OneToMany(mappedBy = "temaRelacionado",fetch = FetchType.EAGER)
	private List<Libro> libros;
}
