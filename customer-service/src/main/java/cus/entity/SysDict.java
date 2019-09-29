package cus.entity;

import lombok.Data;

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
public class SysDict implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer dictValue;

    private String dictName;

    private String dictType;

}
