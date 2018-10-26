package com.lty.animator.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;


import java.io.File;


/**
 * Created by andyliu on 2018/6/14.
 */

public class DeviceUtil {


    public static long getTotalInternalMemorySize() {
        //获取内部存储根目录
        File path = Environment.getDataDirectory();
        //系统的空间描述类
        StatFs stat = new StatFs(path.getPath());
        //每个区块占字节数
        long blockSize = stat.getBlockSizeLong();
        //区块总数
        long totalBlocks = stat.getBlockCountLong();
        return totalBlocks * blockSize;
    }


    public static long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSizeLong();
        //获取可用区块数量
        long availableBlocks = stat.getAvailableBlocksLong();
        return availableBlocks * blockSize;
    }


    public static String formatFileSize(Context ctx, long men) {
        return Formatter.formatFileSize(ctx.getApplicationContext(), men);
    }

//    public static String formatFileSize(long men) {
//        return Formatter.formatFileSize(, men);
//    }


}
