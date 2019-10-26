package per.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import comm.ret.Result;
import comm.ret.RetResponse;
import dto.DeptLevelDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.entity.SysDept;
import per.param.DeptParam;
import per.service.SysDeptServiceImpl;
import per.service.SysTreeService;
import per.utils.LevelUtil;

import javax.validation.Valid;
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
    SysDeptServiceImpl sysDeptService;


    @Autowired
    SysTreeService sysTreeService;


    @GetMapping(value = "/save.json")
    public Result<Object> saveDept(@Valid DeptParam param) {


        sysDeptService.getBaseMapper().selectCount(new QueryWrapper<SysDept>()
                .eq("parentId", param.getParentId())
                .eq("name", param.getName())
        );


        SysDept dept = new SysDept();
        BeanUtils.copyProperties(param,dept);

        dept.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()) );

        return RetResponse.makeOKRsp(sysDeptService.save(dept));

    }


    private String getLevel(Integer deptId){

        SysDept dept = sysDeptService.getById(deptId);

        if(dept == null){
            return null;
        }

        return dept.getLevel();

    }





    @GetMapping(value = "/tree.json")
    public Result<Object> tree() {
        List<DeptLevelDto> list = sysTreeService.deptTree();
        return RetResponse.makeOKRsp(list);


    }



}

