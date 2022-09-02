package com.cg.controller.api;
import com.cg.model.ComputerConfigurationParameter;
import com.cg.service.computerConfigurationParameter.ComputerConfigurationParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/computer-configuration-parameters")
public class ComputerConfigurationParameterRestController {

    @Autowired
    private ComputerConfigurationParameterService computerConfigurationParameterService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        List<ComputerConfigurationParameter> computerConfigurationParameters = computerConfigurationParameterService.findAll();

        return new ResponseEntity<>(computerConfigurationParameters, HttpStatus.OK);
    }
}
