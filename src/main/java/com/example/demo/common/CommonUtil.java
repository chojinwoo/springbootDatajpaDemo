package com.example.demo.common;

import org.apache.commons.io.IOUtils;

import javax.crypto.*;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CommonUtil {

    public static String getApiKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            int keyBitSize = 256;
            keyGenerator.init(keyBitSize, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            return DatatypeConverter.printHexBinary(secretKey.getEncoded()).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
