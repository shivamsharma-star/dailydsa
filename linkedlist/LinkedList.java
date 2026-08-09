class LinkedList {
    // node class implementation
static class Node{
int data;
Node next;

Node(int data){
this.data=data;
this.next=null;
}
}

// some node creation

public static void main(String args[]){
    Node first=new Node(10);
    Node second=new Node(20);
    Node third=new Node(30);
    Node fourth=new Node(40);
    Node fifth=new Node(50);
    Node sixth=new Node(60);
    first.next=second;
    second.next=third;
    third.next=fourth;
    fourth.next=fifth;
    fifth.next=sixth;

   while(first!=null){
       System.out.println(first.data);
       first=first.next;
   }
}

}