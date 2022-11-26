package com.example.springbootddd.adapter.controller;

import com.example.springbootddd.application.dto.AddressDto;
import com.example.springbootddd.application.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/springbootddd/adapter/controller/AddressController;", "", "addressService", "Lcom/example/springbootddd/application/service/AddressService;", "(Lcom/example/springbootddd/application/service/AddressService;)V", "findById", "Lcom/example/springbootddd/application/dto/AddressDto;", "id", "", "spring-boot-ddd"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/address"})
@org.springframework.web.bind.annotation.RestController()
public class AddressController {
    private final com.example.springbootddd.application.service.AddressService addressService = null;
    
    public AddressController(@org.jetbrains.annotations.NotNull()
    com.example.springbootddd.application.service.AddressService addressService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{id}"})
    public com.example.springbootddd.application.dto.AddressDto findById(@org.springframework.web.bind.annotation.PathVariable()
    long id) {
        return null;
    }
}