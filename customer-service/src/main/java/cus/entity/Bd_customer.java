package cus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ur name
 * @since 2019-09-23
 */
@Data
@Accessors(chain = true)
public class Bd_customer implements Serializable {

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



}
