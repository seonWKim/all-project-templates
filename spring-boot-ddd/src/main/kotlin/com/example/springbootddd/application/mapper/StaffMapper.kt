package com.example.springbootddd.application.mapper

import com.example.springbootddd.application.dto.StaffDto
import com.example.springbootddd.domain.staff.Staff
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class StaffMapper {

    abstract fun staffDtoToStaff(staffDto: StaffDto): Staff

    abstract fun staffToStaffDto(staff: Staff): StaffDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun updateStaffFromStaffDto(staffDto: StaffDto, @MappingTarget staff: Staff): Staff
}