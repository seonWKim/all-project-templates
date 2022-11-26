package com.example.springbootddd.domain.inventory;

import com.example.springbootddd.domain.film.Film;
import com.example.springbootddd.domain.store.Store;
import java.time.Instant;
import javax.persistence.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/example/springbootddd/domain/inventory/Inventory;", "", "()V", "film", "Lcom/example/springbootddd/domain/film/Film;", "getFilm", "()Lcom/example/springbootddd/domain/film/Film;", "setFilm", "(Lcom/example/springbootddd/domain/film/Film;)V", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastUpdate", "Ljava/time/Instant;", "getLastUpdate", "()Ljava/time/Instant;", "setLastUpdate", "(Ljava/time/Instant;)V", "store", "Lcom/example/springbootddd/domain/store/Store;", "getStore", "()Lcom/example/springbootddd/domain/store/Store;", "setStore", "(Lcom/example/springbootddd/domain/store/Store;)V", "spring-boot-ddd"})
@javax.persistence.Table(name = "inventory")
@javax.persistence.Entity()
public class Inventory {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "inventory_id", nullable = false)
    @javax.persistence.Id()
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "film_id", nullable = false)
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private com.example.springbootddd.domain.film.Film film;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "store_id", nullable = false)
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private com.example.springbootddd.domain.store.Store store;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Column(name = "last_update", nullable = false)
    private java.time.Instant lastUpdate;
    
    public Inventory() {
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
    public com.example.springbootddd.domain.film.Film getFilm() {
        return null;
    }
    
    public void setFilm(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.film.Film p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.springbootddd.domain.store.Store getStore() {
        return null;
    }
    
    public void setStore(@org.jetbrains.annotations.Nullable()
    com.example.springbootddd.domain.store.Store p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.time.Instant getLastUpdate() {
        return null;
    }
    
    public void setLastUpdate(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
}