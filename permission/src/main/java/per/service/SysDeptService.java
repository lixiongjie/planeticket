package per.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import per.exception.ParamException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.entity.SysDept;
import per.mapper.SysDeptMapper;
import per.param.DeptParam;
import per.utils.LevelUtil;
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




    public void update(DeptParam param) {

        if(checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的部门");
        }
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




    private boolean checkExist(Integer parentId, String deptName, Integer deptId) {


        QueryWrapper qw = new QueryWrapper<SysDept>()
                .eq("parent_id",parentId)
                .eq("name",deptName);

        if(deptId!=null) {
            qw.ne("id", deptId);
        }


        return this.count(qw)>0;

    }

    private String getLevel(Integer deptId) {
        SysDept dept = this.getById(deptId);
        if (dept == null) {
            return null;
        }
        return dept.getLevel();
    }



}
