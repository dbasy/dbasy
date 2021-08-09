package com.cmx.dbasy.sharding;

import com.cmx.dbasy.sharding.entity.Dict;
import com.cmx.dbasy.sharding.mapper.DictMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author: wh
 * @Date: 2021/8/9 14:29
 */
@SpringBootTest
public class ShardingBroadcastTests {
    @Autowired
    private DictMapper dictMapper;

    @Test
    public void insertDict() {

        Dict dict = new Dict().setDictName("first dict").setInsertDate(new Date());
        dictMapper.insert(dict);

    }


    @Test
    public void selectDict() {


        dictMapper.selectById(1L);

    }


}
