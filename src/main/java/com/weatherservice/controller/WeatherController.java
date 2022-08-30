package com.weatherservice.controller;

import com.weatherservice.dto.WeatherDto;
import com.weatherservice.entity.Weather;
import com.weatherservice.error.WebResourceWeatherGettingException;
import com.weatherservice.mapper.Mapper;
import com.weatherservice.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    private final Mapper<Weather, WeatherDto> mapper;

    @GetMapping
    public WeatherDto getCurrentWeather() throws IOException, WebResourceWeatherGettingException {
        Optional<Weather> weatherOptional = weatherService.getCurrentWeather();

        if (weatherOptional.isPresent()) {
            Weather weather = weatherOptional.get();

            return mapper.toDto(weather);
        }

        throw new WebResourceWeatherGettingException();
    }

    @GetMapping("/history")
    public List<Weather> getWeatherHistory(){
        return weatherService.getWeatherHistory();
    }

}
