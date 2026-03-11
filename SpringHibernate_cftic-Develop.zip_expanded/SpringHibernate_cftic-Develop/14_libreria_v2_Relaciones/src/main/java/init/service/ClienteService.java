package init.service;

import init.model.Cliente;

public interface ClienteService {

	Cliente alta(Cliente cliente);
	Cliente buscar(String user,String pwd);
}
