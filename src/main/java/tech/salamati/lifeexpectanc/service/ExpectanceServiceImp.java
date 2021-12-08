package tech.salamati.lifeexpectanc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.salamati.lifeexpectanc.dto.AnonymousRequestDto;
import tech.salamati.lifeexpectanc.dto.AnonymousResponseDto;
import tech.salamati.lifeexpectanc.model.Expectance;
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
        Expectance result=new Expectance();
        int age=getAge(dto.getBirthDate());
        if (dto.getDailySmoking()>=5)
        {
            result=_expectanceRepo.findByAgeAndSex(age+10,dto.getSex()).get();
        }
        result=_expectanceRepo.findByAgeAndSex(age,dto.getSex()).get();
        AnonymousResponseDto responseDto=new AnonymousResponseDto();

        BeanUtils.copyProperties(result,responseDto);
        return responseDto;

    }

    @Override
    public double getBmi(AnonymousRequestDto dto) {
        double ghad=dto.getHeight()/100.0;
        return dto.getWeight()/(ghad*ghad);
    }

    @Override
    public String getOverweight(AnonymousRequestDto dto) {

        int age=getAge(dto.getBirthDate());
        double bmi=getBmi(dto);
        double ghad=dto.getHeight()*100;
        double normalBMI=22;
        if (age<34 && age>25){normalBMI=23;}
        if (age<35 && age>44){normalBMI=24;}
        if (age<45 && age>54){normalBMI=25;}
        if (age<45 && age>54){normalBMI=26;}
        if (age<55 && age>64){normalBMI=27;}
        if (age>65){normalBMI=28;}
        double normalWeight=normalBMI*(ghad*ghad);
        var result= dto.getWeight()-normalWeight;

        if (result>1 ){return  result + " اضافه وزن ";}
        if (result<1 ){return  result + " کمبود وزن ";}
        return "وزن نرمال";
    }

    private int getAge(LocalDate date){
        return Math.abs ((int)ChronoUnit.YEARS.between(LocalDate.now(),date));
    }





}
