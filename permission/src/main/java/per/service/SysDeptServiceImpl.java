package per.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.entity.SysDept;
import per.mapper.SysDeptMapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiongjie.li
 * @since 2019-10-26
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements IService<SysDept> {

}
