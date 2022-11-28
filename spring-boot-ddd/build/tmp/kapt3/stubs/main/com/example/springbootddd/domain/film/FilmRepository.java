package com.example.springbootddd.domain.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/springbootddd/domain/film/FilmRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/springbootddd/domain/film/Film;", "", "findByTitle", "", "title", "", "spring-boot-ddd"})
@org.springframework.stereotype.Repository()
public abstract interface FilmRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.springbootddd.domain.film.Film, java.lang.Long> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.springbootddd.domain.film.Film> findByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title);
}