package tech.salamati.lifeexpectanc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.salamati.lifeexpectanc.dto.AnonymousRequestDto;
import tech.salamati.lifeexpectanc.helper.ApiResultImp;
import tech.salamati.lifeexpectanc.service.ExpectanceService;

@RestController
@RequestMapping(path = "expectancy",name="life ExpectancyController anonymous")
public class ExpectedController {

    private ApiResultImp _apiResult=new ApiResultImp() ;
    private final ExpectanceService _expectanceService;

    public ExpectedController( ExpectanceService expectanceService1) {
        _expectanceService = expectanceService1;
    }

    @PostMapping(path = "/",name = "inquery health status")
    public ApiResultImp inquery(@RequestBody AnonymousRequestDto dto){
        try {
            _apiResult.saved();
            _apiResult.setData(_expectanceService.anonymousResponse(dto));
        }
        catch (Exception exception){
            _apiResult.fatalError(exception);
        }
            return _apiResult;
    }



}
