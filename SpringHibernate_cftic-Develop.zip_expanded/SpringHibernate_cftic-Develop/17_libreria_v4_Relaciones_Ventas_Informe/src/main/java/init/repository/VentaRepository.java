package init.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{
	List<Venta> findByClienteIdCliente(int idCliente);
	//@Query("select v from Venta v where v.cliente.idCliente=?1 and v.fecha between ?2 and ?3")
	List<Venta> findByClienteIdClienteAndFechaGreaterThanAndFechaLessThan(int idCliente, LocalDateTime f1,LocalDateTime f2);
	List<Venta> findByClienteIdClienteAndFechaBetween(int idCliente, LocalDateTime f1,LocalDateTime f2);
}
