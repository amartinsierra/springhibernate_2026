package service;

import java.util.List;

import model.Libro;

public interface LibroService {

	boolean nuevoLibro(Libro libro);
	List<Libro> buscarLibroByIsbn(String isbn);
	boolean delLibro(String isbn);
}
