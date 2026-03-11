package init.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dto.ClienteDto;
import init.dto.LibroDto;
import init.dto.VentaDto;
import init.mapper.Mappeador;
import init.model.Venta;
import init.repository.ClienteRepository;
import init.repository.VentaRepository;
import jakarta.transaction.Transactional;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private Mappeador mapper;

	@Transactional
	public boolean saveSale(ClienteDto cliente, List<LibroDto> libros) {
		if(cliente == null || libros.isEmpty()) {
			return false;
		}
		libros.stream()
					.map(mapper::dtoLibroToEntity)
					.map(libro -> {
						return new Venta(clienteRepository.findById(cliente.getIdCliente()).get(),libro,LocalDateTime.now());
					}).forEach(ventaRepository::save);
		return true;
	}

	public List<VentaDto> findCompraByClient(int idCliente) {
		return  ventaRepository.findByClienteIdCliente(idCliente).stream().map( mapper::entityVentaToDto).toList();
	}

	public List<VentaDto> findCompraByClientDate(int idCliente, LocalDateTime f1, LocalDateTime f2) {
		return ventaRepository.findByClienteIdClienteAndFechaBetween(idCliente, f1, f2).stream().map(mapper::entityVentaToDto).toList();
	}

}
