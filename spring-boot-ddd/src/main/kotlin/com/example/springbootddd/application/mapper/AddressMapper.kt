package com.example.springbootddd.application.mapper

import com.example.springbootddd.application.dto.AddressDto
import com.example.springbootddd.domain.address.Address
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class AddressMapper {

    abstract fun addressDtoToAddress(addressDto: AddressDto): Address

    abstract fun addressToAddressDto(address: Address): AddressDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updateAddressFromAddressDto(addressDto: AddressDto, @MappingTarget address: Address): Address
}