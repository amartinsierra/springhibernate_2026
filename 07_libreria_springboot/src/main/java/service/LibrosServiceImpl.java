package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Libro;
@Service
public class LibrosServiceImpl implements LibrosService {
	
	static List<Libro> libros=new ArrayList<>(Arrays.asList(new Libro("aa1","Java básico","varios",30.8),
			new Libro("bb2","Spring boot","prueba",50)
			));

	@Override
	public boolean nuevoLibro(Libro libro) {
		for(Libro l:libros) {
			if(l.getIsbn().equals(libro.getIsbn())) {
				return false;
			}
		}
		return libros.add(libro);
	}

	@Override
	public Libro buscarPorIsbn(String isbn) {
		return libros.stream()
				.filter(l->l.getIsbn().equals(isbn))
				.findFirst()
				.orElse(null);
	}

	@Override
	public boolean eliminaLibro(String isbn) {
		//si no existe, devuelvo false
		if(buscarPorIsbn(isbn)==null) {
			return false;
		}
		
		/*Libro lib=buscarPorIsbn(isbn);
		libros.remove(lib);*/
		libros.removeIf(l->l.getIsbn().equals(isbn));
		return true;
	}

}
