package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dto.LibroDto;
import init.mapper.Mappeador;
import init.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private Mappeador mappeador;
	
	public List<LibroDto> getBooks() {
		return libroRepository.findAll().stream().map(l -> mappeador.entityLibroToDto(l)).toList();
	}

	public List<LibroDto> getBooksByTheme(int theme) {
		return libroRepository.findByTemaRelacionadoIdTema(theme).stream().map(l -> mappeador.entityLibroToDto(l)).toList();
	}

	public LibroDto findById(Long isbn) {
		return mappeador.entityLibroToDto(libroRepository.findByIsbn(isbn));
	}
	
}
