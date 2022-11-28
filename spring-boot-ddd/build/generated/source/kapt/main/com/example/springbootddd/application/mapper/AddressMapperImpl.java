package com.example.springbootddd.application.mapper;

import com.example.springbootddd.application.dto.AddressDto;
import com.example.springbootddd.application.dto.CityDto;
import com.example.springbootddd.application.dto.CountryDto;
import com.example.springbootddd.domain.address.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-26T18:56:13+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from kotlin-annotation-processing-gradle-1.7.21.jar, environment: Java 11.0.14 (BellSoft)"
)
@Component
public class AddressMapperImpl extends AddressMapper {

    @Override
    public Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setAddress( addressDto.getAddress() );
        address.setAddress2( addressDto.getAddress2() );
        address.setDistrict( addressDto.getDistrict() );
        address.setCity( cityDtoToCity( addressDto.getCity() ) );
        address.setPostalCode( addressDto.getPostalCode() );
        address.setPhone( addressDto.getPhone() );
        address.setLastUpdate( addressDto.getLastUpdate() );
        address.setLocation( addressDto.getLocation() );

        return address;
    }

    @Override
    public AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setAddress( address.getAddress() );
        addressDto.setAddress2( address.getAddress2() );
        addressDto.setDistrict( address.getDistrict() );
        addressDto.setCity( cityToCityDto( address.getCity() ) );
        addressDto.setPostalCode( address.getPostalCode() );
        addressDto.setPhone( address.getPhone() );
        addressDto.setLastUpdate( address.getLastUpdate() );
        addressDto.setLocation( address.getLocation() );

        return addressDto;
    }

    @Override
    public Address updateAddressFromAddressDto(AddressDto addressDto, Address address) {
        if ( addressDto == null ) {
            return address;
        }

        if ( addressDto.getId() != null ) {
            address.setId( addressDto.getId() );
        }
        if ( addressDto.getAddress() != null ) {
            address.setAddress( addressDto.getAddress() );
        }
        if ( addressDto.getAddress2() != null ) {
            address.setAddress2( addressDto.getAddress2() );
        }
        if ( addressDto.getDistrict() != null ) {
            address.setDistrict( addressDto.getDistrict() );
        }
        if ( addressDto.getCity() != null ) {
            if ( address.getCity() == null ) {
                address.setCity( new Address.City() );
            }
            cityDtoToCity1( addressDto.getCity(), address.getCity() );
        }
        if ( addressDto.getPostalCode() != null ) {
            address.setPostalCode( addressDto.getPostalCode() );
        }
        if ( addressDto.getPhone() != null ) {
            address.setPhone( addressDto.getPhone() );
        }
        if ( addressDto.getLastUpdate() != null ) {
            address.setLastUpdate( addressDto.getLastUpdate() );
        }
        if ( addressDto.getLocation() != null ) {
            address.setLocation( addressDto.getLocation() );
        }

        return address;
    }

    protected Address.Country countryDtoToCountry(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        Address.Country country = new Address.Country();

        country.setId( countryDto.getId() );
        country.setCountry( countryDto.getCountry() );
        country.setLastUpdate( countryDto.getLastUpdate() );

        return country;
    }

    protected Address.City cityDtoToCity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        Address.City city = new Address.City();

        city.setId( cityDto.getId() );
        city.setCity( cityDto.getCity() );
        city.setCountry( countryDtoToCountry( cityDto.getCountry() ) );
        city.setLastUpdate( cityDto.getLastUpdate() );

        return city;
    }

    protected CountryDto countryToCountryDto(Address.Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setId( country.getId() );
        countryDto.setCountry( country.getCountry() );
        countryDto.setLastUpdate( country.getLastUpdate() );

        return countryDto;
    }

    protected CityDto cityToCityDto(Address.City city) {
        if ( city == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setId( city.getId() );
        cityDto.setCity( city.getCity() );
        cityDto.setCountry( countryToCountryDto( city.getCountry() ) );
        cityDto.setLastUpdate( city.getLastUpdate() );

        return cityDto;
    }

    protected void countryDtoToCountry1(CountryDto countryDto, Address.Country mappingTarget) {
        if ( countryDto == null ) {
            return;
        }

        mappingTarget.setId( countryDto.getId() );
        mappingTarget.setCountry( countryDto.getCountry() );
        mappingTarget.setLastUpdate( countryDto.getLastUpdate() );
    }

    protected void cityDtoToCity1(CityDto cityDto, Address.City mappingTarget) {
        if ( cityDto == null ) {
            return;
        }

        mappingTarget.setId( cityDto.getId() );
        mappingTarget.setCity( cityDto.getCity() );
        if ( cityDto.getCountry() != null ) {
            if ( mappingTarget.getCountry() == null ) {
                mappingTarget.setCountry( new Address.Country() );
            }
            countryDtoToCountry1( cityDto.getCountry(), mappingTarget.getCountry() );
        }
        else {
            mappingTarget.setCountry( null );
        }
        mappingTarget.setLastUpdate( cityDto.getLastUpdate() );
    }
}
