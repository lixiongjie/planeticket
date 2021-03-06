package cus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cus.entity.BdCustomer;
import cus.mapper.Bd_customerMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ur name
 * @since 2019-09-23
 */
@Service
public class Bd_customerServiceImpl extends ServiceImpl<Bd_customerMapper, BdCustomer> implements IService<BdCustomer> {

}
