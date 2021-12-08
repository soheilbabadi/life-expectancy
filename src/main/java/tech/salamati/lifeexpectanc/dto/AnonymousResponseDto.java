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
    private int iX;
    private int dx;
    private double qx;
    private String sex;
}
