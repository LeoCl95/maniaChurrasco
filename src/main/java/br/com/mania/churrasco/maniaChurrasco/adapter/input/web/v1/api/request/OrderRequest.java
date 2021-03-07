package br.com.mania.churrasco.maniaChurrasco.adapter.input.web.v1.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderRequest {

    @JsonProperty("name")
    private String name;

}
