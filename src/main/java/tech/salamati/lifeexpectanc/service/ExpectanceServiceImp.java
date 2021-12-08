package tech.salamati.lifeexpectanc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.salamati.lifeexpectanc.dto.AnonymousRequestDto;
import tech.salamati.lifeexpectanc.dto.AnonymousResponseDto;
import tech.salamati.lifeexpectanc.repo.ExpectanceRepo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ExpectanceServiceImp implements ExpectanceService {


    private final ExpectanceRepo _expectanceRepo;


    public ExpectanceServiceImp(ExpectanceRepo expectanceRepo) {
        _expectanceRepo = expectanceRepo;
    }

    @Override
    public AnonymousResponseDto anonymousResponse(AnonymousRequestDto dto){
        int age=Math.abs ((int)ChronoUnit.YEARS.between(LocalDate.now(),dto.getBirthDate()));
        var result=_expectanceRepo.findByAgeAndSex(age,dto.getSex()).get();
        AnonymousResponseDto responseDto=new AnonymousResponseDto();
        BeanUtils.copyProperties(result,responseDto);
        return responseDto;
    }



}
