package per.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import per.exception.ParamException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.entity.SysDept;
import per.mapper.SysDeptMapper;
import per.param.DeptParam;
import per.utils.LevelUtil;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiongjie.li
 * @since 2019-10-26
 */
@Service
public class SysDeptService extends ServiceImpl<SysDeptMapper, SysDept> implements IService<SysDept> {



    public final static String sdsxtmc = "同一层级下存在相同名称的部门";



    public void update(DeptParam param) {


        Assert.state(getBaseMapper().countByNameAndParentId(param.getParentId(), param.getName(), param.getId()) < 1,
                sdsxtmc);


        SysDept before = this.getById(param.getId());
        Preconditions.checkNotNull(before, "待更新的部门不存在");
        if(checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的部门");
        }

        SysDept after =new SysDept();
        after.setId(param.getId());
        after.setName(param.getName());
        after.setParentId(param.getParentId());
        after.setSeq(param.getSeq());
        after.setRemark(param.getRemark());


        after.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()));


        updateWithChild(before, after);
    }



    @Transactional
    public void updateWithChild(SysDept before, SysDept after) {
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if (!after.getLevel().equals(before.getLevel())) {


            List<SysDept> deptList = list(new QueryWrapper<SysDept>().lambda().
                    likeRight(SysDept::getLevel,before.getLevel()));


            if (CollectionUtils.isNotEmpty(deptList)) {
                for (SysDept dept : deptList) {
                    String level = dept.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dept.setLevel(level);
                    }
                }
                this.saveOrUpdateBatch(deptList);


            }
        }


        this.updateById(after);
    }




    public boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        return getBaseMapper().countByNameAndParentId(parentId, deptName, deptId) > 0;
    }

    private String getLevel(Integer deptId) {
        SysDept dept = this.getById(deptId);
        if (dept == null) {
            return null;
        }
        return dept.getLevel();
    }


    public boolean saveDept(DeptParam param) {

        Assert.state(getBaseMapper().countByNameAndParentId(param.getParentId(), param.getName(), param.getId()) < 1,
                sdsxtmc);


        SysDept dept = new SysDept();
        BeanUtils.copyProperties(param,dept);


        dept.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()),param.getParentId()) );

        dept.setOperateTime(LocalDateTime.now());

        return save(dept);


    }
}
