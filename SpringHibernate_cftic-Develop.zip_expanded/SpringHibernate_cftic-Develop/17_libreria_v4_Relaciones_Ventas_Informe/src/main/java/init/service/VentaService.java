package init.service;

import java.time.LocalDateTime;
import java.util.List;

import init.dto.ClienteDto;
import init.dto.LibroDto;
import init.dto.VentaDto;

public interface VentaService {

	boolean  saveSale(ClienteDto cliente,List<LibroDto> libros);
	List<VentaDto> findCompraByClient(int idCliente);
	List<VentaDto> findCompraByClientDate(int idCliente,LocalDateTime f1,LocalDateTime f2);
}
