package com.assessments.ciphertext;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CipherTextDecoder {
    private final static String cipherText = "SXMgdGhlcmUgYW55dGhpbmcgd3Jvbmcgd2l0aCB0aGUgaW5zdHJ1Y3Rpb24/IElmIHllcywgd2hhdCBpcy9hcmUgdGhleT8=";

    public static void main(String[] args) {
        try {
            var sanitized = cipherText.replaceAll("\\s", "");
            var decoded = new String(Base64.getDecoder().decode(sanitized), StandardCharsets.UTF_8);
            System.out.println("Decoded text: " + decoded);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: The input string is not a valid Base64 encoded string.");
        }
    }
}
