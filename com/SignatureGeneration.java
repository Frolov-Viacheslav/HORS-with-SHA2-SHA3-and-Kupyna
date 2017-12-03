package com;
import com.Config.*;

public class SignatureGeneration {
    Binarylog bl = new Binarylog();
    HashFunction hash = new HashFunction();

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
    public static String SIGNATURE = "";
    public String signatureCreation(Integer k, Integer t, Integer l, String Message, Integer choose, Integer S){ // Creating a signature
        Integer [] blocksOfMessage = separateMessage(Message, k, t, choose, S);
        String tempSIGNATURE= "";
        for(int i = 0; i < k; i++){
            tempSIGNATURE = KeyPairGeneration.X.substring(blocksOfMessage[i] * l, blocksOfMessage[i] * l + l);
            SIGNATURE += tempSIGNATURE;
        }
        return SIGNATURE;
    }
}
