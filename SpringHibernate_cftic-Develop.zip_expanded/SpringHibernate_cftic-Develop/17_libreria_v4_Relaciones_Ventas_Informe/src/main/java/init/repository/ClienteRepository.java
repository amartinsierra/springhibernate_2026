package init.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import init.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	boolean existsByUsuario(String usuario);
	Optional<Cliente> findFirstByUsuarioAndPassword(String usuario,String password);
}
