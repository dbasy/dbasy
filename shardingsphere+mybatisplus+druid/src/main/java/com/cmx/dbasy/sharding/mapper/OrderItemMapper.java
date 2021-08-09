package com.cmx.dbasy.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmx.dbasy.sharding.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wh
 * @Date: 2021/8/6 16:12
 */
@Mapper
@Repository
public interface OrderItemMapper extends BaseMapper<OrderItem> {
     List<OrderItem> selectOrderAndItem(Long... ids);
}
