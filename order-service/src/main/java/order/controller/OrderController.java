package order.controller;

import comm.ret.Result;
import comm.ret.RetResponse;
import cus.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

//    @Autowired
//    private UserFeignClient userFeignClient;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<Object> query(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {


//        Result r = userFeignClient.findById(Long.valueOf("1"));

//        return RetResponse.makeOKRsp(r);

        return null;
    }


    @GetMapping("/salary/{id}")
    public Result<Object> testPathVariable(@PathVariable("id") Integer id) {

        System.out.println("rec"+id);

        return RetResponse.makeOKRsp(id);
    }




}