package com.example.springbootddd.domain.customer;

import com.example.springbootddd.domain.address.Address;
import com.example.springbootddd.domain.store.Store;
import java.time.Instant;
import javax.persistence.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010&\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0019\"\u0004\b(\u0010\u001bR \u0010)\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R \u0010,\u001a\u0004\u0018\u00010-8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00062"}, d2 = {"Lcom/example/springbootddd/domain/customer/Customer;", "", "()V", "active", "", "getActive", "()Ljava/lang/Boolean;", "setActive", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "address", "Lcom/example/springbootddd/domain/address/Address;", "getAddress", "()Lcom/example/springbootddd/domain/address/Address;", "setAddress", "(Lcom/example/springbootddd/domain/address/Address;)V", "createDate", "Ljava/time/Instant;", "getCreateDate", "()Ljava/time/Instant;", "setCreateDate", "(Ljava/time/Instant;)V", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "firstName", "getFirstName", "setFirstName", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastName", "getLastName", "setLastName", "lastUpdate", "getLastUpdate", "setLastUpdate", "store", "Lcom/example/springbootddd/domain/store/Store;", "getStore", "()Lcom/example/springbootddd/domain/store/Store;", "setStore", "(Lcom/example/springbootddd/domain/store/Store;)V", "spring-boot-ddd"})
@javax.persistence.Table(name = "customer")
@javax.persistence.Entity()
public class Customer {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "customer_id", columnDefinition = "SMALLINT UNSIGNED not null")
    @javax.persistence.Id()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "store_id", nullable = false)
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private com.example.springbootddd.domain.store.Store store;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "first_name", nullable = false, length = 45)
    private java.lang.String firstName;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "last_name", nullable = false, length = 45)
    private java.lang.String lastName;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "email", length = 50)
    private java.lang.String email;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "address_id", nullable = false)
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private com.example.springbootddd.domain.address.Address address;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "active", nullable = false)
    private java.lang.Boolean active = false;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "create_date", nullable = false)
    private java.time.Instant createDate;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "last_update")
    private java.time.Instant lastUpdate;
    
    public Customer() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Integer getId() {
        return null;
    }
    
    public void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.store.Store getStore() {
        return null;
    }
    
    public void setStore(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.store.Store p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getFirstName() {
        return null;
    }
    
    public void setFirstName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getLastName() {
        return null;
    }
    
    public void setLastName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getEmail() {
        return null;
    }
    
    public void setEmail(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.address.Address getAddress() {
        return null;
    }
    
    public void setAddress(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.address.Address p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean getActive() {
        return null;
    }
    
    public void setActive(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.time.Instant getCreateDate() {
        return null;
    }
    
    public void setCreateDate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.time.Instant getLastUpdate() {
        return null;
    }
    
    public void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
}