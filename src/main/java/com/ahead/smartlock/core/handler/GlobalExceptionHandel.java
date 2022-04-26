package com.ahead.smartlock.core.handler;

import com.ahead.smartlock.core.execption.AheadException;
import com.ahead.smartlock.core.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 全局异常
 *
 * @author zqh
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandel {
    /**
     * 业务异常
     *
     * @param request 请求
     * @param e       异常信息
     * @return 错误结果
     */
    @ExceptionHandler(value = AheadException.class)
    public ResponseEntity<?> handlerMoneyException(HttpServletRequest request, AheadException e) {
        return new ResponseEntity<>(Result.fails(e.getCode(), e.getMsg()), HttpStatus.OK);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new ResponseEntity<>(Result.fails("请求方法不支持！"), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<Object> result = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(Result.fails(result.toString()), HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(Result.fails(e.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<?> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(Result.fails("已存在该数据，请检查"), HttpStatus.OK);
    }

    /**
     * 默认异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handlerException(HttpServletRequest request, Exception e) {
        log.error("内部异常: 请求路径{}, 异常信息{}", request.getRequestURL().toString(), e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(Result.fails("服务器内部错误"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
