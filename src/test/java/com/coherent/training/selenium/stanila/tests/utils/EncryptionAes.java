package com.coherent.training.selenium.stanila.tests.utils;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class EncryptionAes {
    private static final String ENCRYPTION_TYPE = "AES";
    private byte[] keyValue;

    public EncryptionAes(String key) {
        keyValue = key.getBytes();
    }

    @SneakyThrows
    public String encrypt(String data) {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ENCRYPTION_TYPE);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrptVal = c.doFinal(data.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encrptVal);
        return encryptedValue;
    }

    @SneakyThrows
    public String decrypt(String encryptedData) {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ENCRYPTION_TYPE);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decrptValue = c.doFinal(decodedValue);
        String decryptedValue = new String(decrptValue);
        return decryptedValue;
    }

    @SneakyThrows
    private Key generateKey() {
        Key key = new SecretKeySpec(keyValue, ENCRYPTION_TYPE);
        return key;
    }
}
