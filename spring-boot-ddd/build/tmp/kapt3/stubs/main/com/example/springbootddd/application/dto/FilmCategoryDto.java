package com.example.springbootddd.application.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002!\"B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/example/springbootddd/application/dto/FilmCategoryDto;", "Ljava/io/Serializable;", "film", "Lcom/example/springbootddd/application/dto/FilmCategoryDto$FilmDto;", "category", "Lcom/example/springbootddd/application/dto/FilmCategoryDto$CategoryDto;", "lastUpdate", "Ljava/time/Instant;", "(Lcom/example/springbootddd/application/dto/FilmCategoryDto$FilmDto;Lcom/example/springbootddd/application/dto/FilmCategoryDto$CategoryDto;Ljava/time/Instant;)V", "getCategory", "()Lcom/example/springbootddd/application/dto/FilmCategoryDto$CategoryDto;", "setCategory", "(Lcom/example/springbootddd/application/dto/FilmCategoryDto$CategoryDto;)V", "getFilm", "()Lcom/example/springbootddd/application/dto/FilmCategoryDto$FilmDto;", "setFilm", "(Lcom/example/springbootddd/application/dto/FilmCategoryDto$FilmDto;)V", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "CategoryDto", "FilmDto", "spring-boot-ddd"})
public final class FilmCategoryDto implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    private com.example.springbootddd.application.dto.FilmCategoryDto.FilmDto film;
    @org.jetbrains.annotations.Nullable()
    private com.example.springbootddd.application.dto.FilmCategoryDto.CategoryDto category;
    @org.jetbrains.annotations.Nullable()
    private java.time.Instant lastUpdate;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.springbootddd.application.dto.FilmCategoryDto copy(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.FilmCategoryDto.FilmDto film, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.FilmCategoryDto.CategoryDto category, @org.jetbrains.annotations.Nullable()
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
    
    public FilmCategoryDto() {
        super();
    }
    
    public FilmCategoryDto(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.FilmCategoryDto.FilmDto film, @org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.FilmCategoryDto.CategoryDto category, @org.jetbrains.annotations.Nullable()
    java.time.Instant lastUpdate) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.FilmCategoryDto.FilmDto component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.FilmCategoryDto.FilmDto getFilm() {
        return null;
    }
    
    public final void setFilm(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.FilmCategoryDto.FilmDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.FilmCategoryDto.CategoryDto component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.springbootddd.application.dto.FilmCategoryDto.CategoryDto getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.application.dto.FilmCategoryDto.CategoryDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant getLastUpdate() {
        return null;
    }
    
    public final void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u000b\u0010?\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u000b\u0010F\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00100J\u000b\u0010I\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u00aa\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00c6\u0001\u00a2\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PH\u00d6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00d6\u0001J\t\u0010R\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\'\u0010\u001b\"\u0004\b(\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019\u00a8\u0006S"}, d2 = {"Lcom/example/springbootddd/application/dto/FilmCategoryDto$FilmDto;", "Ljava/io/Serializable;", "id", "", "title", "", "description", "releaseYear", "language", "Lcom/example/springbootddd/application/dto/LanguageDto;", "originalLanguage", "rentalDuration", "", "rentalRate", "Ljava/math/BigDecimal;", "length", "replacementCost", "rating", "specialFeatures", "lastUpdate", "Ljava/time/Instant;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/example/springbootddd/application/dto/LanguageDto;Lcom/example/springbootddd/application/dto/LanguageDto;Ljava/lang/Short;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/time/Instant;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLanguage", "()Lcom/example/springbootddd/application/dto/LanguageDto;", "setLanguage", "(Lcom/example/springbootddd/application/dto/LanguageDto;)V", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "getLength", "setLength", "getOriginalLanguage", "setOriginalLanguage", "getRating", "setRating", "getReleaseYear", "setReleaseYear", "getRentalDuration", "()Ljava/lang/Short;", "setRentalDuration", "(Ljava/lang/Short;)V", "Ljava/lang/Short;", "getRentalRate", "()Ljava/math/BigDecimal;", "setRentalRate", "(Ljava/math/BigDecimal;)V", "getReplacementCost", "setReplacementCost", "getSpecialFeatures", "setSpecialFeatures", "getTitle", "setTitle", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/example/springbootddd/application/dto/LanguageDto;Lcom/example/springbootddd/application/dto/LanguageDto;Ljava/lang/Short;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/time/Instant;)Lcom/example/springbootddd/application/dto/FilmCategoryDto$FilmDto;", "equals", "", "other", "", "hashCode", "toString", "spring-boot-ddd"})
    public static final class FilmDto implements java.io.Serializable {
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
        public final com.example.springbootddd.application.dto.FilmCategoryDto.FilmDto copy(@org.jetbrains.annotations.Nullable()
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
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/example/springbootddd/application/dto/FilmCategoryDto$CategoryDto;", "Ljava/io/Serializable;", "id", "", "name", "", "lastUpdate", "Ljava/time/Instant;", "(Ljava/lang/Short;Ljava/lang/String;Ljava/time/Instant;)V", "getId", "()Ljava/lang/Short;", "setId", "(Ljava/lang/Short;)V", "Ljava/lang/Short;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Short;Ljava/lang/String;Ljava/time/Instant;)Lcom/example/springbootddd/application/dto/FilmCategoryDto$CategoryDto;", "equals", "", "other", "", "hashCode", "", "toString", "spring-boot-ddd"})
    public static final class CategoryDto implements java.io.Serializable {
        @org.jetbrains.annotations.Nullable()
        private java.lang.Short id;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String name;
        @org.jetbrains.annotations.Nullable()
        private java.time.Instant lastUpdate;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.springbootddd.application.dto.FilmCategoryDto.CategoryDto copy(@org.jetbrains.annotations.Nullable()
        java.lang.Short id, @org.jetbrains.annotations.Nullable()
        java.lang.String name, @org.jetbrains.annotations.Nullable()
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
        
        public CategoryDto() {
            super();
        }
        
        public CategoryDto(@org.jetbrains.annotations.Nullable()
        java.lang.Short id, @org.jetbrains.annotations.Nullable()
        java.lang.String name, @org.jetbrains.annotations.Nullable()
        java.time.Instant lastUpdate) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Short component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Short getId() {
            return null;
        }
        
        public final void setId(@org.jetbrains.annotations.Nullable()
        java.lang.Short p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.time.Instant component3() {
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
}