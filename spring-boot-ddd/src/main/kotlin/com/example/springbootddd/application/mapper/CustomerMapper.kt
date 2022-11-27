package com.example.springbootddd.application.mapper

import com.example.springbootddd.application.dto.CustomerDto
import com.example.springbootddd.domain.customer.Customer
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class CustomerMapper {

    abstract fun customerDtoToCustomer(customerDto: CustomerDto): Customer

    abstract fun customerToCustomerDto(customer: Customer): CustomerDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updateCustomerFromCustomerDto(customerDto: CustomerDto, @MappingTarget customer: Customer): Customer
}