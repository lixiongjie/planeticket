package per.controller;

import com.google.common.collect.Maps;
import comm.ret.Result;
import comm.ret.RetResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import per.param.UserParam;
import per.service.SysTreeService;
import per.service.SysUserService;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysTreeService sysTreeService;

    @RequestMapping("/noAuth.page")
    public ModelAndView noAuth() {
        return new ModelAndView("noAuth");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public Result<Object> saveUser(UserParam param) {
        sysUserService.save(param);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public Result<Object> updateUser(UserParam param) {
        sysUserService.update(param);
        return RetResponse.makeOKRsp();
    }




}
