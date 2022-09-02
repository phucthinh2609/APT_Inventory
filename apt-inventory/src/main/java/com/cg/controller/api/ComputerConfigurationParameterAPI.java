package com.cg.controller.api;
import com.cg.exception.DataInputException;
import com.cg.model.ComputerConfigurationParameter;
import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;
import com.cg.service.computerConfigurationParameter.ComputerConfigurationParameterService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/computer-configuration-parameters")
public class ComputerConfigurationParameterAPI {

    @Autowired
    private ComputerConfigurationParameterService computerConfigurationParameterService;

    @Autowired
    private AppUtils appUtils;

    @GetMapping
    public ResponseEntity<?> getAll() {

        List<ComputerConfigurationParameter> computerConfigurationParameters = computerConfigurationParameterService.findAll();

        return new ResponseEntity<>(computerConfigurationParameters, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ComputerConfigurationParameter computerConfigurationParameter) {
        try {
            ComputerConfigurationParameter newComputerConfigurationParameter = computerConfigurationParameterService.save(computerConfigurationParameter);
            return new ResponseEntity<>(newComputerConfigurationParameter, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Product creation information is not valid, please check the information again");
        }
    }
}
