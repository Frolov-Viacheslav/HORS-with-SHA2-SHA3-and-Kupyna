package com;
import com.Config.*;

public class KeyPairGeneration {
    PRG prg = new PRG();
    HashFunction hash = new HashFunction();

    public static String X = "";
    public static String Y = "";

    public void generatePairKey(Integer t, Integer l, Integer choose, Integer S) {
        String Xi = "";
        String Yi = "";

        for(int i = 1; i <= t; i++){
            Xi = prg.Random128(l);
            X += Xi;
            if(S == 256) {
                if (choose == 1)
                    Yi = hash.Sha2_256H(Xi);
                if (choose == 2)
                    Yi = hash.Sha3_256H(Xi);
                if (choose == 3)
                    Yi = hash.DSTU7564_256H(Xi);
            }
            if(S == 512) {
                if (choose == 1)
                    Yi = hash.Sha2_512H(Xi);
                if (choose == 2)
                    Yi = hash.Sha3_512H(Xi);
                if (choose == 3)
                    Yi = hash.DSTU7564_512H(Xi);
            }
            Y += Yi;

        }
    }
}

