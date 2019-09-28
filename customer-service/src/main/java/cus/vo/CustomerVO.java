package cus.vo;

import cus.utils.Arrayations;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


@Data
public class CustomerVO {



    @NotNull
    @Length(min = 32)
    private String cuscode;


    @Arrayations(value = {"1","2","3","4"},message = "人员状态必须为{value}之一",required = false,caseSensitive = false)
    private String id;




}
