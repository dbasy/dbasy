package com.cmx.dbasy.redispratice.tool;


import java.util.zip.CRC32;

/**
 * @Author: wh
 * @Date: 2021/8/9 17:59
 */
public class CRC {

    public static long Crc32(String str) {
        if (str == null && "".equals(str))
            return 0L;
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }
}
