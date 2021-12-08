package tech.salamati.lifeexpectanc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnonymousRequestDto implements Serializable {
    private LocalDate birthDate;
    private String sex;

}
