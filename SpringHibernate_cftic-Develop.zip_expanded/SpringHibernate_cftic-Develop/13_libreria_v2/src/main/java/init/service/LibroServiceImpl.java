package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.model.Libro;
import init.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public List<Libro> getBooks() {
		return libroRepository.findAll();
	}

	@Override
	public List<Libro> getBooksByTheme(int theme) {
		return libroRepository.findByIdTema(theme);
	}

	@Override
	public Libro findById(Long isbn) {
		return libroRepository.findByIsbn(isbn);
	}
	
}
