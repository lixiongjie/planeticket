package cus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import comm.ret.Result;
import comm.ret.RetResponse;
import cus.entity.BdCustomerEducation;
import cus.entity.Bd_customer;
import cus.entity.SysDict;
import cus.service.BdCustomerEducationServiceImpl;
import cus.service.Bd_customerServiceImpl;
import cus.service.SysDictServiceImpl;
import cus.vo.CustomerVO;
import lombok.extern.slf4j.Slf4j;
import order.feign.OrderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @GetMapping(value = "/users")
    public Result<Object> query(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {


        List list = bd_customerService.list(new QueryWrapper<Bd_customer>());

        return RetResponse.makeOKRsp(list);


    }


    @PutMapping(value = "/user")
    public Result<Object> saveuser() {

        Bd_customer c = new Bd_customer();
        c.setEmpcode("ll215817");

        boolean b = bd_customerService.save(c);

        if (b) {
            return RetResponse.makeOKRsp();
        } else {
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


    @GetMapping(value = "/sysdict")
    public Result<Object> list() {


        List l = sys_dictService.list(new QueryWrapper<SysDict>());
        return RetResponse.makeOKRsp(l);


    }


    @PutMapping(value = "/customer")
    public Result<Object> customer(@RequestBody Bd_customer customer) {

        customer.setId(null);
        return RetResponse.makeOKRsp(bd_customerService.save(customer));


    }

    @PutMapping(value = "/education")
    public Result<Object> education(@RequestBody BdCustomerEducation bdCustomerEducationmer) {

        bdCustomerEducationmer.setId(null);

        boolean b = false;
        try {
            b = educationService.save(bdCustomerEducationmer);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return RetResponse.makeOKRsp("出错了");


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