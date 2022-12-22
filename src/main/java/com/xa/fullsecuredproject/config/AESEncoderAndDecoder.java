package com.xa.fullsecuredproject.config;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class AESEncoderAndDecoder {
    
    
	private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "SkylineTech full secured project".getBytes();
    public static final Key key = new SecretKeySpec(keyValue, ALGORITHM);



    public static String encrypt(String valueToEnc, Key key) throws Exception {
    	 

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
  
        byte[] encValue = cipher.doFinal(valueToEnc.getBytes());
        byte[] encryptedByteValue = new Base64().encode(encValue);
        System.out.println("Encrypted Value :: " + new String(encryptedByteValue));
  
        return new String(encryptedByteValue);
    }


    public static String decrypt(String encryptedValue, Key key) throws Exception {


         Cipher cipher = Cipher.getInstance(ALGORITHM);
         cipher.init(Cipher.DECRYPT_MODE, key);
          
         byte[] decodedBytes = new Base64().decode(encryptedValue.getBytes());
  
         byte[] enctVal = cipher.doFinal(decodedBytes);
         
         System.out.println("Decrypted Value :: " + new String(enctVal));
         return new String(enctVal);
     }


}
