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
}
