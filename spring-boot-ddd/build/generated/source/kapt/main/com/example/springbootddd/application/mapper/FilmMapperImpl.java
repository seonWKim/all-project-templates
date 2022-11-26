package com.example.springbootddd.application.mapper;

import com.example.springbootddd.application.dto.FilmDto;
import com.example.springbootddd.application.dto.LanguageDto;
import com.example.springbootddd.domain.film.Film;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-26T21:23:02+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from kotlin-annotation-processing-gradle-1.7.21.jar, environment: Java 11.0.14 (BellSoft)"
)
@Component
public class FilmMapperImpl extends FilmMapper {

    @Override
    public Film filmDtoToFilm(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Film film = new Film();

        film.setId( filmDto.getId() );
        film.setTitle( filmDto.getTitle() );
        film.setDescription( filmDto.getDescription() );
        film.setReleaseYear( filmDto.getReleaseYear() );
        film.setLanguage( languageDtoToLanguage( filmDto.getLanguage() ) );
        film.setOriginalLanguage( languageDtoToLanguage( filmDto.getOriginalLanguage() ) );
        film.setRentalDuration( filmDto.getRentalDuration() );
        film.setRentalRate( filmDto.getRentalRate() );
        film.setLength( filmDto.getLength() );
        film.setReplacementCost( filmDto.getReplacementCost() );
        film.setRating( filmDto.getRating() );
        film.setSpecialFeatures( filmDto.getSpecialFeatures() );
        film.setLastUpdate( filmDto.getLastUpdate() );

        return film;
    }

    @Override
    public FilmDto filmToFilmDto(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmDto filmDto = new FilmDto();

        filmDto.setId( film.getId() );
        filmDto.setTitle( film.getTitle() );
        filmDto.setDescription( film.getDescription() );
        filmDto.setReleaseYear( film.getReleaseYear() );
        filmDto.setLanguage( languageToLanguageDto( film.getLanguage() ) );
        filmDto.setOriginalLanguage( languageToLanguageDto( film.getOriginalLanguage() ) );
        filmDto.setRentalDuration( film.getRentalDuration() );
        filmDto.setRentalRate( film.getRentalRate() );
        filmDto.setLength( film.getLength() );
        filmDto.setReplacementCost( film.getReplacementCost() );
        filmDto.setRating( film.getRating() );
        filmDto.setSpecialFeatures( film.getSpecialFeatures() );
        filmDto.setLastUpdate( film.getLastUpdate() );

        return filmDto;
    }

    @Override
    public Film updateFilmFromFilmDto(FilmDto filmDto, Film film) {
        if ( filmDto == null ) {
            return film;
        }

        if ( filmDto.getId() != null ) {
            film.setId( filmDto.getId() );
        }
        if ( filmDto.getTitle() != null ) {
            film.setTitle( filmDto.getTitle() );
        }
        if ( filmDto.getDescription() != null ) {
            film.setDescription( filmDto.getDescription() );
        }
        if ( filmDto.getReleaseYear() != null ) {
            film.setReleaseYear( filmDto.getReleaseYear() );
        }
        if ( filmDto.getLanguage() != null ) {
            if ( film.getLanguage() == null ) {
                film.setLanguage( new Film.Language() );
            }
            languageDtoToLanguage1( filmDto.getLanguage(), film.getLanguage() );
        }
        if ( filmDto.getOriginalLanguage() != null ) {
            if ( film.getOriginalLanguage() == null ) {
                film.setOriginalLanguage( new Film.Language() );
            }
            languageDtoToLanguage1( filmDto.getOriginalLanguage(), film.getOriginalLanguage() );
        }
        if ( filmDto.getRentalDuration() != null ) {
            film.setRentalDuration( filmDto.getRentalDuration() );
        }
        if ( filmDto.getRentalRate() != null ) {
            film.setRentalRate( filmDto.getRentalRate() );
        }
        if ( filmDto.getLength() != null ) {
            film.setLength( filmDto.getLength() );
        }
        if ( filmDto.getReplacementCost() != null ) {
            film.setReplacementCost( filmDto.getReplacementCost() );
        }
        if ( filmDto.getRating() != null ) {
            film.setRating( filmDto.getRating() );
        }
        if ( filmDto.getSpecialFeatures() != null ) {
            film.setSpecialFeatures( filmDto.getSpecialFeatures() );
        }
        if ( filmDto.getLastUpdate() != null ) {
            film.setLastUpdate( filmDto.getLastUpdate() );
        }

        return film;
    }

    protected Film.Language languageDtoToLanguage(LanguageDto languageDto) {
        if ( languageDto == null ) {
            return null;
        }

        Film.Language language = new Film.Language();

        language.setId( languageDto.getId() );
        language.setName( languageDto.getName() );
        language.setLastUpdate( languageDto.getLastUpdate() );

        return language;
    }

    protected LanguageDto languageToLanguageDto(Film.Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setId( language.getId() );
        languageDto.setName( language.getName() );
        languageDto.setLastUpdate( language.getLastUpdate() );

        return languageDto;
    }

    protected void languageDtoToLanguage1(LanguageDto languageDto, Film.Language mappingTarget) {
        if ( languageDto == null ) {
            return;
        }

        mappingTarget.setId( languageDto.getId() );
        mappingTarget.setName( languageDto.getName() );
        mappingTarget.setLastUpdate( languageDto.getLastUpdate() );
    }
}
