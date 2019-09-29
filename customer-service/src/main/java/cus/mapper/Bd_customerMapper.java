package cus.mapper;

import cus.entity.Bd_customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ur name
 * @since 2019-09-23
 */
public interface Bd_customerMapper extends BaseMapper<Bd_customer> {



    @Select(
            ""
    )
    public void test();



}
