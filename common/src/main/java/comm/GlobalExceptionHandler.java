package comm;


import comm.ret.Result;
import comm.ret.RetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {

        log.error("global exception : "+e.getMessage());
        return RetResponse.makeOKRsp(e.getMessage());

    }


}
