// Singly Linked list

import java.util.Scanner;

class node{
    @SuppressWarnings("unused")
    int data;
    @SuppressWarnings("unused")
    node next;

    node(int d){
        data=d;
        next=null;
    }
} 


class methods{
    static node head;

    static void insert_start(Scanner sc){
        int data;
        data=sc.nextInt();

        node a;
        a=new node(data);  

        if (head==null){
            head=a;
        }
        else{
            a.next=head;
            head=a;
        }
        System.out.println("Succesfully inserted element\n");
    }


    static void insert_pos(Scanner sc,int pos){
        int data;
        data=sc.nextInt();

        node a;
        a=new node(data);  

        if (head==null){
            head=a;
        }
        else if (head.next==null){
            head.next=a;
        }
        else{
            node t=head;
            for(int i=0;i<pos-1 && t!=null;i++){
                t=t.next;
            }
            node temp=t.next;
            t.next=a;
            a.next=temp;
            System.out.println("Succesfully inserted the element\n");
        }
        
    }

    static void insert_last(Scanner sc){
        node a;
        int data;
        data=sc.nextInt();
        a=new node(data);

        if (head==null){
            head=a;
        }
        else if (head.next==null){
            head.next=a;
        }
        else{
            node t=head;
            while(t.next!=null){
                t=t.next;
            }
            t.next=a;
            System.out.println("Succesfully inserted element\n");
        }
        
    }

    static void is_empty(){
        if (head==null){
            System.out.println("The linked list is empty\n");
        }
        else{
            System.out.println("The linked list is not empty\n");
        }
    }

    static void del_first(){
        if (head==null){
            System.out.println("The linked list is empty\n");
        }
        else if(head.next==null){
            head=null;
            System.out.println("Succesfully deleted the element\n");
        }
        else{
            head=head.next;
            System.out.println("Succesfully deleted the element\n");
        }
    }

    static void del_pos(int pos){
        if (head==null){
            System.out.println("The list is empty\n");
        }
        else if (head.next==null && pos>0){
            System.out.println("Position out of bounds\n");
        }
        else if(head.next==null && pos==0){
            head=null;
            System.out.println("Succesfully deleted the element\n");
        }
        else{
            node n=head;

            for (int i=0;i<pos-1;i++){
                n=n.next;
            }
            node a=n.next;
            n.next=a.next;
            a.next=null;
            System.out.println("Succesfully deleted the element\n");
        }
    }

    static void del_last(){
        if (head==null){
            System.out.println("The linked list is empty");
        }
        else if (head.next==null){
            head=null;
            System.out.println("Element succesfully deleted");
        }
        else{
            node t=head;
            node n=t.next;
            while(n.next!=null){
                t=t.next;
                n=t.next;
            }
            t.next=null;
            System.out.println("Succesfully deleted element");
        }
    }

    static void size(){
        int len=0;
        if (head==null){
            System.out.println("The linked list is empty");
        }
        else if (head.next==null){
            len++;
        }
        else{
            node t=head;
            while(t.next!=null){
                t=t.next;
                len++;
            }
            len++;
        }
        System.out.println("The size of the linked list is "+len);
    }

    static void is_last_element(int el){
        if(head==null){
            System.out.println("The list is empty");
        }
        else if(head.next==null && head.data==el){
            System.out.println("The linked list contains 1 element and the given element is the last one");
        }
        else{
            node t=head;
            while(t.next!=null){
                t=t.next;
            }

            if (t.data==el){
                System.out.println("The given element is the last element");
            }
            else{
                System.out.println("The given element is not the last element");
            }
        }
    }


    static void reverse_list(){
        if (head==null){
            System.out.println("Cannot reverse and empty linked list");
        }
        else if(head.next==null){
            System.out.println("Cannot reverse linked list with only 1 element");
        }

        else{
            node t=head;
            node prev=null;
            node curr=t;
            node next=null;

            while (curr!=null){
                next=curr.next;
                curr.next=prev;

                prev=curr;
                curr=next;
            }
            head=prev;

            System.out.println("Succesfully reversed the list");
        }
    }

    static void display_linked_list(){
        if (head==null){
            System.out.println("Cannot display an empty linked list\n");
        }
        else if(head.next==null){
            System.out.println("Printing elemets..\n"+head.data+"\n");
            System.out.println("The list contains only 1 element\n");
        }
        else{
            node t=head;
            System.out.println("Printing elemets..\n");
            while(t.next!=null){
                System.out.println("Element: "+t.data+"\n");
                t=t.next;
            }
            System.out.println("Last Element: "+t.data+"\n");
            System.out.println("The list is out of elements!!!\n");
        }
    }
}

class Singly_Linked_List{
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        methods method=new methods();
        boolean flag=true;
        while (flag==true){
            System.out.println("Welcome to singly linked list operations!!\n");
            System.out.println("\nOPTIONS\n");
            System.out.println("\n1.) Insert element at start\n2.) Insert element at given posistion\n3.) Insert element at last\n4.) Check if list is empty\n5.) Delete element from the start\n6.) Delete element at given posistion\n7.) Delete element from the end\n8.) Find the size of the list\n9.) Check if given element is last element\n10.) Reverse the linked list\n11.) Display the linked list\n12.) Exit\n");

            System.out.println("What is your choice?\n");
            int ch;
            ch=sc.nextInt(); 

            switch(ch){
                case 1:
                    method.insert_start(sc);
                    break;
                case 2:
                    int n;
                    System.out.println("At which position do you want to insert the element?\n");
                    n=sc.nextInt();
                    method.insert_pos(sc,n);
                    break;
                case 3:
                    method.insert_last(sc);
                    break;
                case 4:
                    method.is_empty();
                    break;
                case 5:
                    method.del_first();
                    break;
                case 6:
                    int x;
                    System.out.println("At which position do you want to insert the element?\n");
                    x=sc.nextInt();
                    method.del_pos(x);
                    break;
                case 7:
                    method.del_last();
                    break;
                case 8:
                    method.size();
                    break;
                case 9:
                    int y;
                    System.out.println("At which position do you want to insert the element?\n");
                    y=sc.nextInt();
                    method.is_last_element(y);
                    break;
                case 10:
                    method.reverse_list();
                    break;
                case 11:
                    method.display_linked_list();
                    break;
                case 12:
                    System.out.println("Thank You for using this system!!\n");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice!!\ntry again\n\n");

            }
        }
    }
}

