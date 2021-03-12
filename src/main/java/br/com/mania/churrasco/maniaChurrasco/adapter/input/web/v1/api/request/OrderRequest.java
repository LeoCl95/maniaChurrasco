package br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.api.request;

import br.com.mania.churrasco.maniaChurrasco.application.domain.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderRequest {

    @JsonProperty("products")
    private List<Product> products;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("quantity_of_itens")
    private Integer quantityOfItens;

    @JsonProperty("suggestive_sales")
    private List<String> suggestiveSales;

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("table")
    private String table;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("notes")
    private List<String> notes;

}
