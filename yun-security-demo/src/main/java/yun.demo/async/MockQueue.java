package yun.demo.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yzhang
 * @date 2018/3/4 22:40
 * @desc 模拟消息队列
 */
@Component
public class MockQueue {

    private static final Logger logger = LoggerFactory.getLogger(MockQueue.class);
    private String placeOrder;

    private String completeOrder;


    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws Exception{
        new Thread(()->{
            logger.info("收到下单请求"+placeOrder);
            try {
                Thread.sleep(1000);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求完毕"+placeOrder);
        }).start();

    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
