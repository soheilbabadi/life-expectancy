package tech.salamati.lifeexpectanc.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnonymousResponseDto implements Serializable {


    private int age;
    private double death;
    private long population;
    private double remain;
    private double expectancy;
    private String sex;
    private double BMI;
    private double overWeight;

}
