package com.cmx.dbasy.sharding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmx.dbasy.sharding.entity.OrderItem;
import com.cmx.dbasy.sharding.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wh
 * @Date: 2021/8/6 16:13
 */
@Service
public class OrderItemService extends ServiceImpl<OrderItemMapper, OrderItem> implements IService<OrderItem> {
    @Autowired
    OrderItemMapper orderItemMapper;

    public List<OrderItem> selectOrderAndItem(Long[] ids) {
        return orderItemMapper.selectOrderAndItem(ids);
    }

}
