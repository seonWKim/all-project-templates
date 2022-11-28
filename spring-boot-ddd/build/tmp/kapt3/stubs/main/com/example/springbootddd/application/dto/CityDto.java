package com.example.springbootddd.application.dto;

import java.io.Serializable;
import java.time.Instant;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u00c6\u0003J>\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\'\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006("}, d2 = {"Lcom/example/springbootddd/application/dto/CityDto;", "Ljava/io/Serializable;", "id", "", "city", "", "country", "Lcom/example/springbootddd/application/dto/CountryDto;", "lastUpdate", "Ljava/time/Instant;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/example/springbootddd/application/dto/CountryDto;Ljava/time/Instant;)V", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getCountry", "()Lcom/example/springbootddd/application/dto/CountryDto;", "setCountry", "(Lcom/example/springbootddd/application/dto/CountryDto;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/example/springbootddd/application/dto/CountryDto;Ljava/time/Instant;)Lcom/example/springbootddd/application/dto/CityDto;", "equals", "", "other", "", "hashCode", "toString", "spring-boot-ddd"})
public final class CityDto implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String city;
    @org.jetbrains.annotations.Nullable()
    private com.example.springbootddd.application.dto.CountryDto country;
    @org.jetbrains.annotations.Nullable()
    private java.time.Instant lastUpdate;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.springbootddd.application.dto.CityDto copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String city, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.CountryDto country, @org.jetbrains.annotations.Nullable()
    java.time.Instant lastUpdate) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public CityDto() {
        super();
    }
    
    public CityDto(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String city, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.CountryDto country, @org.jetbrains.annotations.Nullable()
    java.time.Instant lastUpdate) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCity() {
        return null;
    }
    
    public final void setCity(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.CountryDto component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.CountryDto getCountry() {
        return null;
    }
    
    public final void setCountry(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.CountryDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant getLastUpdate() {
        return null;
    }
    
    public final void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
}