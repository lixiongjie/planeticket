package cus.utils;

import org.apache.commons.lang3.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IsMobile.IsMobileValidator.class}
)//添加校验器
public @interface IsMobile {

    boolean required() default true;//自增

    String message() default "手机号码格式错误";//出错提示信息

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    class IsMobileValidator implements ConstraintValidator<IsMobile, Integer> {


        boolean required;

        @Override
        public void initialize(IsMobile constraintAnnotation) {
            required = constraintAnnotation.required();
        }

        @Override
        public boolean isValid(Integer value, ConstraintValidatorContext context) {
            if (value > 100)
                return true;
            else
                return false;

        }

//        @Override
//        public boolean isValid(String value, ConstraintValidatorContext context) {
//            if(required){
//                return value.contains("ad");
//            }else{
//                if(StringUtils.isEmpty(value)){
//                    return true;
//                }else{
//                    return value.contains("ad");
//                }
//            }
//        }
    }
}
