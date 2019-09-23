package comm.ret;

public class RetResponse {

    private final static String SUCCESS = "success";

    public static <T> Result<T> makeOKRsp() {
        return new Result<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> Result<T> makeOKRsp(T data) {
        return new Result<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> Result<T> makeErrRsp(String message) {
        return new Result<T>().setCode(RetCode.FAIL).setMsg(SUCCESS);
    }

    public static <T> Result<T> makeRsp(int code, String msg) {
        return new Result<T>().setCode(code).setMsg(msg);
    }

    public static <T> Result<T> makeRsp(int code, String msg, T data) {
        return new Result<T>().setCode(code).setMsg(msg).setData(data);
    }
}
