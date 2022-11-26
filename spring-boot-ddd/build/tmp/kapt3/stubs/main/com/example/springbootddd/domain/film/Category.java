package com.example.springbootddd.domain.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;
import javax.persistence.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/example/springbootddd/domain/film/Category;", "", "()V", "filmCategories", "", "Lcom/example/springbootddd/domain/film/FilmCategory;", "getFilmCategories", "()Ljava/util/Set;", "setFilmCategories", "(Ljava/util/Set;)V", "id", "", "getId", "()Ljava/lang/Short;", "setId", "(Ljava/lang/Short;)V", "Ljava/lang/Short;", "lastUpdate", "Ljava/time/Instant;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "spring-boot-ddd"})
@javax.persistence.Table(name = "category")
@javax.persistence.Entity()
public class Category {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED not null")
    @javax.persistence.Id()
    private java.lang.Short id;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "name", nullable = false, length = 25)
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "last_update", nullable = false)
    private java.time.Instant lastUpdate;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.OneToMany(mappedBy = "category")
    private java.util.Set<com.example.springbootddd.domain.film.FilmCategory> filmCategories;
    
    public Category() {
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
    
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<com.example.springbootddd.domain.film.FilmCategory> getFilmCategories() {
        return null;
    }
    
    public void setFilmCategories(@org.jetbrains.annotations.NotNull()
    java.util.Set<com.example.springbootddd.domain.film.FilmCategory> p0) {
    }
}