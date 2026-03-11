package init.service;

import java.util.List;

import init.dto.LibroDto;

public interface LibroService {
	List<LibroDto> getBooks();
	List<LibroDto> getBooksByTheme(int theme);
	LibroDto findById(Long isbn);
}
