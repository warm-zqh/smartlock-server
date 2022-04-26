package com.ahead.smartlock.core.execption;

import com.ahead.smartlock.core.execption.code.ExceptionCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zqh
 */
@NoArgsConstructor
public class AheadException extends RuntimeException {

    @Setter
    @Getter
    private ExceptionCode exceptionCode;

    public AheadException(ExceptionCode exceptionCode) {
        super(exceptionCode.getCode() + "-" + exceptionCode.getMsg());
        this.exceptionCode = exceptionCode;
    }

    public Integer getCode() {
        return exceptionCode.getCode();
    }

    public String getMsg() {
        return exceptionCode.getMsg();
    }
}