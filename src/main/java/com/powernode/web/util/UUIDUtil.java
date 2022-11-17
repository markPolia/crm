package com.powernode.web.util;

import java.util.UUID;

public class UUIDUtil {
    private UUIDUtil() {}

    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
