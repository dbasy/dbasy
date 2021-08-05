package com.cmx.dbasy.sharding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: wh
 * @Date: 2021/8/5 12:11
 */
@Data
@TableName("t_order")
public class Order {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String orderName;
    private Long userId;
    private Date insertDate;
}
