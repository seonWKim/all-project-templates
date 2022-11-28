package com.example.springbootddd.domain.film;

import com.example.springbootddd.domain.film.FilmCategory;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001:\u0002EFB\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R \u0010&\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001a\"\u0004\b(\u0010\u001cR \u0010)\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\"\u0010/\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u00106\u001a\u0004\u0018\u0001078\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R \u0010<\u001a\u0004\u0018\u0001078\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R \u0010?\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR \u0010B\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\b\u00a8\u0006G"}, d2 = {"Lcom/example/springbootddd/domain/film/Film;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "filmCategories", "", "Lcom/example/springbootddd/domain/film/FilmCategory;", "getFilmCategories", "()Ljava/util/Set;", "setFilmCategories", "(Ljava/util/Set;)V", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "language", "Lcom/example/springbootddd/domain/film/Film$Language;", "getLanguage", "()Lcom/example/springbootddd/domain/film/Film$Language;", "setLanguage", "(Lcom/example/springbootddd/domain/film/Film$Language;)V", "lastUpdate", "Ljava/time/Instant;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "length", "getLength", "setLength", "originalLanguage", "getOriginalLanguage", "setOriginalLanguage", "rating", "getRating", "setRating", "releaseYear", "getReleaseYear", "setReleaseYear", "rentalDuration", "", "getRentalDuration", "()Ljava/lang/Short;", "setRentalDuration", "(Ljava/lang/Short;)V", "Ljava/lang/Short;", "rentalRate", "Ljava/math/BigDecimal;", "getRentalRate", "()Ljava/math/BigDecimal;", "setRentalRate", "(Ljava/math/BigDecimal;)V", "replacementCost", "getReplacementCost", "setReplacementCost", "specialFeatures", "getSpecialFeatures", "setSpecialFeatures", "title", "getTitle", "setTitle", "FilmText", "Language", "spring-boot-ddd"})
@javax.persistence.Table(name = "film")
@javax.persistence.Entity()
public class Film {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED not null")
    @javax.persistence.Id()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "title", nullable = false)
    private java.lang.String title;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "description")
    @javax.persistence.Lob()
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "release_year")
    private java.lang.Integer releaseYear;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "language_id", nullable = false)
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER, optional = false)
    private com.example.springbootddd.domain.film.Film.Language language;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "original_language_id")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private com.example.springbootddd.domain.film.Film.Language originalLanguage;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "rental_duration", columnDefinition = "TINYINT UNSIGNED not null")
    private java.lang.Short rentalDuration;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
    private java.math.BigDecimal rentalRate;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "length", columnDefinition = "SMALLINT UNSIGNED")
    private java.lang.Integer length;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
    private java.math.BigDecimal replacementCost;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "rating")
    @javax.persistence.Lob()
    private java.lang.String rating;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "special_features")
    @javax.persistence.Lob()
    private java.lang.String specialFeatures;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "last_update", nullable = false)
    private java.time.Instant lastUpdate;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.OneToMany(mappedBy = "film")
    private java.util.Set<com.example.springbootddd.domain.film.FilmCategory> filmCategories;
    
    public Film() {
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
    public java.lang.String getTitle() {
        return null;
    }
    
    public void setTitle(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getDescription() {
        return null;
    }
    
    public void setDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Integer getReleaseYear() {
        return null;
    }
    
    public void setReleaseYear(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.film.Film.Language getLanguage() {
        return null;
    }
    
    public void setLanguage(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.film.Film.Language p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.film.Film.Language getOriginalLanguage() {
        return null;
    }
    
    public void setOriginalLanguage(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.film.Film.Language p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Short getRentalDuration() {
        return null;
    }
    
    public void setRentalDuration(@org.jetbrains.annotations.Nullable()
    java.lang.Short p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.math.BigDecimal getRentalRate() {
        return null;
    }
    
    public void setRentalRate(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Integer getLength() {
        return null;
    }
    
    public void setLength(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.math.BigDecimal getReplacementCost() {
        return null;
    }
    
    public void setReplacementCost(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getRating() {
        return null;
    }
    
    public void setRating(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getSpecialFeatures() {
        return null;
    }
    
    public void setSpecialFeatures(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.time.Instant getLastUpdate() {
        return null;
    }
    
    public void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<com.example.springbootddd.domain.film.FilmCategory> getFilmCategories() {
        return null;
    }
    
    public void setFilmCategories(@org.jetbrains.annotations.NotNull()
    java.util.Set<com.example.springbootddd.domain.film.FilmCategory> p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/example/springbootddd/domain/film/Film$Language;", "", "()V", "id", "", "getId", "()Ljava/lang/Short;", "setId", "(Ljava/lang/Short;)V", "Ljava/lang/Short;", "lastUpdate", "Ljava/time/Instant;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "spring-boot-ddd"})
    @javax.persistence.Table(name = "language")
    @javax.persistence.Entity()
    public static class Language {
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "language_id", columnDefinition = "TINYINT UNSIGNED not null")
        @javax.persistence.Id()
        private java.lang.Short id;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "name", nullable = false, length = 20)
        private java.lang.String name;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "last_update", nullable = false)
        private java.time.Instant lastUpdate;
        
        public Language() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public java.lang.Short getId() {
            return null;
        }
        
        public void setId(@org.jetbrains.annotations.Nullable()
        java.lang.Short p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public java.lang.String getName() {
            return null;
        }
        
        public void setName(@org.jetbrains.annotations.Nullable()
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/example/springbootddd/domain/film/Film$FilmText;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "id", "", "getId", "()Ljava/lang/Short;", "setId", "(Ljava/lang/Short;)V", "Ljava/lang/Short;", "title", "getTitle", "setTitle", "spring-boot-ddd"})
    @javax.persistence.Table(name = "film_text")
    @javax.persistence.Entity()
    public static class FilmText {
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "film_id", nullable = false)
        @javax.persistence.Id()
        private java.lang.Short id;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "title", nullable = false)
        private java.lang.String title;
        @org.jetbrains.annotations.Nullable()
        @javax.persistence.Column(name = "description")
        @javax.persistence.Lob()
        private java.lang.String description;
        
        public FilmText() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public java.lang.Short getId() {
            return null;
        }
        
        public void setId(@org.jetbrains.annotations.Nullable()
        java.lang.Short p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public java.lang.String getTitle() {
            return null;
        }
        
        public void setTitle(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public java.lang.String getDescription() {
            return null;
        }
        
        public void setDescription(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
    }
}