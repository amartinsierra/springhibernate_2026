package init.mapper;

import org.springframework.stereotype.Component;

import init.dto.ClienteDto;
import init.dto.LibroDto;
import init.dto.TemaDto;
import init.model.Cliente;
import init.model.Libro;
import init.model.Tema;

@Component
public class Mappeador {
	
	
	public ClienteDto entityClienteToDto(Cliente c) {
		return new ClienteDto(c.getIdCliente(),c.getUsuario(),c.getPassword(),c.getEmail(),c.getTelefono());
	}
	
	public Cliente dtoClienteToEntity(ClienteDto c) {
		return new Cliente(c.getIdCliente(),c.getUsuario(),c.getPassword(),c.getEmail(),c.getTelefono());
	}
	
	public LibroDto entityLibroToDto(Libro l) {
		return new LibroDto(l.getIsbn(), l.getTitulo(), l.getAutor(), l.getPrecio(), l.getPaginas(),new TemaDto(l.getTemaRelacionado().getIdTema(), l.getTemaRelacionado().getTema()));
	}
	
	public Libro dtoLibroToEntity(LibroDto l) {
		return new Libro(l.getIsbn(), l.getTitulo(), l.getAutor(), l.getPrecio(), l.getPaginas(),new Tema(l.getTemaRelacionado().getIdTema(),l.getTemaRelacionado().getTema()));
	}
	
	public TemaDto entityTemaToDto(Tema t) {
		return new TemaDto(t.getIdTema(), t.getTema());
	}
	
	public Tema dtoTemaToEntity(TemaDto t) {
		return new Tema(t.getIdTema(), t.getTema());
	}

}
