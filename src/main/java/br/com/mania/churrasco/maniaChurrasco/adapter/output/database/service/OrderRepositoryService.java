package br.com.mania.churrasco.maniaChurrasco.adapter.output.database.service;

import br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.api.request.OrderRequest;
import br.com.mania.churrasco.maniaChurrasco.adapter.output.database.repository.OrderRepository;
import br.com.mania.churrasco.maniaChurrasco.application.domain.Order;
import br.com.mania.churrasco.maniaChurrasco.application.port.output.OrderRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderRepositoryService implements OrderRepositoryPort {

    private OrderRepository orderRepository;

    @Autowired
    public OrderRepositoryService (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void insertOrder(OrderRequest order) throws Exception {
        try {
            Order orderDb = new Order();
            orderDb.setName(order.getName());

            orderRepository.save(orderDb);
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
