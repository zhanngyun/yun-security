package yun.security.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author yzhang
 * @date 2018/3/4 22:08
 * @desc 异步请求
 */
@RestController
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);


    @Autowired
    private DeferredResultHolder deferredResultHolder;


    @Autowired
    private yun.security.async.MockQueue mockQueue;

    @RequestMapping(value = "/order")
    public DeferredResult<String> order() throws Exception{
        logger.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);








        /*Callable<String> result = new Callable() {
            @Override
            public Object call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程返回");
                return "success";

            }
        };*/

        logger.info("主线程返回");
        return result;
    }


}
