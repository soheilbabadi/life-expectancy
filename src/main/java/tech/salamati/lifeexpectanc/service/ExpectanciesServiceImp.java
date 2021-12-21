package tech.salamati.lifeexpectanc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.salamati.lifeexpectanc.dto.AnonymousRequestDto;
import tech.salamati.lifeexpectanc.dto.AnonymousResponseDto;
import tech.salamati.lifeexpectanc.exception.RequestNotMacheException;
import tech.salamati.lifeexpectanc.model.Expectance;
import tech.salamati.lifeexpectanc.repo.ExpectanceRepo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ExpectanciesServiceImp implements ExpectanciesService {

    @Autowired
    private ExpectanceRepo _expectancyServiceImp;


    @Override
    public AnonymousResponseDto anonymousResponse(AnonymousRequestDto dto) throws RequestNotMacheException {
        var result = new Expectance();
        int age = getAge(dto.getBirthDate());
        if (dto.getDailySmoking() >= 5) {
            result = _expectancyServiceImp.findByAgeAndSex(age + 10, dto.getSex())
                    .orElseThrow(() -> new RequestNotMacheException("مشخصات وارده صحیح نیست"));
        } else {
            result = _expectancyServiceImp.findByAgeAndSex(age, dto.getSex())
                    .orElseThrow(() -> new RequestNotMacheException("مشخصات وارده صحیح نیست"));
        }
        AnonymousResponseDto responseDto = new AnonymousResponseDto();

        BeanUtils.copyProperties(result, responseDto);

        //if age changed for smoking or over weight
        responseDto.setAge(getAge(dto.getBirthDate()));
        return responseDto;
    }

    @Override
    public double getBmi(AnonymousRequestDto dto) {
        double metricHeight = dto.getHeight() / 100.0;
        return dto.getWeight() / Math.pow(metricHeight, 2);
    }

    @Override
    public String getOverweight(AnonymousRequestDto dto) {

        int age = getAge(dto.getBirthDate());
        double ghad = dto.getHeight() * 100;
        double normalBMI = 22;

        if (age < 34 && age > 25) {
            normalBMI = 23;
        } else if (age > 35 && age < 44) {
            normalBMI = 24;
        } else if (age > 45 && age < 54) {
            normalBMI = 26;
        } else if (age > 55 && age < 64) {
            normalBMI = 27;
        } else if (age >= 65) {
            normalBMI = 28;
        }

        double normalWeight = normalBMI * (ghad * ghad);
        var overWeight = dto.getWeight() - normalWeight;

        if (overWeight > 3) {
            return overWeight + " اضافه وزن ";
        }
        if (overWeight < 4) {
            return overWeight + " کمبود وزن ";
        }
        return "وزن نرمال";
    }

    public int getAge(LocalDate date) {
        return Math.abs((int) ChronoUnit.YEARS.between(LocalDate.now(), date));
    }
}