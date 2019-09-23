package cus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import comm.ret.Result;
import comm.ret.RetResponse;
import cus.entity.Bd_customer;
import cus.service.Bd_customerServiceImpl;
import order.feign.OrderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private OrderFeignClient salaryFeignClient;


    @Autowired
    Bd_customerServiceImpl bd_customerService;


    @GetMapping(value = "/users")
    public Result<Object> query(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {


        List list = bd_customerService.list(new QueryWrapper<Bd_customer>().eq("id", 2));

        return RetResponse.makeOKRsp(list);


    }



    @PutMapping(value = "/user")
    public Result<Object> saveuser() {


        boolean b = bd_customerService.save(new Bd_customer().setEmpcode("ll215817"));

        if (b){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("");
        }






    }


    @GetMapping("/user/{id}")
    public Result<Object> testPathVariable(@PathVariable("id") Integer id) {
        return RetResponse.makeOKRsp(id);
    }

//
//    @RequestMapping(value = "/querylist", method = RequestMethod.GET)
//    public Result<Object> list(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {
//
//
//        Result r = salaryFeignClient.findById(Long.valueOf("1"));
//
//        return RetResponse.makeOKRsp(r);
//
//
//    }


}