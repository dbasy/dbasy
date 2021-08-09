package com.cmx.dbasy.sharding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmx.dbasy.sharding.entity.Order;
import com.cmx.dbasy.sharding.mapper.OrderMapper;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: wh
 * @Date: 2021/8/6 01:12
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IService<Order> {
    @Autowired(required = false)
    private OrderMapper orderMapper;

    @Transactional
    @ShardingTransactionType(value = TransactionType.XA)
    public void insertBothXA(Order order1, Order order2) {
        orderMapper.insert(order1);
        orderMapper.insert(order2);


    }

    @Transactional
    @ShardingTransactionType(value = TransactionType.BASE)
    public void insertBothBase(Order order1, Order order2) {
        orderMapper.insert(order1);
        orderMapper.insert(order2);

    }


}
