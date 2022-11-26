package com.example.springbootddd;

import com.example.springbootddd.domain.address.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<Address, Int> {

    @Query(value = """
        select a.*, c1.*, c2.*
        from address a 
        left join city c1 on c1.city_id = a.city_id 
        left join country c2 on c2.country_id = c1.country_id
        where a.address_id = :id 
    """, nativeQuery = true,)
    fun getFullAddress(@Param("id") id: Long): Address
}