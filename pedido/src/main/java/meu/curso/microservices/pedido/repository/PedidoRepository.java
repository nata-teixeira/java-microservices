package meu.curso.microservices.pedido.repository;

import meu.curso.microservices.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
