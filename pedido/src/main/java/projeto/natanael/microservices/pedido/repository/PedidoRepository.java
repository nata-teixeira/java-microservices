package projeto.natanael.microservices.pedido.repository;

import projeto.natanael.microservices.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
