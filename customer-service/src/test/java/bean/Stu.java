package bean;

import cus.utils.IsMobile;
import lombok.Data;

import javax.validation.constraints.Min;


@Data
public class Stu {


    @IsMobile
    @Min(20)
    private Integer age;




}