/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goalstackplanning;

import java.util.ArrayList;

/**
 *
 * @author rohanm119
 */
public class Operator {
    
    public static void STACK(Block X, Block Y){
        X.blockBelow = Y.name;
        Y.clear = false;
    }
    
    public static void UNSTACK(Block X, Block Y){
        Y.clear = true;
        X.blockBelow = "";
        Y.blockAbove = "";
    }
    
    public static boolean on(Block X, Block Y){
        //System.out.println(X.blockBelow);
        return X.blockBelow.equals(Y.name);
    }
    
    public static boolean onTable(Block X){
        //System.out.println(X.blockBelow);
        return X.blockBelow.equals("");
    }
    
    public static boolean clear(Block X){
        return X.blockAbove.equals("");
    }
    
    public static ArrayList<String> process(String inp){
        if(isAction(inp)){
            processAction(inp);
            GSP.plan.add(inp);
            return null;
        }
        
        System.out.println(condIsTrue(inp));
        
        if(!condIsTrue(inp)){
            ArrayList<String> toPush = new ArrayList<>();
            toPush.add(getActionToPush(inp));
            toPush.addAll(getPreCond(inp));
            System.out.println(toPush);
            return toPush;
        }
        
        return null;
    }
    
    public static ArrayList<String> getPreCond(String inp){
        ArrayList<String> preCond = new ArrayList<>();
        
        if(inp.startsWith("onTable")){
            Block X = Block.getBlock(inp.substring(7));
            Block Y = Block.getBlock(X.blockBelow);
            preCond.add("clear"+X.name);
            preCond.add("on"+X.name+Y.name);
        }
        else if(inp.startsWith("on")){
            Block X = Block.getBlock(inp.substring(2, 3));
            Block Y = Block.getBlock(inp.substring(3));
            preCond.add("clear"+X.name);
            preCond.add("clear"+Y.name);
            preCond.add("onTable"+X.name);
        }
        
        else if(inp.startsWith("clear")){
            Block X = Block.getBlock(inp.substring(5));
            Block Y = Block.getBlock(X.blockAbove);
            preCond.add("clear"+X.name);
            preCond.add("on"+Y.name+X.name);
        }
        //System.out.println(preCond);
        return preCond;
    }
    
    public static boolean condIsTrue(String inp){
        if(inp.startsWith("onTable")){
            Block X = Block.getBlock(inp.substring(7));           
            return onTable(X);
        }
        else if(inp.startsWith("on")){
            Block X = Block.getBlock(inp.substring(2, 3));
            Block Y = Block.getBlock(inp.substring(3));
            return on(X, Y);
        }
        
        if(inp.startsWith("clear")){
            Block X = Block.getBlock(inp.substring(5));
            return clear(X);
        }
        
        return false;
    }
    
    public static String getActionToPush(String inp){
        if(inp.startsWith("onTable")){
            Block X = Block.getBlock(inp.substring(7));
            return "UNSTACK"+X.name+X.blockBelow;
        }
        else if(inp.startsWith("on")){
            Block X = Block.getBlock(inp.substring(2, 3));
            Block Y = Block.getBlock(inp.substring(3));
            return "STACK"+X.name+Y.name;
        }
        else if(inp.startsWith("clear")){
            Block X = Block.getBlock(inp.substring(5));
            return "UNSTACK"+X.blockAbove+X.name;
        }
      
        return "";
    } 
    
    public static void processAction(String inp){
        if(inp.startsWith("STACK")){
            Block X = Block.getBlock(inp.substring(5, 6));
            Block Y = Block.getBlock(inp.substring(6));
            STACK(X, Y);
        }
        else if(inp.startsWith("UNSTACK")){
            Block X = Block.getBlock(inp.substring(7, 8));
            Block Y = Block.getBlock(inp.substring(8));
            UNSTACK(X, Y);
        }
    }
    
    public static boolean isAction(String inp){
        return inp.startsWith("STACK") || inp.startsWith("UNSTACK");
    }

}
