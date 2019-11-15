/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goalstackplanning;

/**
 *
 * @author rohanm119
 */
public class Block {
    public String name;
    public boolean clear;
    public String blockBelow;
    public String blockAbove;
    
    Block(){
        this.name = "";
        this.clear = true;
        this.blockBelow = "";
        this.blockAbove = "";
    }
    
    Block(String name, boolean clear, String blockBelow, String blockAbove){
        this.name = name;
        this.clear = clear;
        this.blockBelow = blockBelow;
        this.blockAbove = blockAbove;
    }
    
    public static Block getBlock(String block){
        for(Block i: GSP.state){
            if(i.name.equals(block)){
                return i;
            }
        }
        return null;
    }
}
