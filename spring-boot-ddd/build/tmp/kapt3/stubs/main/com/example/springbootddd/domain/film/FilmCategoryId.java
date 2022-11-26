package com.example.springbootddd.domain.film;

import org.hibernate.Hibernate;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/example/springbootddd/domain/film/FilmCategoryId;", "Ljava/io/Serializable;", "()V", "categoryId", "", "getCategoryId", "()Ljava/lang/Short;", "setCategoryId", "(Ljava/lang/Short;)V", "Ljava/lang/Short;", "filmId", "", "getFilmId", "()Ljava/lang/Integer;", "setFilmId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "equals", "", "other", "", "hashCode", "Companion", "spring-boot-ddd"})
@javax.persistence.Embeddable()
public class FilmCategoryId implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private java.lang.Integer filmId;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED not null")
    private java.lang.Short categoryId;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.springbootddd.domain.film.FilmCategoryId.Companion Companion = null;
    private static final long serialVersionUID = 2189030900042729598L;
    
    public FilmCategoryId() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Integer getFilmId() {
        return null;
    }
    
    public void setFilmId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Short getCategoryId() {
        return null;
    }
    
    public void setCategoryId(@org.jetbrains.annotations.Nullable()
    java.lang.Short p0) {
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/springbootddd/domain/film/FilmCategoryId$Companion;", "", "()V", "serialVersionUID", "", "spring-boot-ddd"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}