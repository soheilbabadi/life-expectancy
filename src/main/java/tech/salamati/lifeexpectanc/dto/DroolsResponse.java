package tech.salamati.lifeexpectanc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroolsResponse implements Serializable {
    private boolean valid=true;
    private List<String> resultMessage=new ArrayList<>();

    public void addMesage(String message) {
        if(this.resultMessage.isEmpty()){
            this.resultMessage=new ArrayList<>();
        }
        this.resultMessage.add(message);
    }

}
