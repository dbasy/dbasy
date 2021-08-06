package com.cmx.dbasy.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmx.dbasy.sharding.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: wh
 * @Date: 2021/8/5 12:12
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
