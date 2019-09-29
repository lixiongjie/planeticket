package cus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ur name
 * @since 2019-09-29
 */

@Data
public class BdCustomer implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    private String empname;

    private String empcode;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String creator;

    private String updator;

    private Integer deleted;

    private Integer sex;


}
