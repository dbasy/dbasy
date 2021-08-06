package com.cmx.dbasy.sharding;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmx.dbasy.sharding.entity.Order;
import com.cmx.dbasy.sharding.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: wh
 * @Date: 2021/8/5 23:36
 */
@SpringBootTest
public class ShadingQueryTests {
    @Autowired(required = false)
    private OrderMapper orderMapper;

    @Test
    public void testQueryById() {
        orderMapper.selectById(1423300097134886914L);
    }

    @Test
    public void testQueryByUserIdAndId() {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<Order>();
        queryWrapper.eq(Order::getUserId, 2).eq(Order::getId, 1423300097134886914L);
        orderMapper.selectOne(queryWrapper);
    }

    @Test
    public void testAllRouter() {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<Order>();
        queryWrapper.eq(Order::getOrderName, "orderName4");
        orderMapper.selectOne(queryWrapper);
    }

    @Test
    public void testPage() {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<Order>();
        queryWrapper.orderByDesc(Order::getInsertDate);
        IPage<Order> orderIPage = orderMapper.selectPage(new Page<Order>(1,10), queryWrapper);
        System.out.println(orderIPage.getRecords().size());
    }

}
