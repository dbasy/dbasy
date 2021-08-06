package com.cmx.dbasy.sharding;

import com.cmx.dbasy.sharding.entity.Order;
import com.cmx.dbasy.sharding.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author: wh
 * @Date: 2021/8/6 01:05
 */
@SpringBootTest
public class ShardingTransactionTests {
    @Autowired(required = false)
    private OrderService orderService;

    @Test
    public void testTransaction() {
        Order order = new Order();
        order.setUserId(0L);
        order.setOrderName("test");
        order.setInsertDate(new Date());
        order.setId(1000L);
        //第二条数据故意使用重复主键，会导致插入失败
        Order order2 = new Order();
        order2.setUserId(1L);
        order2.setOrderName("test");
        order2.setInsertDate(new Date());
        order2.setId(1423300097206190082L);

        orderService.insertBoth(order, order2);


    }
}
