package com;
import com.Config.*;
import java.util.Scanner;


public class Main { //mvn exec:java -Dexec.mainClass="com.Main"

    public static void main(String[] args) {
        KeyPairGeneration kpg = new KeyPairGeneration();
        SignatureGeneration sg = new SignatureGeneration();
        SignatureVerification sv = new SignatureVerification();

        String Message = "Hello";

        Scanner inS = new Scanner(System.in);
        System.out.printf("Choose length of hash function (1 - 256, 2 - 512):\n"); //128
        int chS = Integer.parseInt(inS.nextLine());
        int S = 0;
        if(chS == 1)
            S = 256;
        if(chS == 2)
            S = 512;

        Scanner inL = new Scanner(System.in);
        System.out.printf("Input parametr l (length of pseudo random sequence):\n"); //128
        int l = Integer.parseInt(inL.nextLine());

        Scanner inK = new Scanner(System.in);
        System.out.printf("Input parametr k (S(mod k) = 0):\n"); //16
        int k = Integer.parseInt(inK.nextLine());

        Scanner inchoose = new Scanner(System.in);
        System.out.printf("Choose hash function (1 - sha2, 2 - sha3, 3 - Kupyna):\n"); //16
        int choose = Integer.parseInt(inchoose.nextLine());

        int t = (int) Math.pow(2, (S / k)); //256
        long start = System.currentTimeMillis(); // STAR TIMER
        kpg.generatePairKey(t, l, choose, S);
        System.out.println("X: " + KeyPairGeneration.X);
        System.out.println("Y: " + KeyPairGeneration.Y);
        System.out.println("SIGNATURE: " + sg.signatureCreation(k, t, l, Message, choose, S));
        System.out.println("Y`: " + sv.hashSignature(k, l, choose, S));
        long finish = System.currentTimeMillis(); // FINISH TIMER
        long timeConsumedMillis = finish - start;
        //Statistic
        System.out.println("\n" + "Statictic:");
        System.out.println("Length of Private key: " + KeyPairGeneration.X.length() + " bits");
        System.out.println("Length of Public key: " + KeyPairGeneration.Y.length() + " bits");
        System.out.println("Length of Signature: " + SignatureGeneration.SIGNATURE.length() + " bits");
        System.out.println("Time: " + timeConsumedMillis + "ms" + "\n");
        System.out.println("Resistance for r = 1: 2^" + resistanceAnalysis(k, S, 1) * (-1));
        System.out.println("Resistance for r = 2: 2^" + resistanceAnalysis(k, S, 2) * (-1));
        System.out.println("Resistance for r = 4: 2^" + resistanceAnalysis(k, S, 4) * (-1) + "\n");
        //Statistic
        //System.out.println("S: " + S);
        if(sv.verification(Message, k, t, S, l, choose))
            System.out.println("Signature is valid");
        else
            System.out.println("Signature is NOT valid");
        //HashFunction hf = new HashFunction();
        Scanner inExit = new Scanner(System.in);
        System.out.printf("Exit or not? (0 - Exit, 1 - Start):\n");
        int exitOrNot = Integer.parseInt(inExit.nextLine());
        if(exitOrNot == 1){
            Reboot();
            main(args);
        }
    }

    public static Integer resistanceAnalysis(Integer k, Integer S, Integer r){
        Binarylog bl = new Binarylog();
        int resistance = (int) (k * (S / k -  bl.binlog((double) k) -  bl.binlog((double) r)));
        return resistance;
    }

    public static void Reboot(){ // Reboot global parametrs
        KeyPairGeneration.X = "";
        KeyPairGeneration.Y = "";
        SignatureGeneration.SIGNATURE = "";
    }

}
