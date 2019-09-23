package cus.controller;

import comm.ret.Result;
import comm.ret.RetResponse;
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


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Result<Object> query(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {

        System.out.println(username);
        List users = new ArrayList<>();
        users.add(new HashMap<String, String>() {{
            put("name", "aaa");
        }});
        users.add(new HashMap<String, String>() {{
            put("name", "bbb");
        }});
        users.add(new HashMap<String, String>() {{
            put("name", "ccc");
        }});
        return RetResponse.makeOKRsp(users);
    }



    @GetMapping("/users/{id}")
    public Result<Object> testPathVariable(@PathVariable("id") Integer id) {
        return RetResponse.makeOKRsp(id);
    }




    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<Object> list(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {


        Result r = salaryFeignClient.findById(Long.valueOf("1"));

        return RetResponse.makeOKRsp(r);


    }




}