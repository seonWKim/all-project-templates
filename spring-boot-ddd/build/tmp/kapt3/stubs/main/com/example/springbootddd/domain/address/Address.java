package com.example.springbootddd.domain.address;

import org.locationtech.jts.geom.Point;
import java.time.Instant;
import javax.persistence.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001:\u0002./B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R \u0010(\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR \u0010+\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\b\u00a8\u00060"}, d2 = {"Lcom/example/springbootddd/domain/address/Address;", "", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "address2", "getAddress2", "setAddress2", "city", "Lcom/example/springbootddd/domain/address/Address$City;", "getCity", "()Lcom/example/springbootddd/domain/address/Address$City;", "setCity", "(Lcom/example/springbootddd/domain/address/Address$City;)V", "district", "getDistrict", "setDistrict", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastUpdate", "Ljava/time/Instant;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "location", "Lorg/locationtech/jts/geom/Point;", "getLocation", "()Lorg/locationtech/jts/geom/Point;", "setLocation", "(Lorg/locationtech/jts/geom/Point;)V", "phone", "getPhone", "setPhone", "postalCode", "getPostalCode", "setPostalCode", "City", "Country", "spring-boot-ddd"})
@javax.persistence.Table(name = "address")
@javax.persistence.Entity()
public class Address {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED not null")
    @javax.persistence.Id()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "address", nullable = false, length = 50)
    private java.lang.String address;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "address2", length = 50)
    private java.lang.String address2;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "district", nullable = false, length = 20)
    private java.lang.String district;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "city_id", nullable = false)
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private com.example.springbootddd.domain.address.Address.City city;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "postal_code", length = 10)
    private java.lang.String postalCode;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "phone", nullable = false, length = 20)
    private java.lang.String phone;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "last_update", nullable = false)
    private java.time.Instant lastUpdate;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "location", nullable = false, columnDefinition = "org.locationtech.jts.geom.Point")
    private org.locationtech.jts.geom.Point location;
    
    public Address() {
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
    public java.lang.String getAddress() {
        return null;
    }
    
    public void setAddress(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getAddress2() {
        return null;
    }
    
    public void setAddress2(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getDistrict() {
        return null;
    }
    
    public void setDistrict(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.address.Address.City getCity() {
        return null;
    }
    
    public void setCity(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.address.Address.City p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getPostalCode() {
        return null;
    }
    
    public void setPostalCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getPhone() {
        return null;
    }
    
    public void setPhone(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.time.Instant getLastUpdate() {
        return null;
    }
    
    public void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public org.locationtech.jts.geom.Point getLocation() {
        return null;
    }
    
    public void setLocation(@org.jetbrains.annotations.Nullable()
    org.locationtech.jts.geom.Point p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/example/springbootddd/domain/address/Address$City;", "", "()V", "city", "", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "country", "Lcom/example/springbootddd/domain/address/Address$Country;", "getCountry", "()Lcom/example/springbootddd/domain/address/Address$Country;", "setCountry", "(Lcom/example/springbootddd/domain/address/Address$Country;)V", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastUpdate", "Ljava/time/Instant;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "spring-boot-ddd"})
    @javax.persistence.Table(name = "city")
    @javax.persistence.Entity()
    public static class City {
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "city_id", columnDefinition = "SMALLINT UNSIGNED not null")
        @javax.persistence.Id()
        private java.lang.Integer id;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "city", nullable = false, length = 50)
        private java.lang.String city;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.JoinColumn(name = "country_id", nullable = false)
        @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
        private com.example.springbootddd.domain.address.Address.Country country;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "last_update", nullable = false)
        private java.time.Instant lastUpdate;
        
        public City() {
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
        public java.lang.String getCity() {
            return null;
        }
        
        public void setCity(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public com.example.springbootddd.domain.address.Address.Country getCountry() {
            return null;
        }
        
        public void setCountry(@org.jetbrains.annotations.Nullable()
        com.example.springbootddd.domain.address.Address.Country p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public java.time.Instant getLastUpdate() {
            return null;
        }
        
        public void setLastUpdate(@org.jetbrains.annotations.Nullable()
        java.time.Instant p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/example/springbootddd/domain/address/Address$Country;", "", "()V", "country", "", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastUpdate", "Ljava/time/Instant;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "spring-boot-ddd"})
    @javax.persistence.Table(name = "country")
    @javax.persistence.Entity()
    public static class Country {
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "country_id", columnDefinition = "SMALLINT UNSIGNED not null")
        @javax.persistence.Id()
        private java.lang.Integer id;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "country", nullable = false, length = 50)
        private java.lang.String country;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "last_update", nullable = false)
        private java.time.Instant lastUpdate;
        
        public Country() {
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
        public java.lang.String getCountry() {
            return null;
        }
        
        public void setCountry(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public java.time.Instant getLastUpdate() {
            return null;
        }
        
        public void setLastUpdate(@org.jetbrains.annotations.Nullable()
        java.time.Instant p0) {
        }
    }
}