package cus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ur name
 * @since 2019-09-24
 */

@Data
@Accessors(chain = true)

public class SysDict implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String dictValue;

    private String dictName;

    private String dictType;


}
