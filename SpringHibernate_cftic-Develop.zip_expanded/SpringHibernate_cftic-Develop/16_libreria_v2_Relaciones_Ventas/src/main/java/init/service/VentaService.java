package init.service;

import java.util.List;

import init.dto.ClienteDto;
import init.dto.LibroDto;

public interface VentaService {

	boolean  saveSale(ClienteDto cliente,List<LibroDto> libros);
}
