package init.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import init.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{

}
