package yun.demo.async;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author yzhang
 * @date 2018/3/4 22:55
 * @desc  队列监听器
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent>{
    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);


    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Autowired
    private MockQueue mockQueue;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        new Thread(() ->{
            while (true){
                if(StringUtils.isNotBlank(mockQueue.getCompleteOrder())){
                    String orderNumber = mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果："+orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                }
            }
        }).start();

    }
}
