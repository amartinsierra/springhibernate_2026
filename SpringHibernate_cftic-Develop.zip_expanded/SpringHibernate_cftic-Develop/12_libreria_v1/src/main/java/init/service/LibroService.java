package init.service;

import java.util.List;

import init.model.Libro;

public interface LibroService {
	List<Libro> getBooks();
	List<Libro> getBooksByTheme(int theme);
}
