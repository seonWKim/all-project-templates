package com.example.springbootddd.domain.address;

import com.example.springbootddd.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/example/springbootddd/domain/address/AddressRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/springbootddd/domain/address/Address;", "", "getFullAddress", "id", "", "spring-boot-ddd"})
@org.springframework.stereotype.Repository()
public abstract interface AddressRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.springbootddd.domain.address.Address, java.lang.Integer> {
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.data.jpa.repository.Query(value = "\n        select a.*, c1.*, c2.*\n        from address a \n        left join city c1 on c1.city_id = a.city_id \n        left join country c2 on c2.country_id = c1.country_id\n        where a.address_id = :id \n    ", nativeQuery = true)
    public abstract com.example.springbootddd.domain.address.Address getFullAddress(@org.springframework.data.repository.query.Param(value = "id")
    long id);
}