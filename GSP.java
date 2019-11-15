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
public class GSP {
    public static Block[] initialBlockState = new Block[4];
    public static Block[] finalBlockState = new Block[4];
    public static Block[] state;
    public static ArrayList<String> plan = new ArrayList<>();
    
    GSP(){
        initialBlockState[0] = new Block("A", false, "", "B");
        initialBlockState[1] = new Block("B", true, "A", "");
        initialBlockState[2] = new Block("C", true, "", "");
        initialBlockState[3] = new Block("D", true, "", "");
        
        finalBlockState[0] = new Block("A", false, "", "C");
        finalBlockState[1] = new Block("B", true, "D", "");
        finalBlockState[2] = new Block("C", true, "A", "");
        finalBlockState[3] = new Block("D", false, "", "B");
        
        state = initialBlockState;
    }
    
    public ArrayList<String> generatePredicates(Block[] state){
        ArrayList<String> predicates = new ArrayList<>();
        
        for (Block i : state) {
            if(i.blockBelow.equals("")){
                predicates.add("onTable"+i.name);
            }
            
            if(!i.blockAbove.equals("")){
                predicates.add("on"+i.blockAbove+i.name);
            }
            else{
                predicates.add("clear"+i.name);
            }
        }
        
        return predicates;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GSP gsp = new GSP();
        Stack s = new Stack();
        s.push(gsp.generatePredicates(finalBlockState));
        s.print();
//        while(!s.isEmpty()){
//            String element = s.pop();
//            s.push(Operator.process(element));
//            s.print();
//        }
//        System.out.println(plan);
        
        
    }
    
}
