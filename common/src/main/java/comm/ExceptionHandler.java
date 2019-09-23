package comm;


import comm.ret.Result;
import comm.ret.RetResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {

        return RetResponse.makeOKRsp();

    }


}
