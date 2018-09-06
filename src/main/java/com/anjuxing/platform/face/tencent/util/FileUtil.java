package com.anjuxing.platform.face.tencent.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author xiongt
 * @Description
 */
public class FileUtil {

    private FileUtil(){}

    public static byte[] getFileBytes(File file) {
        byte[] imgBytes = null;
        try {
            RandomAccessFile f = new RandomAccessFile(file, "r");
            imgBytes = new byte[(int) f.length()];
            f.readFully(imgBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return imgBytes;
    }


}
