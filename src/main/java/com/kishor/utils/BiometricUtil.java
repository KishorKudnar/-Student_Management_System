package com.kishor.utils;

public class BiometricUtil {
    public static boolean matchFingerprint(byte[] storedFingerprint, byte[] scannedFingerprint) {
        return storedFingerprint != null && scannedFingerprint != null &&
               java.util.Arrays.equals(storedFingerprint, scannedFingerprint);
    }

    public static byte[] captureFingerprint() {
        return new byte[]{1, 2, 3, 4, 5}; // Simulated fingerprint data
    }
}
