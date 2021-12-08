package tech.salamati.lifeexpectanc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BloodExam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(targetEntity = Person.class)
    private Person personId;
    private float FBS;
    private float MCV;
    private float Plt;
    private float WBC;
    private float HCT;
    private float HGB;
    private float RBC;
    private LocalDateTime registerAt;
    private LocalDate testAt;

}
