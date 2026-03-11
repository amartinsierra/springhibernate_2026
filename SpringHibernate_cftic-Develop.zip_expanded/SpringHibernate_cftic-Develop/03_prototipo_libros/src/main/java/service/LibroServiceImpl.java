package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Libro;

@Service
public class LibroServiceImpl implements LibroService{

	static List<Libro> libros=new ArrayList<>(Arrays.asList(
			new Libro("ABC123","Harry Potter","J.K ROWLING",15.2),
			new Libro("ABC456","El rio perdido","Peter Wozniak",15.2),
			new Libro("ABC789","El camino","Ken Follet",15.2)
			));
	
	public boolean nuevoLibro(Libro libro) {
		for(Libro li:libros) {
			if(li.getIsbn().equals(libro.getIsbn()))
			{
				return false;
			}
		}
		return libros.add(libro);
	}

	public List<Libro> buscarLibroByIsbn(String isbn) {
		return libros.stream().filter( a -> a.getIsbn().equals(isbn)).toList();
	}

	public boolean delLibro(String isbn) {
		
		for(Libro li:libros) {
			if(li.getIsbn().equalsIgnoreCase(isbn))
			{
				libros.removeIf(p -> p.getIsbn().equalsIgnoreCase(isbn));
				return true;
			}
		}
		return false;
	}

	
}
