package top.boking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;

/**
 * @Author shxl
 * @Date 2025/6/6 22:58
 * @Version 1.0
 */
@RestController
public class TestController {

    @PostMapping("/upload")
    public String uplaod(@RequestPart("file") MultipartFile file) throws IOException {
        // trouble maker
        byte[] bytes = file.getBytes();
        BufferPoolMXBean directBufferPool = ManagementFactory
                .getPlatformMXBeans(BufferPoolMXBean.class)
                .stream()
                .filter(b -> b.getName().equals("direct"))
                .findFirst()
                .orElse(null);
        System.out.println("directBufferPool = " + directBufferPool);

        if (directBufferPool != null) {
            return String.format("DirectBuffer memoryUsed=%dMB%n",
                    directBufferPool.getMemoryUsed() / 1024 / 1024);
        }
        return "DirectBuffer: not found";
    }

}
