package com.practice.cipher;

// 加密类型，支持这三种DESede,Blowfish,AES

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;


public class CipherFile {

    /**
     * 加密类型，支持这三种DESede,Blowfish,AES
     */
    private static final String ENCRYPT_TYPE = "AES";
    /**
     * 加密秘钥，长度为24字节
     */
    private static final String ENCRYPT_KEY = "mQbJILokBccRHUkS+XBk7A==";

    /**
     * 加密算法
     */
    private static final String DES_EDE = "DESede";

    /**
     * 24位长度私钥，随机生成
     */
    private static final byte[] DES_PRIVATE_KEY = { -69, -117, -64, -37, -23,
            -105, -66, -60, -59, -117, -99, -78, -40, -57, -70, -56, -104, -118,
            -17, -25, -99, -119, -15, -97 };

    /**
     * 加密文件
     * @param srcFileName  要加密的文件
     * @param destFileName 加密后存放的文件名
     */
    public void encryptFile(String srcFileName, String destFileName) {

        CipherInputStream cis = null;
        try (InputStream is = new FileInputStream(srcFileName);
             OutputStream out = new FileOutputStream(destFileName)){
            Cipher cipher2 = getandinitdescipher(Cipher.ENCRYPT_MODE);
            cis = new CipherInputStream(is, cipher2);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
            System.out.println("文件" + srcFileName + "加密完成，加密后的文件是:" + destFileName);
        } catch (Exception e) {
            System.out.println("加密文件" + srcFileName + "出现异常");
            e.printStackTrace();
        } finally {
            try {
                if (cis != null) {cis.close();}
            } catch (IOException ignored) {}
        }
    }

    private Cipher getandinitdescipher(int mode) {
        try {
            // 从原始密匙数据创建DESKeySpec对象
            KeySpec dks = new DESedeKeySpec(DES_PRIVATE_KEY);
            // 创建一个密匙工厂，然后用它把DESedeKeySpec转换成
            // 一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_EDE);
            SecretKey securekey = keyFactory.generateSecret(dks);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(DES_EDE);
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 用密匙初始化Cipher对象
            cipher.init(mode, securekey, sr);
            return cipher;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 解密文件
     * @param srcFileName  要解密的文件
     * @param destFileName 解密后存放的文件名
     */
    public void getandinitdescipher(String srcFileName, String destFileName) {
        CipherOutputStream cos = null;
        try (InputStream is = new FileInputStream(srcFileName);
             OutputStream out = new FileOutputStream(destFileName)){

            Cipher cipher2 = getandinitdescipher(Cipher.DECRYPT_MODE);
            cos = new CipherOutputStream(out, cipher2);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = is.read(buffer)) > 0) {
                cos.write(buffer, 0, r);
            }
            System.out.println("文件" + srcFileName + "解密完成，解密后的文件是:" + destFileName);
        } catch (Exception e) {
            System.out.println("解密文件" + srcFileName + "出现异常");
            e.printStackTrace();
        } finally {
            try {
                if (cos != null) {cos.close();}
            } catch (IOException ignored) {}
        }
    }


    /**
     * 解密文件
     * @param srcFileName  要解密的文件
     * @param destFileName 解密后存放的文件名
     */
    public void myDecryptFile(String srcFileName, String destFileName) {
        CipherInputStream cis = null;
        try (InputStream is = new FileInputStream(srcFileName);
             OutputStream out = new FileOutputStream(destFileName)){

            Cipher cipher2 = getandinitdescipher(Cipher.DECRYPT_MODE);
            cis = new CipherInputStream(is, cipher2);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
            System.out.println("文件" + srcFileName + "解密完成，解密后的文件是:" + destFileName);
        } catch (Exception e) {
            System.out.println("解密文件" + srcFileName + "出现异常");
            e.printStackTrace();
        } finally {
            try {
                if (cis != null) {cis.close();}
            } catch (IOException ignored) {}
        }
    }

    /***
     * 测试加密解密
     * @param args args
     */
    public static void main(String[] args) {
        CipherFile deEncrypt = new CipherFile();
        // 加密
        deEncrypt.encryptFile("C:\\Users\\luoming\\Desktop\\file\\file1.jpg", "C:\\Users\\luoming\\Desktop\\file\\file2.jpg");
        // 解密
        deEncrypt.myDecryptFile("C:\\Users\\luoming\\Desktop\\file\\file2.jpg", "C:\\Users\\luoming\\Desktop\\file\\file3.jpg");
        deEncrypt.myDecryptFile("C:\\Users\\luoming\\Desktop\\file\\file2.jpg", "C:\\Users\\luoming\\Desktop\\file\\file4.jpg");
    }
}
