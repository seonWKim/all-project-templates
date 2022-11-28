package com.example.springbootddd.domain.address;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<Address, Int> {

    @Query(
        """
        select a 
        from Address as a  
        join fetch a.city as c 
        join fetch c.country
        where a.id = :id
        """
    )
    fun getFullAddress(@Param("id") id: Int): Address
}