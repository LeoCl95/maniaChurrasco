package br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.api;

import br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.api.request.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/mania/order")
public interface OrderApi {

    @PostMapping
    ResponseEntity<Void> createOrder(@RequestBody OrderRequest order) throws Exception;

}
