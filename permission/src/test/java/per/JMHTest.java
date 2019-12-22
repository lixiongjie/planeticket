package per;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import per.service.SysUserService;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class JMHTest {


    private ConfigurableApplicationContext context;

    private SysUserService sysUserService;

    public static void main(String[] args) throws RunnerException {

        Options options = new OptionsBuilder().
                include(JMHTest.class.getName() + ".test1")
                //.warmupIterations(5).measurementIterations(3).forks(1)
                .build();



//        Options options = new OptionsBuilder().include(JMHTest.class.getName() + ".*")
//                                .build();
        new Runner(options).run();
    }

    /**
     * setup初始化容器的时候只执行一次
     */
    @Setup(Level.Trial)
    public void init() {
        context = SpringApplication.run(PermissionApplication.class);
        sysUserService = context.getBean(SysUserService.class);
    }

    /**
     * benchmark执行多次，此注解代表触发我们所要进行基准测试的方法
     */
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 1)
    @Measurement(iterations = 3,time = 3,timeUnit = TimeUnit.SECONDS)
    @Threads(1)
    @Fork(1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void test() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // ignore
        }
        //sysUserService.getPageByDeptId(new SysUserPage());
        System.out.print("s! ");


    }


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Warmup(iterations = 1)
    @Measurement(iterations = 3)
    @Threads(1)
    @Fork(1)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void test1() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // ignore
        }
        //sysUserService.getPageByDeptId(new SysUserPage());
        System.out.print("s! ");


    }



    @TearDown
    public void shutdown() {
        SpringApplication.exit(context, () -> 20);
    }


}
