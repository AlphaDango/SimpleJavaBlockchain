package de.neumann;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        BlockChain blockChain = new BlockChain("Java is Klasse!");
        blockChain.addBlock("Python auch!");
        blockChain.addBlock("Ruby rockt!");
        blockChain.addBlock("Lass mich bloß in Ruhe mit F#!");
        blockChain.addBlock("C ist so schnell!");

        for(String s: blockChain.getHashes())
            System.out.println(s);
    }
}
