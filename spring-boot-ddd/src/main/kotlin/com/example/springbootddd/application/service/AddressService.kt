package com.example.springbootddd.application.service

import com.example.springbootddd.domain.address.AddressRepository
import com.example.springbootddd.application.dto.AddressDto
import com.example.springbootddd.application.mapper.AddressMapper
import org.springframework.stereotype.Service

@Service
class AddressService(
    private val addressRepository: AddressRepository,
    private val addressMapper: AddressMapper
) {

    fun findById(id: Int): AddressDto {
        return addressMapper.addressToAddressDto(addressRepository.getFullAddress(id))
    }
}