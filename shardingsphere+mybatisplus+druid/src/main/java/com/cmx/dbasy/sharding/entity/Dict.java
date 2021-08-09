package com.cmx.dbasy.sharding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author: wh
 * @Date: 2021/8/9 14:25
 */
@Data
@TableName("t_dict")
@Accessors(chain = true)
public class Dict {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String dictName;
    private Date insertDate;
}
