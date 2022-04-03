package de.neumann;

import java.util.ArrayList;

/**
 * BlockChain Class
 * @author Oliver Neumann
 */
public class BlockChain {

    private final ArrayList<Block> chain;

    /**
     * Constructor of the blockchain.
     * @param firstData First data of the blockchain. Needed for the genesis block.
     */
    public BlockChain(String firstData){
        chain = new ArrayList<>();
        Block block = new Block(firstData,"0000000000000000000000000000000000000000000000000000000000000000",
                0);
        chain.add(block);
    }

    /**
     * Method to add a new block to the blockchain.
     * @param data Data of the new block.
     */
    public void addBlock(String data){
        Block block = new Block(data,chain.get(chain.size()-1).getHash(),chain.size());
        chain.add(block);
    }

    /**
     * Method to get all hashes inside the blockchain.
     * @return ArrayList with all hashes.
     */
    public ArrayList<String> getHashes(){
        ArrayList<String> hashList = new ArrayList<>();
        for(Block b: chain){
            hashList.add(b.getHash());
        }
        return hashList;
    }
}