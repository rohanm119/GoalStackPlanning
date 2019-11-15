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
public class Stack {
    ArrayList<String> stack = new ArrayList<>();
    
    public void push(ArrayList<String> items){
        if(items == null){
            return;
        }
        stack.addAll(items);
    }
    
    public void push(String item){
        stack.add(item);
    }
    
    public String pop(){
        String value =  stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return value;
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    public void print(){
        System.out.println(stack);
    }
}
