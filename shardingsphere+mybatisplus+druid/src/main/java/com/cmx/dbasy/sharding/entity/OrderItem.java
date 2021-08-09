package com.cmx.dbasy.sharding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: wh
 * @Date: 2021/8/6 16:10
 */
@Data
@TableName("t_order_item")
public class OrderItem {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String itemName;
    private Long orderId;
    private Long userId;
    private Date insertDate;
    @TableField(exist = false)
    private String orderName;
}
