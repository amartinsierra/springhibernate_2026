package init.service;

import init.dto.ClienteDto;
import init.model.Cliente;

public interface ClienteService {

	boolean alta(Cliente cliente);
	ClienteDto buscar(String user,String pwd);
}
