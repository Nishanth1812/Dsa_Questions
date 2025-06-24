// Doubly Linked List

import java.util.Scanner;

class node{
    node prev;
    int data;
    node next;

    node(){
        prev=null;
        data=0;
        next=null;
    }
    node(int d){
        prev=null;
        data=d;
        next=null;
    }
}

class methods{

    static node head;

    // Inserting element at the start
    static void insert_first(Scanner sc){
        int d;
        d=sc.nextInt();

        node a=new node(d);

        if(head==null){
            head=a;
            System.out.println("Element got added succesfully!\n");
        }
        else{
            a.next=head;
            head=a;
            System.out.println("Element got added succesfully!\n");
        }
    }
    // Insertion at the given position

    static void insert_pos(Scanner sc,int pos){
        int d;
        d=sc.nextInt();
        node a=new node(d);

        if(head==null){
            head=a;
            System.out.println("Element got added succesfully!\n");
        }
        else if (head.next==null){
            head.next=a;
        }
        else{
            node t=head;

            for(int i=0;i<pos-1;i++){
                t=t.next;
            }
            node temp;
            temp=t.next;

            t.next=a;
            a.prev=t;
            temp.prev=a;
            a.next=temp;

            System.out.println("Element got added succesfully!\n");
        }
    }

    // Insertion at the last

    static void insert_end(Scanner sc){
        int d;
        d=sc.nextInt();
        node a =new node(d);

        if(head ==null){
            head=a;
            System.out.println("Element got added succesfully!\n");
        }
        else if(head.next==null){
            head.next=a;
            a.prev=head;
            System.out.println("Element got added succesfully!\n");
        }
        else{
            node t=head;
            while(t.next!=null){
                t=t.next;
            }
            t.next=a;
            a.prev=t;
            System.out.println("Element got added succesfully!\n");
        }
    }

    // Delete from start position

    static void del_first(){
        if (head==null){
            System.out.println("Cannot delete from a empty list\n");
        }
        else if(head.next==null){
            head=null;
            System.out.println("Element got deleted succesfully!\n");
        }
        else{
            head=head.next;
            head.prev=null;
            System.out.println("Element got deleted succesfully!\n");
        }
    }
    
    // delete from the given position

    static void del_pos(int pos){
        if (head==null){
            System.out.println("Cannot delete from an empty list");
        }
        else if (head.next==null && pos>0){
            System.out.println("Position out of bounds\n");
        }
        else{
            node t=head;
            for(int i=0;i<pos-1;i++){
                t=t.next;
            }
            node temp1,temp2;

            temp1=t.next;
            t.next=temp1.next;
            temp2=t.next;
            temp2.prev=t;
            System.out.println("Element got deleted succesfully!\n");
        }
    }

    // Deleting at the last 

    static void del_last(){
        if (head==null){
            System.out.println("Cannot delete from an empty list");
        }
        else if (head.next==null){
            head=null;
            System.out.println("Element got deleted succesfully!\n");
        }
        else{
            node t=head;
            while(t.next!=null){
                t=t.next;
            }
            t.next=null;
            t.next.prev=null;
            System.out.println("Element got deleted succesfully!\n");
        }
    }

    // Checking if list is empty
    static void is_empty(){
        if (head==null){
            System.out.println("The list is empty");
        }
        else{
            System.out.println("The list is not empty");
        }
    }

    // Reversing the linked list
    static void reverse_list(){
        if (head==null){
            System.out.println("Cannot reverse a list with no elements");
        }
        else if (head.next==null){
            System.out.println("Cannot reverse a list with only 1 elements");
        }

        else{
            node temp=null;
            node curr=head;
            
            while(curr!=null){
                temp=curr.prev;

                curr.prev=curr.next;
                curr.next=temp;

                curr=curr.prev;
            }

            if (temp!=null){
                head=temp.prev;
            }

            System.out.println("Succesfully reversed the list");
        }
    }

    // Display the entire list

    static void display_list(){
        if (head==null){
            System.out.println("The list is empty\n");
        }
        else if (head.next==null){
            System.out.println("Starting Displa of elements:\n");
            System.out.println(head.data+"End of list\n");
        }
        else{
            node t=head;
            System.out.println("Starting Displa of elements:\n");
            while(t!=null){
                System.out.println(t.data+"\n");
                t=t.next;
            }
            System.out.println("The list is out of elements\n");
        }
    }
}




class Doubly_Linked_List {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        methods method=new methods(); 
        boolean flag=true;
        while (flag==true){
            System.out.println("Welcome to doubly linked list operations!!\n");
            System.out.println("\nOPTIONS\n");
            System.out.println("\n1.) Insert element at start\n2.) Insert element at given posistion\n3.) Insert element at last\n4.) Delete element from the start\n5.) Delete element at given posistion\n6.) Delete element from the end\n7.) Check if list is empty\n8.) Reverse the linked list\n9.) Display the linked list\n10.) Exit\n");

            System.out.println("What is your choice?\n");
            int ch;
            ch=sc.nextInt(); 

            switch(ch){
                case 1:
                    method.insert_first(sc);
                    break;
                case 2:
                    int n;
                    System.out.println("At which position do you want to insert the element?\n");
                    n=sc.nextInt();
                    method.insert_pos(sc,n);
                    break;
                case 3:
                    method.insert_end(sc);
                    break;
                case 4:
                    method.del_first();
                    break;
                case 5:
                    int x;
                    System.out.println("At which position do you want to insert the element?\n");
                    x=sc.nextInt();
                    method.del_pos(x);
                    break;
                case 6:
                    method.del_last();
                    break;
                case 7:
                    method.is_empty();
                    break;
                case 8:
                    method.reverse_list();
                    break;
                case 9:
                    method.display_list();;
                    break;
                case 10:
                    System.out.println("Thank You for using this system!!\n");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice!!\ntry again\n\n");
            }
        }
    }
}
