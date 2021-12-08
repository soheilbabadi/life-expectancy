package tech.salamati.lifeexpectanc.helper;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Data
@Component
public class ApiResultImp {

    private Object data;
    private long totalCount;
    private long currentCount;
    private String message;
    private String backendMessage;

    private HttpStatus httpStatus;
    private boolean isSuccess;
    private LocalDateTime dateTime;

    public ApiResultImp() {
        this.data = null;
        this.totalCount = 1;
        this.currentCount = 1;
        this.message = "عملیات با موفقیت انجام شد";
        this.httpStatus = HttpStatus.OK;
        this.isSuccess = true;
        this.dateTime = Utils.getUtc();
    }

    public ApiResultImp saved() {
        this.data = 1;
        this.totalCount = 1;
        this.currentCount = 1;
        this.message = "عملیات با موفقیت انجام شد";
        this.httpStatus = HttpStatus.ACCEPTED;
        this.isSuccess = true;
        this.dateTime = Utils.getUtc();
        return this;
    }

    public ApiResultImp fatalError(Exception ex) {
        log.error(Utils.getUtc() + " : " + ex.getMessage());
        this.data = null;
        this.totalCount = 0;
        this.currentCount = 0;
        this.message = "خطایی در سیستم اتفاق افتاده است";
        this.backendMessage=ex.getMessage();
        this.httpStatus = HttpStatus.EXPECTATION_FAILED;
        this.isSuccess = false;
        this.dateTime = Utils.getUtc();
        return this;
    }

    public ApiResultImp notFound() {
        this.data = null;
        this.totalCount = 0;
        this.currentCount = 0;
        this.message = "اطلاعات درخواستی یافت نشد";
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.isSuccess = false;
        this.dateTime = Utils.getUtc();
        return this;
    }

    public ApiResultImp(Object data, long totalCount, long currentCount, String message, String backendMessage, HttpStatus httpStatus, boolean isSuccess) {
        this.data = data;
        this.totalCount = totalCount;
        this.currentCount = currentCount;
        this.message = message;
        this.backendMessage = backendMessage;
        this.httpStatus = httpStatus;
        this.isSuccess = isSuccess;
        this.dateTime = Utils.getUtc();
    }
}