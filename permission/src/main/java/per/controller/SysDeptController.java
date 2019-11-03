package per.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import comm.ret.Result;
import comm.ret.RetResponse;
import org.springframework.util.Assert;
import per.dto.DeptLevelDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import per.entity.SysDept;
import per.param.DeptParam;
import per.service.SysDeptService;
import per.service.SysTreeService;
import per.utils.LevelUtil;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiongjie.li
 * @since 2019-10-26
 */
@Slf4j
@RestController("/sys/dept")
public class SysDeptController {


    @Autowired
    SysDeptService sysDeptService;


    @Autowired
    SysTreeService sysTreeService;


    @GetMapping(value = "/save.json")
    public Result<Object> saveDept(@Valid DeptParam param) throws Exception {

        return RetResponse.makeOKRsp(sysDeptService.saveDept(param));

    }



    @GetMapping(value = "/tree.json")
    public Result<Object> tree() {
        List<DeptLevelDto> list = sysTreeService.deptTree();
        return RetResponse.makeOKRsp(list);


    }






    @GetMapping(value = "/update.json")
    public Result<Object> updateDept(DeptParam param) {
        sysDeptService.update(param);
        return RetResponse.makeOKRsp();
    }




}

