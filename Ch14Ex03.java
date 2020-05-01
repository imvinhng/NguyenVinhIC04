
/*
 * ==========================================
 * CS211, Spring 2020, 4/24
 * Vinh T. Nguyen
 * In-Class Exercise #4 - copyStack
 * The method is created to malnipulate the stack, through the queue medium, to return a new stack
 * with original's content and order
 * while keeping the original's stack in tack
 * implementation of stackToStack and queueToStack method make life easier, while keeping things straightforward
 * ==========================================
 */
import java.util.*; 

public class Ch14Ex03 {
   public static void main(String[] args) {
    Integer[] l = {2,4,8,6,5,7,2,8,9};
    Stack<Integer> s = new Stack<>();
    
      for (int x : l){
         s.push(x);
      }
    System.out.println("Original Stack s: "+ s+'\n');

    copyStack(s); //return a new stack
    
    System.out.println("Original Stack s: "+ s );


   }
   
   public static void copyStack(Stack<Integer> s){
      Queue<Integer> q = new LinkedList<>();
      Stack<Integer> t = new Stack<>();
      Stack<Integer> st = new Stack<>();
      Stack<Integer> backup = new Stack<>();
      
      //intermediate step
      while(!s.isEmpty()){
      int n=s.pop();
      q.add(n);
      t.push(n);
      }
      
      //tertiary step
      queueToStack(q,backup);
      stackToStack(t,st);
      stackToStack(backup,s);      
        
      //final
      System.out.println("New Stack st: " +st + "\n"); //new stack w same values and orders as original

      }
      
      public static void queueToStack(Queue<Integer> q,Stack<Integer> s){
         while(!q.isEmpty()){
         int n = q.remove();
         s.push(n);
         }
      }
      
      public static void stackToStack(Stack<Integer> t,Stack<Integer> s){
         while(!t.isEmpty()){
         int n = t.pop();
         s.push(n);
         }
      }
     
}