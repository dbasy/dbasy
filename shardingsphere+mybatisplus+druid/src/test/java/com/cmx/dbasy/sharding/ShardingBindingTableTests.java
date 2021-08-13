package com.cmx.dbasy.sharding;

import com.cmx.dbasy.sharding.entity.Order;
import com.cmx.dbasy.sharding.entity.OrderItem;
import com.cmx.dbasy.sharding.service.OrderItemService;
import com.cmx.dbasy.sharding.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author: wh
 * @Date: 2021/8/6 16:17
 */
@SpringBootTest
public class ShardingBindingTableTests {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    /*模拟10个用户*/
    private Long[] userIds = new Long[]{0L, 1L, 2L, 3L, 4L, 5L, 7L, 8L, 9L};

    @Test
    public void testInsertBindingTable() {
        /*从10个用户中随机取出一位用户,每次生产一个订单，两行明细。共生成10单*/
        for (int i = 1; i <= 10; i++) {
            Long userId = userIds[new Random().nextInt(9)];
            Order order = new Order();
            order.setUserId(userId);
            order.setOrderName("orderName" + i);
            order.setInsertDate(new Date());
            orderService.save(order);

            OrderItem orderItem1 = new OrderItem();
            orderItem1.setUserId(userId);
            orderItem1.setOrderId(order.getId());
            orderItem1.setInsertDate(new Date());
            orderItem1.setItemName("orderName" + i);

            OrderItem orderItem2 = new OrderItem();
            orderItem2.setUserId(userId);
            orderItem2.setOrderId(order.getId());
            orderItem2.setInsertDate(new Date());
            orderItem2.setItemName("orderName" + i);
            orderItemService.saveBatch(Arrays.asList(orderItem1, orderItem2));

        }
    }

    @Test
    public void testBindingTableJoin() {
        //模拟查询2个用户，在不同数据节点查询
        orderItemService.selectOrderAndItem(new Long[]{1425019288586063874L, 1425019291392053250L});

    }
}
