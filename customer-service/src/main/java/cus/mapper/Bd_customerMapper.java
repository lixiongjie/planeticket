package cus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cus.entity.BdCustomer;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ur name
 * @since 2019-09-23
 */
public interface Bd_customerMapper extends BaseMapper<BdCustomer> {



    @Select(
            ""
    )
    public void test();



}
