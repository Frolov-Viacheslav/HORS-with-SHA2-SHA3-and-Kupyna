package com;
import com.Config.*;

public class SignatureVerification {
    Binarylog bl = new Binarylog();
    HashFunction hash = new HashFunction();
    SignatureGeneration sg = new SignatureGeneration();

    public String hashMessage(String Message, Integer choose, Integer S){ // Message hashing
        if(S == 256) {
            if (choose == 1)
                Message = hash.Sha2_256B(Message);
            if (choose == 2)
                Message = hash.Sha3_256B(Message);
            if (choose == 3)
                Message = hash.DSTU7564_256B(Message);
        }
        if(S == 512) {
            if (choose == 1)
                Message = hash.Sha2_512B(Message);
            if (choose == 2)
                Message = hash.Sha3_512B(Message);
            if (choose == 3)
                Message = hash.DSTU7564_512B(Message);
        }
        return Message;
    }

    public Integer [] separateMessage(String Message, Integer k, Integer t, Integer choose, Integer S){ // Separation of the message into blocks
        Message = hashMessage(Message, choose, S);
        Integer [] blocksOfMessage = new Integer[k];
        int j = 0;
        for(int i = 0; i < Message.length(); i = i + (int)Math.ceil(bl.binlog((double) t))) {
            String S1 = Message.substring(i, i + (int)Math.ceil(bl.binlog((double) t)));
            blocksOfMessage[j++] = Integer.parseInt(S1, 2);
        }
        return blocksOfMessage;
    }

    public String hashSignature(Integer k, Integer l, Integer choose, Integer S){ //Hashing the signature
        String sig = "";
        for(int i = 0; i < k; i++){
            if(S == 256) {
                if (choose == 1)
                    sig += hash.Sha2_256H(SignatureGeneration.SIGNATURE.substring(i * l, i * l + l));
                if (choose == 2)
                    sig += hash.Sha3_256H(SignatureGeneration.SIGNATURE.substring(i * l, i * l + l));
                if (choose == 3)
                    sig += hash.DSTU7564_256H(SignatureGeneration.SIGNATURE.substring(i * l, i * l + l));
            }
            if(S == 512) {
                if (choose == 1)
                    sig += hash.Sha2_512H(SignatureGeneration.SIGNATURE.substring(i * l, i * l + l));
                if (choose == 2)
                    sig += hash.Sha3_512H(SignatureGeneration.SIGNATURE.substring(i * l, i * l + l));
                if (choose == 3)
                    sig += hash.DSTU7564_512H(SignatureGeneration.SIGNATURE.substring(i * l, i * l + l));
            }
        }
        return sig;
    }

    public boolean verification(String Message, Integer k, Integer t, Integer S, Integer l, Integer choose){
        String sig = hashSignature(k, l, choose, S);
        Integer [] blocksOfMessage = separateMessage(Message, k, t, choose, S);
        int j = 0;
        S = S / 4;
        for(int i = 0; i < k; i++){
            if(sig.substring(i * S, i * S + S).compareTo(KeyPairGeneration.Y.substring(blocksOfMessage[i] * S, blocksOfMessage[i] * S + S)) == 0){
                j++;
            }
        }

        if(j == k)
            return true;
        else
            return false;
    }
}
