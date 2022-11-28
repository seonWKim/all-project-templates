package com.example.springbootddd.application.mapper

import com.example.springbootddd.application.dto.RentalDto
import com.example.springbootddd.domain.rental.Rental
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class RentalMapper {

    abstract fun rentalDtoToRental(rentalDto: RentalDto): Rental

    abstract fun rentalToRentalDto(rental: Rental): RentalDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updateRentalFromRentalDto(rentalDto: RentalDto, @MappingTarget rental: Rental): Rental
}