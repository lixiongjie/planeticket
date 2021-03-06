import bean.Stu;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by maple on 2018-07-01.
 */
@Slf4j
public class RegularTest {


    @Test
    public void _22(){


        Preconditions.checkNotNull(null, "待删除的部门不存在，无法删除");



    }





    @Test
    public void evaluatesExpression() {

        Long l = IdWorker.getId();
        String s = IdWorker.getIdStr();
        String u = IdWorker.get32UUID();


        System.out.println(l + "::" + String.valueOf(l).length());
        System.out.println(s + "::" + String.valueOf(l).length());
        System.out.println(u + "::" + String.valueOf(u).length());


        assertNotNull(l);
        assertNotNull(u);

    }


    @Test
    public void _1() {


        System.out.println("Hello World!");
        Stu s = new Stu();
        //s.setAge(19);
        System.out.println(s.getAge());
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Stu>> validators = validator.validate(s);
        for (ConstraintViolation<Stu> constraintViolation : validators) {
            System.out.println(constraintViolation.getMessage());
        }
        if (validators.isEmpty()) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }


    }


    @Test
    public void _2() {

        log.info(" a b c ".trim());

        System.out.println(" a b c ".trim());

    }


    @Test
    public void _3(){
//
//        a = public void aaa(String s){
//            System.out.println("1");
//        }

        int i = 10;

        MyLambdaInterface a = (s)->{

            int x  = i+ Integer.valueOf(s);

            //System.out.println(x);

            return x;


        } ;

        a.doSomeShit("1");


    }

    interface MyLambdaInterface{
        int doSomeShit(String s);
    }

}