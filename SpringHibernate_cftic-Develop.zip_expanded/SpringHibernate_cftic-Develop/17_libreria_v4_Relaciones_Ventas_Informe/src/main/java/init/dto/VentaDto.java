package init.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VentaDto {
	
	private int idVenta;
	private ClienteDto idCliente;
	private LibroDto libro;
	private LocalDateTime fecha;
	
}
