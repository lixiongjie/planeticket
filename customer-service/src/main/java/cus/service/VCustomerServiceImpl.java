package cus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cus.entity.VCustomer;
import cus.mapper.VCustomerMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author ur name
 * @since 2019-09-29
 */
@Service
public class VCustomerServiceImpl extends ServiceImpl<VCustomerMapper, VCustomer> implements IService<VCustomer> {

}
