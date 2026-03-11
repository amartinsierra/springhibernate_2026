package init.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.dto.ClienteDto;
import init.mapper.Mappeador;
import init.model.Cliente;
import init.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	Mappeador mappeador;

	@Transactional
	public boolean alta(Cliente c) {
		if(clienteRepository.existsByUsuario(c.getUsuario())) {
			return false;
		}
		clienteRepository.save(c);
		return true;
	}

	public ClienteDto buscar(String user,String pwd) {
		return clienteRepository.findFirstByUsuarioAndPassword(user, pwd)
				.map(mappeador::entityClienteToDto)
				.orElse(null);
	}

}
