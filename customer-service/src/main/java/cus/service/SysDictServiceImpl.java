package cus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cus.entity.SysDict;
import cus.mapper.SysDictMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ur name
 * @since 2019-09-24
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements IService<SysDict> {

}
