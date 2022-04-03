package de.neumann;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Block Class
 * @author Oliver Neumann
 */
public class Block {

    private String hash;
    private String data;
    private String previousHash;
    private int index;

    /**
     * Constructor of a blockchain block.
     * @param data Data to be hashed,
     * @param previousHash Hash of the previous block.
     * @param index Blockindex.
     */
    public Block(String data, String previousHash, int index){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("SHA-256");
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            assert false: "MessageDigest couldn't initialise";
        }

        String tmp = data+previousHash;
        byte[] hashData = md.digest(tmp.getBytes(UTF_8));
        StringBuilder buffer = new StringBuilder();

        for (byte b : hashData)
            buffer.append(String.format("%02x",b));

        this.hash = buffer.toString();
        this.previousHash = previousHash;
        this.index = index;
        this.data = data;
    }

    public String getHash(){
        return hash;
    }
}