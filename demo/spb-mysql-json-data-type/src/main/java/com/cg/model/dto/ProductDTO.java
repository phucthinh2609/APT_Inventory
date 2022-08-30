package com.cg.model.dto;

import com.cg.model.ComputerConfigurationParameter;
import com.cg.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private Product product;

    private List<ComputerConfigurationParameter> computerConfigurationParameters;
}
