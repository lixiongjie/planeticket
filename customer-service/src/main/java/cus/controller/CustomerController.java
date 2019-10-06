package cus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import comm.ret.Result;
import comm.ret.RetResponse;
import cus.entity.BdCustomer;
import cus.entity.BdCustomerEducation;
import cus.entity.SysDict;
import cus.service.BdCustomerEducationServiceImpl;
import cus.service.Bd_customerServiceImpl;
import cus.service.SysDictServiceImpl;
import cus.service.VCustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import order.feign.OrderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CustomerController {

    @Autowired
    private OrderFeignClient salaryFeignClient;


    @Autowired
    Bd_customerServiceImpl bd_customerService;


    @Autowired
    SysDictServiceImpl sys_dictService;


    @Autowired
    BdCustomerEducationServiceImpl educationService;


    @Autowired
    VCustomerServiceImpl vCustomerService;


    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    @GetMapping(value = "/users")
    public Result<Object> query(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {


        List list = bd_customerService.list(new QueryWrapper<BdCustomer>());

        return RetResponse.makeOKRsp(list);


    }


    @PutMapping(value = "/user")
    public Result<Object> saveuser() {

        BdCustomer c = new BdCustomer();
        c.setEmpcode("ll215817");

        boolean b = bd_customerService.save(c);

        if (b) {
            return RetResponse.makeOKRsp();
        } else {
            return RetResponse.makeErrRsp("");
        }


    }



    @GetMapping("/users/{id}")
    public Result<Object> users(@PathVariable("id") Integer id) {

        return RetResponse.makeOKRsp("customer give u : "+id);

    }




    @GetMapping("/user/{id}")
    public Result<Object> testPathVariable(@PathVariable("id") Integer id) {
//        return RetResponse.makeOKRsp(id);

        Result r = salaryFeignClient.findById(Long.valueOf("1"));

        return RetResponse.makeOKRsp(r);

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


    @GetMapping(value = "/sysdict")
    public Result<Object> list() {


        List l = sys_dictService.list(new QueryWrapper<SysDict>());
        return RetResponse.makeOKRsp(l);


    }


    @PutMapping(value = "/customer")
    public Result<Object> customer(@RequestBody BdCustomer customer) {

        customer.setId(null);
        return RetResponse.makeOKRsp(bd_customerService.save(customer));


    }

    @PutMapping(value = "/education")
    public Result<Object> education(@RequestBody BdCustomerEducation bdCustomerEducationmer) {

        bdCustomerEducationmer.setId(null);
//        try {
//            boolean b = educationService.save(bdCustomerEducationmer);
//
//        } catch (Exception ex) {
//            //ex.printStackTrace();
//            //log.error(ex.getMessage());
//
//            System.out.println("发生异常");
//
//        }
        boolean b = educationService.save(bdCustomerEducationmer);

        return RetResponse.makeOKRsp("出错了");


    }


    @GetMapping(value = "/allcustomer")
    public Result<Object> allcustomer() {

        return RetResponse.makeOKRsp(vCustomerService.list());

    }


    @DeleteMapping(value = "/allcustomer")
    public Result<Object> deleteallcustomer() {

        boolean b = bd_customerService.remove(new QueryWrapper<BdCustomer>());

        return RetResponse.makeOKRsp(b);

    }


//    @PutMapping(value = "/customer")
//    public Result<Object> customer(@RequestBody @Valid CustomerVO vo, BindingResult bindingResult) {

//        拿basemap的方法
//        bd_customerService.getBaseMapper().test();


//        if (bindingResult.hasErrors()) {
//
//            bindingResult.getAllErrors().forEach(e -> {
//
//                log.error(e.getDefaultMessage());
//
//            });
//
//        }
//
//        return RetResponse.makeOKRsp(vo);
//
//    }


}