package com.cmx.dbasy.sharding;


import com.cmx.dbasy.sharding.entity.Order;
import com.cmx.dbasy.sharding.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

/**
 * @Author: wh
 * @Date: 2021/8/5 12:19
 */
@SpringBootTest
public class ShadingMapperTests {
    @Autowired(required = false)
    private OrderMapper orderMapper;
    /*模拟10个用户*/
    private Long[] userIds = new Long[]{0L, 1L, 2L, 3L, 4L, 5L, 7L, 8L, 9L};


    @Test
    public void testInsert() {
        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setUserId(userIds[new Random().nextInt(9)]);
            order.setOrderName("orderName" + i);
            order.setInsertDate(new Date());
            orderMapper.insert(order);

        }
    }
}
