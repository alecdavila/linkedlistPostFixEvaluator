import java.util.*;

//Personally made Stack with LL
class StackWithLinkedList{
   private Node head;
   
   private class Node{
    double data;
    Node next;
   }
   
   
   public StackWithLinkedList(){
      this.head = null;
   }
   
   //add new node to the stack
   public void push(double data) {
      
      Node temp = new Node();
      if(temp == null)
      {
         System.out.println("Heap overflow \n");
         return;
      }
      
      temp.data = data;
      temp.next = head;
      head = temp;
      
   }
   //delete node from the stack
   public double pop() {
      //if (head == null) throw new EmptyStackException();
      double value = head.data;
      head = head.next;
      return value;
    }
    //look at top of stack
    public double peek()  {
     return head.data;
    }
    
    public boolean isEmpty() {
      
      return head == null;
    }
    
    public void printStack(){
      Node temp = head;
      while(temp != null){
         System.out.print(temp.data);
         temp = temp.next;
      }
    }
}
   
class QNode {
   String key;
   QNode next;
   
   //constructor to create a new linked lsit
   public QNode( String key){
   
      this.key = key;
      this.next = null;
   
   }

}

class Queue{   
   QNode front, rear;
   
   public Queue(){
      this.front = this.rear = null;
   }
   
   //method to add to queue
   void enqueue(String key){
      
      //create a new ll node
      QNode temp = new QNode(key);
      
      if (this.rear == null){
         this.front = this.rear = temp;
         return;
      }
      
      //add the new node to the end of the queue and change rear
      this.rear.next = temp;
      this.rear = temp;
      
      //need to point head and rear to null if they are same
   }
    
    public boolean isEmpty(){
      return rear == null;
    }
    //method to remove key from queue
    public String dequeue(){
    
      //if queue is empty return null
      if (this.front == null){
         return null;
      }
      
      //Store previous front and move front one node ahead
      QNode temp = this.front;
      this.front = this.front.next;
      
      //if front becomes null, then change rear also as null
      if (this.front == null){
         this.rear = null;
      }
      
      
      if(front == rear){
      this.front = null;
      this.rear = null;
      }
     
    
     return temp.key;
 }
}


public class Evaluation{
   
   private StackWithLinkedList st = new StackWithLinkedList();
   private Queue q = new Queue();
   
   public void Add(String s)
   {   
      q.enqueue(s);
   }
      
      
    static String About(){
    String about = "Alec Davila CSC 130 Postfix Evaluation";
      return about;
    }
    
    public double evaluatePostFix(){
         //StackWithLinkedList sll = new StackWithLinkedList();
         
      while(!q.isEmpty()){
         String temp = q.dequeue();
           
            switch(temp) {
               case "+":
                  st.push(st.pop() + st.pop());
                  break;
               case "-":
                  st.push(st.pop()-st.pop());
                  break;
               case "*":
                  st.push(st.pop() * st.pop());
                  break;
               case "/":
                  st.push(st.pop() /st.pop());
                  break;
               case "^":
                  st.push(Math.pow(st.pop(),st.pop()));
                  break;
               case "%":
                  st.push(st.pop()%st.pop());
                  break;
               default: st.push(Double.parseDouble(temp));
             }
             
           
           
      }
     return st.pop();
 }


   public static void main(String[] args) {
      
      StackWithLinkedList sll = new StackWithLinkedList();
      
      System.out.println(About());
      
      Queue eval = new Queue();
      Evaluation e = new Evaluation();
      
      e.Add("4");
      e.Add("5");
      e.Add("+");
      e.Add("3");
      e.Add("*");
    
      
      double result = e.evaluatePostFix();
      
      System.out.println(result);
      
      //time to bring the que up and add items to the stack
      

         
  } 
}
