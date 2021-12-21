package tech.salamati.lifeexpectanc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.salamati.lifeexpectanc.dto.AnonymousRequestDto;
import tech.salamati.lifeexpectanc.helper.ApiResultImp;
import tech.salamati.lifeexpectanc.service.ExpectanciesService;

@RestController
@RequestMapping(path = "/api/expectancy", name = "life ExpectancyController anonymous")
public class ExpectedController {

    private final ExpectanciesService _expectanciesService;
    private final ApiResultImp _apiResult = new ApiResultImp();

    public ExpectedController(ExpectanciesService expectanciesService1) {
        _expectanciesService = expectanciesService1;
    }

    @PostMapping(path = "/", name = "inquery health status")
    public ApiResultImp inquery(@RequestBody AnonymousRequestDto dto) {
        try {
            _apiResult.saved();
            _apiResult.setData(_expectanciesService.anonymousResponse(dto));
        } catch (Exception exception) {
            _apiResult.fatalError(exception);
        }
        return _apiResult;
    }


}
