package tech.salamati.lifeexpectanc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Expectance implements Serializable {
    @Id
    private int id;
    private int age;
    private double death;
    private long population;
    private double remain;
    private double expectancy;
    private String sex;

}
