package init.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.model.Cliente;
import init.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Transactional
	public Cliente alta(Cliente cliente) {
		if(clienteRepository.findFirstByUsuarioAndPassword(cliente.getUsuario(), cliente.getPassword())!=null) {
			return null;
		}
		return clienteRepository.save(cliente);
	}

	public Cliente buscar(String user,String pwd) {
		return clienteRepository.findFirstByUsuarioAndPassword(user, pwd);
		
	}

}
