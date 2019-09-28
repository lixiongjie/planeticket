package cus.utils;

import org.apache.commons.lang3.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.HashSet;
import java.util.Set;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {Arrayations.ArrayationsValidator.class}
)//添加校验器
public @interface Arrayations {

    String[] value();

    boolean caseSensitive() default true;

    boolean required() default true;//自增

    String message() default "手机号码格式错误";//出错提示信息

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class ArrayationsValidator implements ConstraintValidator<Arrayations, String> {


        boolean required;

        private Set<String> elements = new HashSet<>();

        private boolean caseSensitive = true;


        @Override
        public void initialize(Arrayations constraintAnnotation) {

            required = constraintAnnotation.required();


            this.caseSensitive = constraintAnnotation.caseSensitive();


            for (String e : constraintAnnotation.value()) {

                this.elements.add(this.caseSensitive ? e : e.toUpperCase());

            }


        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {


            if (required) {


                if (chkNull(value)) {
                    return false;
                } else {

                    return this.elements.contains(this.caseSensitive ? value.toString() : value.toString().toUpperCase());

                }


            } else {


                if (chkNull(value)) {
                    return true;
                } else {

                    return this.elements.contains(this.caseSensitive ? value.toString() : value.toString().toUpperCase());

                }


            }


        }


        private boolean chkNull(String value) {

            return value == null || StringUtils.isEmpty(value);

        }
    }


//    class IsMobileValidator implements ConstraintValidator<Arrayations, Integer> {
//
//
//        boolean required;
//
//        @Override
//        public void initialize(Arrayations constraintAnnotation) {
//            required = constraintAnnotation.required();
//        }
//
//        @Override
//        public boolean isValid(Integer value, ConstraintValidatorContext context) {
//            if (value > 100)
//                return true;
//            else
//                return false;
//
//        }

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
//}
}
