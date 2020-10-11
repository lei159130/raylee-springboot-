package com.lee1314.raylee.modules.upload.service.impl;

import com.lee1314.raylee.modules.upload.service.FileOpeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.Buffer;

@Slf4j
@Service
public class FileOpeServiceImpl implements FileOpeService {

    @Override
    public File mdkirs(File file) throws Exception {
        if (file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                throw new Exception("文件目录创建失败");
            }
        }
        return file;
    }

    @Override
    public File createFile(File file) throws Exception {
        if (!mdkirs(file).exists()) {
            throw new Exception("文件已存在");
        }
        if (!file.createNewFile()) {
            throw new Exception("文件创建失败");
        }
        return file;
    }

    @Override
    public byte[] read(String path) throws Exception {
        InputStream in = null;
        try {
            in = new FileInputStream(new File(path));
            int count = 0;
            while (count == 0) {
                count = in.available();
            }
            return new byte[in.available()];
        } catch (Exception e) {
            log.error("文件读取失败");
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    @Override
    public boolean write(InputStream in, String path) throws Exception {
        OutputStream out = null;
        try {
            File file = new File(path);
            out = new FileOutputStream(createFile(file));
            byte[] bytes = new byte[1024];
            while (in.read(bytes) != -1) {
                out.write(bytes);
            }
            out.flush();
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
