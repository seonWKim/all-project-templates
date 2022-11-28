package com.example.springbootddd.domain.film;

import org.hibernate.Hibernate;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/example/springbootddd/domain/film/FilmActorId;", "Ljava/io/Serializable;", "()V", "actorId", "", "getActorId", "()Ljava/lang/Integer;", "setActorId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "filmId", "getFilmId", "setFilmId", "equals", "", "other", "", "hashCode", "Companion", "spring-boot-ddd"})
@javax.persistence.Embeddable()
public class FilmActorId implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private java.lang.Integer actorId;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private java.lang.Integer filmId;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.springbootddd.domain.film.FilmActorId.Companion Companion = null;
    private static final long serialVersionUID = -5979223520575968494L;
    
    public FilmActorId() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Integer getActorId() {
        return null;
    }
    
    public void setActorId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Integer getFilmId() {
        return null;
    }
    
    public void setFilmId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/springbootddd/domain/film/FilmActorId$Companion;", "", "()V", "serialVersionUID", "", "spring-boot-ddd"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}