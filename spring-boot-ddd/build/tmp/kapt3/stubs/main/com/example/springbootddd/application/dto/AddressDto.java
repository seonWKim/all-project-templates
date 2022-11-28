package com.example.springbootddd.application.dto;

import org.locationtech.jts.geom.Point;
import java.io.Serializable;
import java.time.Instant;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003Jz\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001\u00a2\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u00d6\u0003J\t\u0010=\u001a\u00020\u0003H\u00d6\u0001J\t\u0010>\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014\u00a8\u0006?"}, d2 = {"Lcom/example/springbootddd/application/dto/AddressDto;", "Ljava/io/Serializable;", "id", "", "address", "", "address2", "district", "city", "Lcom/example/springbootddd/application/dto/CityDto;", "postalCode", "phone", "lastUpdate", "Ljava/time/Instant;", "location", "Lorg/locationtech/jts/geom/Point;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/springbootddd/application/dto/CityDto;Ljava/lang/String;Ljava/lang/String;Ljava/time/Instant;Lorg/locationtech/jts/geom/Point;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAddress2", "setAddress2", "getCity", "()Lcom/example/springbootddd/application/dto/CityDto;", "setCity", "(Lcom/example/springbootddd/application/dto/CityDto;)V", "getDistrict", "setDistrict", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "getLocation", "()Lorg/locationtech/jts/geom/Point;", "setLocation", "(Lorg/locationtech/jts/geom/Point;)V", "getPhone", "setPhone", "getPostalCode", "setPostalCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/springbootddd/application/dto/CityDto;Ljava/lang/String;Ljava/lang/String;Ljava/time/Instant;Lorg/locationtech/jts/geom/Point;)Lcom/example/springbootddd/application/dto/AddressDto;", "equals", "", "other", "", "hashCode", "toString", "spring-boot-ddd"})
public final class AddressDto implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String address;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String address2;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String district;
    @org.jetbrains.annotations.Nullable()
    private com.example.springbootddd.application.dto.CityDto city;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String postalCode;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String phone;
    @org.jetbrains.annotations.Nullable()
    private java.time.Instant lastUpdate;
    @org.jetbrains.annotations.Nullable()
    private org.locationtech.jts.geom.Point location;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.springbootddd.application.dto.AddressDto copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String address, @org.jetbrains.annotations.Nullable()
    java.lang.String address2, @org.jetbrains.annotations.Nullable()
    java.lang.String district, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.CityDto city, @org.jetbrains.annotations.Nullable()
    java.lang.String postalCode, @org.jetbrains.annotations.Nullable()
    java.lang.String phone, @org.jetbrains.annotations.Nullable()
    java.time.Instant lastUpdate, @org.jetbrains.annotations.Nullable()
    org.locationtech.jts.geom.Point location) {
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
    
    public AddressDto() {
        super();
    }
    
    public AddressDto(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String address, @org.jetbrains.annotations.Nullable()
    java.lang.String address2, @org.jetbrains.annotations.Nullable()
    java.lang.String district, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.CityDto city, @org.jetbrains.annotations.Nullable()
    java.lang.String postalCode, @org.jetbrains.annotations.Nullable()
    java.lang.String phone, @org.jetbrains.annotations.Nullable()
    java.time.Instant lastUpdate, @org.jetbrains.annotations.Nullable()
    org.locationtech.jts.geom.Point location) {
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
    public final java.lang.String getAddress() {
        return null;
    }
    
    public final void setAddress(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAddress2() {
        return null;
    }
    
    public final void setAddress2(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDistrict() {
        return null;
    }
    
    public final void setDistrict(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.CityDto component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.CityDto getCity() {
        return null;
    }
    
    public final void setCity(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.CityDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPostalCode() {
        return null;
    }
    
    public final void setPostalCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhone() {
        return null;
    }
    
    public final void setPhone(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant getLastUpdate() {
        return null;
    }
    
    public final void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.locationtech.jts.geom.Point component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.locationtech.jts.geom.Point getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.Nullable()
    org.locationtech.jts.geom.Point p0) {
    }
}