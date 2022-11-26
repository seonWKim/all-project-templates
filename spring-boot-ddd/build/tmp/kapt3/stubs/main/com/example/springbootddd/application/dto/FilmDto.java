package com.example.springbootddd.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u00b1\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u000b\u0010F\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u000b\u0010N\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00107J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u00ba\u0001\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u00c6\u0001\u00a2\u0006\u0002\u0010TJ\u0013\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010XH\u00d6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00d6\u0001J\t\u0010Z\u001a\u00020\u0005H\u00d6\u0001R$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\'\"\u0004\b1\u0010)R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b4\u0010\"\"\u0004\b5\u0010$R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 \u00a8\u0006["}, d2 = {"Lcom/example/springbootddd/application/dto/FilmDto;", "Ljava/io/Serializable;", "id", "", "title", "", "description", "releaseYear", "language", "Lcom/example/springbootddd/application/dto/LanguageDto;", "originalLanguage", "rentalDuration", "", "rentalRate", "Ljava/math/BigDecimal;", "length", "replacementCost", "rating", "specialFeatures", "lastUpdate", "Ljava/time/Instant;", "categories", "", "Lcom/example/springbootddd/application/dto/CategoryDto;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/example/springbootddd/application/dto/LanguageDto;Lcom/example/springbootddd/application/dto/LanguageDto;Ljava/lang/Short;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/time/Instant;Ljava/util/Set;)V", "getCategories", "()Ljava/util/Set;", "setCategories", "(Ljava/util/Set;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLanguage", "()Lcom/example/springbootddd/application/dto/LanguageDto;", "setLanguage", "(Lcom/example/springbootddd/application/dto/LanguageDto;)V", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "getLength", "setLength", "getOriginalLanguage", "setOriginalLanguage", "getRating", "setRating", "getReleaseYear", "setReleaseYear", "getRentalDuration", "()Ljava/lang/Short;", "setRentalDuration", "(Ljava/lang/Short;)V", "Ljava/lang/Short;", "getRentalRate", "()Ljava/math/BigDecimal;", "setRentalRate", "(Ljava/math/BigDecimal;)V", "getReplacementCost", "setReplacementCost", "getSpecialFeatures", "setSpecialFeatures", "getTitle", "setTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/example/springbootddd/application/dto/LanguageDto;Lcom/example/springbootddd/application/dto/LanguageDto;Ljava/lang/Short;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/time/Instant;Ljava/util/Set;)Lcom/example/springbootddd/application/dto/FilmDto;", "equals", "", "other", "", "hashCode", "toString", "spring-boot-ddd"})
public final class FilmDto implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String title;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer releaseYear;
    @org.jetbrains.annotations.Nullable()
    private com.example.springbootddd.application.dto.LanguageDto language;
    @org.jetbrains.annotations.Nullable()
    private com.example.springbootddd.application.dto.LanguageDto originalLanguage;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Short rentalDuration;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal rentalRate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer length;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal replacementCost;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String rating;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String specialFeatures;
    @org.jetbrains.annotations.Nullable()
    private java.time.Instant lastUpdate;
    @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties(value = {"films"})
    private java.util.Set<com.example.springbootddd.application.dto.CategoryDto> categories;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.springbootddd.application.dto.FilmDto copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.Integer releaseYear, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.LanguageDto language, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.LanguageDto originalLanguage, @org.jetbrains.annotations.Nullable()
    java.lang.Short rentalDuration, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal rentalRate, @org.jetbrains.annotations.Nullable()
    java.lang.Integer length, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal replacementCost, @org.jetbrains.annotations.Nullable()
    java.lang.String rating, @org.jetbrains.annotations.Nullable()
    java.lang.String specialFeatures, @org.jetbrains.annotations.Nullable()
    java.time.Instant lastUpdate, @org.jetbrains.annotations.NotNull()
    java.util.Set<com.example.springbootddd.application.dto.CategoryDto> categories) {
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
    
    public FilmDto() {
        super();
    }
    
    public FilmDto(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.Integer releaseYear, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.LanguageDto language, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.LanguageDto originalLanguage, @org.jetbrains.annotations.Nullable()
    java.lang.Short rentalDuration, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal rentalRate, @org.jetbrains.annotations.Nullable()
    java.lang.Integer length, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal replacementCost, @org.jetbrains.annotations.Nullable()
    java.lang.String rating, @org.jetbrains.annotations.Nullable()
    java.lang.String specialFeatures, @org.jetbrains.annotations.Nullable()
    java.time.Instant lastUpdate, @org.jetbrains.annotations.NotNull()
    java.util.Set<com.example.springbootddd.application.dto.CategoryDto> categories) {
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
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getReleaseYear() {
        return null;
    }
    
    public final void setReleaseYear(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.LanguageDto component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.LanguageDto getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.LanguageDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.LanguageDto component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.LanguageDto getOriginalLanguage() {
        return null;
    }
    
    public final void setOriginalLanguage(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.LanguageDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Short component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Short getRentalDuration() {
        return null;
    }
    
    public final void setRentalDuration(@org.jetbrains.annotations.Nullable()
    java.lang.Short p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getRentalRate() {
        return null;
    }
    
    public final void setRentalRate(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLength() {
        return null;
    }
    
    public final void setLength(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getReplacementCost() {
        return null;
    }
    
    public final void setReplacementCost(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRating() {
        return null;
    }
    
    public final void setRating(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSpecialFeatures() {
        return null;
    }
    
    public final void setSpecialFeatures(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant getLastUpdate() {
        return null;
    }
    
    public final void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<com.example.springbootddd.application.dto.CategoryDto> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<com.example.springbootddd.application.dto.CategoryDto> getCategories() {
        return null;
    }
    
    public final void setCategories(@org.jetbrains.annotations.NotNull()
    java.util.Set<com.example.springbootddd.application.dto.CategoryDto> p0) {
    }
}