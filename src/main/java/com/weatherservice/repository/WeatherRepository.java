package com.weatherservice.repository;

import com.weatherservice.entity.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Хранилище истории запросов погоды
 */
public interface WeatherRepository extends MongoRepository<Weather, String> {
}
