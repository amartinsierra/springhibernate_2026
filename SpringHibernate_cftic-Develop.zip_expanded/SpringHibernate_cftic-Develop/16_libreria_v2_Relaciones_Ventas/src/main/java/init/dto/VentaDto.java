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
	private int idCliente;
	private Long idLibro;
	private LocalDateTime fecha;
	public VentaDto(int idCliente, Long idLibro, LocalDateTime fecha) {
		this.idCliente = idCliente;
		this.idLibro = idLibro;
		this.fecha = fecha;
	}
	
}
