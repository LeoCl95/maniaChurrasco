package br.com.mania.churrasco.maniaChurrasco.adapter.output.database.repository;

import br.com.mania.churrasco.maniaChurrasco.application.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
