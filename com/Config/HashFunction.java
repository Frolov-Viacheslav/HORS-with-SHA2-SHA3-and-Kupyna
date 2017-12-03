package com.Config;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.jcajce.provider.digest.SHA512;
import org.bouncycastle.jcajce.provider.digest.SHA256;
import org.bouncycastle.jcajce.provider.digest.DSTU7564;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

public class HashFunction {

    public String Sha3_512H(String input)  {
        SHA3.DigestSHA3 SHA3 = new SHA3.Digest512();
        byte[] digest = SHA3.digest(input.getBytes());

        return Hex.toHexString(digest);
    }
    public String Sha3_512B(String input)  {
        SHA3.DigestSHA3 SHA3 = new SHA3.Digest512();
        byte[] digest = SHA3.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, digest);
        String Bin = bigInt.toString(2);
        while (Bin.length() < 512) {
            Bin = "0" + Bin;
        }
        return Bin;
    }
    public String Sha3_256H(String input)  {
        SHA3.DigestSHA3 SHA3 = new SHA3.Digest256();
        byte[] digest = SHA3.digest(input.getBytes());
        return Hex.toHexString(digest);
    }
    public String Sha3_256B(String input)  {
        SHA3.DigestSHA3 SHA3 = new SHA3.Digest256();
        byte[] digest = SHA3.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, digest);
        String Bin = bigInt.toString(2);
        while (Bin.length() < 256) {
            Bin = "0" + Bin;
        }
        return Bin;
    }
    public String Sha2_512H(String input)  {
        SHA512.Digest SHA512 = new SHA512.Digest();
        byte[] digest = SHA512.digest(input.getBytes());

        return Hex.toHexString(digest);
    }
    public String Sha2_512B(String input)  {
        SHA512.Digest SHA512 = new SHA512.Digest();
        byte[] digest = SHA512.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, digest);
        String Bin = bigInt.toString(2);
        while (Bin.length() < 512) {
            Bin = "0" + Bin;
        }
        return Bin;
    }
    public String Sha2_256H(String input)  {
        SHA256.Digest SHA256 = new SHA256.Digest();
        byte[] digest = SHA256.digest(input.getBytes());

        return Hex.toHexString(digest);
    }
    public String Sha2_256B(String input)  {
        SHA256.Digest SHA256 = new SHA256.Digest();
        byte[] digest = SHA256.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, digest);
        String Bin = bigInt.toString(2);
        while (Bin.length() < 256) {
            Bin = "0" + Bin;
        }
        return Bin;
    }
    public  String DSTU7564_512H(String input)  {
        DSTU7564.DigestDSTU7564 DSTU7564 = new DSTU7564.Digest512();
        byte[] digest = DSTU7564.digest(input.getBytes());

        return Hex.toHexString(digest);
    }
    public  String DSTU7564_512B(String input)  {
        DSTU7564.DigestDSTU7564 DSTU7564 = new DSTU7564.Digest512();
        byte[] digest = DSTU7564.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, digest);
        String Bin = bigInt.toString(2);
        while (Bin.length() < 512) {
            Bin = "0" + Bin;
        }
        return Bin;
    }
    public  String DSTU7564_256H(String input)  {
        DSTU7564.DigestDSTU7564 DSTU7564 = new DSTU7564.Digest256();
        byte[] digest = DSTU7564.digest(input.getBytes());

        return Hex.toHexString(digest);
    }
    public  String DSTU7564_256B(String input)  {
        DSTU7564.DigestDSTU7564 DSTU7564 = new DSTU7564.Digest256();
        byte[] digest = DSTU7564.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, digest);
        String Bin = bigInt.toString(2);
        while (Bin.length() < 256) {
            Bin = "0" + Bin;
        }
        return Bin;
    }
    public String MD5H(String input)  {
        MD5.Digest md5 = new MD5.Digest();
        byte[] digest = md5.digest(input.getBytes());

        return Hex.toHexString(digest);
    }
    public String MD5B(String input)  {
        MD5.Digest md5 = new MD5.Digest();
        byte[] digest = md5.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, digest);
        String Bin = bigInt.toString(2);
        while (Bin.length() < 128) {
            Bin = "0" + Bin;
        }
        return Bin;
    }
}
