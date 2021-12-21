package tech.salamati.lifeexpectanc.service;

import tech.salamati.lifeexpectanc.dto.AnonymousRequestDto;
import tech.salamati.lifeexpectanc.dto.AnonymousResponseDto;
import tech.salamati.lifeexpectanc.exception.RequestNotMacheException;

import java.time.LocalDate;

public interface ExpectanceService {
    AnonymousResponseDto anonymousResponse(AnonymousRequestDto dto) throws RequestNotMacheException;
    double getBmi(AnonymousRequestDto dto);
    String getOverweight(AnonymousRequestDto dto);
    int getAge(LocalDate date);
}