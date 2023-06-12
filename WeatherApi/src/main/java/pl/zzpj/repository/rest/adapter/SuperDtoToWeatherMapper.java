package pl.zzpj.repository.rest.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.weatherModel.City;
import pl.zzpj.repository.core.domain.model.weatherModel.DataElement;
import pl.zzpj.repository.core.domain.model.weatherModel.Description;
import pl.zzpj.repository.core.domain.model.weatherModel.MainValues;
import pl.zzpj.repository.core.domain.model.weatherModel.Weather;
import pl.zzpj.repository.rest.dto.CityDto;
import pl.zzpj.repository.rest.dto.DesciptionDto;
import pl.zzpj.repository.rest.dto.ListElementDto;
import pl.zzpj.repository.rest.dto.MainValuesDto;
import pl.zzpj.repository.rest.dto.SuperDto;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class SuperDtoToWeatherMapper {
    public Weather convertSuperDtoToWeatherDomainModel(SuperDto dto) {
        return new Weather(dto.message(), dto.cnt(),
            this.convertCityDtoToCityDomainModel(dto.city()),
            this.convertDtoElementListToDomainElementList(dto.list()));
    }

    private City convertCityDtoToCityDomainModel(CityDto dto) {
        return new City(dto.name(), dto.coord().lat(), dto.coord().lon(), dto.country(), dto.population(),
            dto.timezone(), dto.sunrise(), dto.sunset());
    }

    private List<DataElement> convertDtoElementListToDomainElementList(List<ListElementDto> listElementDtos) {
        List<DataElement> returnList = new ArrayList<>();
        for (ListElementDto elementDto : listElementDtos) {
            returnList.add(
                new DataElement(
                    elementDto.dt(),
                    convertMainValuesDtoToDomainMainValues(elementDto.main()),
                    convertDescriptionDtoToDomainDescription(elementDto.weather()),
                    elementDto.wind().speed(),
                    elementDto.wind().deg(),
                    elementDto.wind().gust(),
                    elementDto.visibility(),
                    elementDto.dtTxt()
                )
            );
        }
        return returnList;
    }

    private MainValues convertMainValuesDtoToDomainMainValues(MainValuesDto dto) {
        return new MainValues(
            dto.temp(),
            dto.feelsLike(),
            dto.tempMin(),
            dto.tempMax(),
            dto.pressure(),
            dto.seaLevel(),
            dto.groundLevel(),
            dto.humidity(),
            dto.tempKf()
        );
    }

    private List<Description> convertDescriptionDtoToDomainDescription(List<DesciptionDto> dtoList) {
        List<Description> returnList = new ArrayList<>();
        for (DesciptionDto dto : dtoList) {
            returnList.add(new Description(dto.main(), dto.description()));
        }
        return returnList;
    }
}
