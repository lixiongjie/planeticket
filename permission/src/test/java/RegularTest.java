import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import per.utils.Aaa;
import per.utils.ValidUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by maple on 2018-07-01.
 */
@Slf4j
public class RegularTest {


    @Test
    public void _22() {


//        Preconditions.checkNotNull(null, "待删除的部门不存在，无法删除");

        Collections.synchronizedList(new ArrayList<>(10000));


        List<Integer> list1 = Collections.synchronizedList(new ArrayList<>(10000));
        ;
        List<Integer> list2 = Collections.synchronizedList(new ArrayList<>(10000));
        ;
        List<Integer> list3 = new ArrayList<>(10000);


        IntStream.range(0, 1000000).forEach(list1::add);

        IntStream.range(0, 1000000).parallel().forEach(list2::add);


        System.out.println("串行执行的大小：" + list1.size());
        System.out.println("并行执行的大小：" + list2.size());


        long start = System.currentTimeMillis();


        int i = 0;
        list2.parallelStream().forEach(e -> {

//            System.out.print(e);

        });


        System.out.println();

        long end = System.currentTimeMillis();

        System.out.println("doParallelStream cost:" + (end - start));


        long start1 = System.currentTimeMillis();


        list1.stream().forEach(e -> {

//            System.out.print(e);

        });

        long end2 = System.currentTimeMillis();


        System.out.println();


        System.out.println("stream cost:" + (end2 - start1));


    }


    @Test
    public void _33() {

        Aaa o = ValidUtil.email(Aaa.class, new ArrayList<>());


    }


}