package service;

import model.Libro;

public interface LibrosService {
	boolean nuevoLibro(Libro libro);
	Libro buscarPorIsbn(String isbn);
	boolean eliminaLibro(String isbn);
}
