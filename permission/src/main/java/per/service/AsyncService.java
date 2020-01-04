package per.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class AsyncService {


    @Async
    public void importEmployee() {


        log.info("异步线程开始");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        log.info("异步线程结束");

    }


}
