package projeto.natanael.microservices.pedido.controller;


import projeto.natanael.microservices.pedido.model.Pedido;
import projeto.natanael.microservices.pedido.service.PedidoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RabbitTemplate rabbitTemplate;
    private final PedidoService pedidoService;

    public PedidoController(RabbitTemplate rabbitTemplate, PedidoService pedidoService){
        this.pedidoService = pedidoService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.processamento.name}")
    private String routingKey;

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido){
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        rabbitTemplate.convertAndSend(routingKey,pedidoSalvo.getDescription());
        return "Pedido salvo e enviado para processamento: "+pedido.getDescription();
    }

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.listarPedidos();
    }
}
