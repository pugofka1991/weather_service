package com.weatherservice.mapper;

import com.weatherservice.dto.WeatherDto;
import com.weatherservice.entity.Weather;
import org.springframework.stereotype.Component;

@Component
public class WeatherDtoMapper implements Mapper<Weather, WeatherDto> {
    @Override
    public WeatherDto toDto(Weather weather) {
        if (weather == null) {
            return null;
        }

        WeatherDto dto = new WeatherDto();

        dto.setWeatherValue(weather.getWeatherValue());
        dto.setWeatherDate(weather.getWeatherDate());

        return dto;
    }
}
