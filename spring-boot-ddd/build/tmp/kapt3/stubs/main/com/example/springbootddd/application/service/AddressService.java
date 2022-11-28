package com.example.springbootddd.application.service;

import com.example.springbootddd.domain.address.AddressRepository;
import com.example.springbootddd.application.dto.AddressDto;
import com.example.springbootddd.application.mapper.AddressMapper;
import org.springframework.stereotype.Service;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/springbootddd/application/service/AddressService;", "", "addressRepository", "Lcom/example/springbootddd/domain/address/AddressRepository;", "addressMapper", "Lcom/example/springbootddd/application/mapper/AddressMapper;", "(Lcom/example/springbootddd/domain/address/AddressRepository;Lcom/example/springbootddd/application/mapper/AddressMapper;)V", "findById", "Lcom/example/springbootddd/application/dto/AddressDto;", "id", "", "spring-boot-ddd"})
@org.springframework.stereotype.Service()
public class AddressService {
    private final com.example.springbootddd.domain.address.AddressRepository addressRepository = null;
    private final com.example.springbootddd.application.mapper.AddressMapper addressMapper = null;
    
    public AddressService(@org.jetbrains.annotations.NotNull()
    com.example.springbootddd.domain.address.AddressRepository addressRepository, @org.jetbrains.annotations.NotNull()
    com.example.springbootddd.application.mapper.AddressMapper addressMapper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.springbootddd.application.dto.AddressDto findById(long id) {
        return null;
    }
}