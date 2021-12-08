package tech.salamati.lifeexpectanc.service;

import tech.salamati.lifeexpectanc.dto.AnonymousRequestDto;
import tech.salamati.lifeexpectanc.dto.AnonymousResponseDto;

public interface ExpectanceService {
    AnonymousResponseDto anonymousResponse(AnonymousRequestDto dto);
}
