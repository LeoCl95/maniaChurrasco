package br.com.mania.churrasco.maniaChurrasco.application.port.output;

import br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.api.request.OrderRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryPort {

    void insertOrder (OrderRequest order) throws Exception;
}
