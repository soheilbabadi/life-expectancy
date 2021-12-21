package tech.salamati.lifeexpectanc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnonymousRequestDto implements Serializable {
    private LocalDate birthDate;
    private LocalDate virtualBirthDate;
    private String sex;

    @Range(min = 0, max = 40, message = "مقدار سیگار روزانه عدد درستی نیست")
    private int dailySmoking;
    @Range(min = 3, max = 200, message = "وزن مقدار درستی نیست")
    private int weight;
    @Range(min = 50, max = 250, message = "قد مقدار درستی نیست")
    private int height;

}
