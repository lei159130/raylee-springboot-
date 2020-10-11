package com.lee1314.raylee.modules.upload.service;

import java.io.File;
import java.io.InputStream;

/**
 * 文件操作
 */
public interface FileOpeService {
    /**
     * 创建文件夹
     *
     * @param file
     * @return
     */
    File mdkirs(File file) throws Exception;

    /**
     * 创建文件
     *
     * @param file
     * @return
     */
    File createFile(File file) throws Exception;

    /**
     * 读取文件到内存中
     *
     * @return
     * @throws Exception
     */
    byte[] read(String path) throws Exception;

    /**
     * 写入文件
     *
     * @return
     * @throws Exception
     */
    boolean write(InputStream in, String path) throws Exception;
}
