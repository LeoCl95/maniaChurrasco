package br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.controller;

import br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.api.OrderApi;
import br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.api.request.OrderRequest;
import br.com.mania.churrasco.maniaChurrasco.application.port.output.OrderRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    private final OrderRepositoryPort orderRepositoryPort;

    @Autowired
    public OrderController(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public ResponseEntity<Void> createOrder(OrderRequest order) throws Exception {
        try {
            orderRepositoryPort.insertOrder(order);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
