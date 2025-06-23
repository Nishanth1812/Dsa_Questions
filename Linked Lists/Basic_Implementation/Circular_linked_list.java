import java.util.Scanner;
class node{
    int data;
    node next;

    node(int d){
        data=d;
    }
}

class methods{
    static node head;

    // inserting the elements from the start 

    static void insert_first(Scanner sc){
        int d;
        d=sc.nextInt();
        node a =new node(d);

        if (head==null){
            head=a;
            System.out.println("Succesfully inserted the element!\n");    
        }
        else {
            a.next=head;
            head=a;
            System.out.println("Succesfully inserted the element!\n");    
        }
    }

    static void insert_pos(Scanner sc,int pos){
        int d;
        d=sc.nextInt();
        node a =new node(d);

        if (pos<0){
            System.out.println("Invalid position!!\n");
        }

        if (head==null){
            head=a;
            System.out.println("Succesfully inserted the element!\n");    
        }
        else{
            node t=head;
            for(int i=0;i<pos-1;i++){
                t=t.next;
            }
            node temp=t.next;
            t.next=a;
            a.next=temp;
            System.out.println("Succesfully inserted the element!\n");    
        }
    }

    // Inserting at the last

    static void insert_last(Scanner sc){
        int d;
        d=sc.nextInt();
        node a =new node(d);

        if(head==null){
            head=a;
            System.out.println("Succesfully inserted the element!\n");    
        }
        else if(head.next==null){
            head.next=a;
            a.next=head;
            System.out.println("Succesfully inserted the element!\n");    
        }
        else{
            node t=head;
            while(t.next!=head){
                t=t.next;
            }
            t.next=a;
            a.next=head;
            System.out.println("Succesfully inserted the element!\n");
        }
    }

    // Deleting from start

    static void del_start(){
        if (head==null){
            System.out.println("The list is empty\n");
        }
        else if(head.next==null){
            head=null;
            System.out.println("Succesfully deleted element\n");
        }
        else{
            node a=head;
            head=head.next;
            a.next=null;
            System.out.println("Succesfully deleted element\n");
        }
    }

    // Deleting at the given position

    static void del_pos(int pos){
        if (pos<0){
            System.out.println("Invalid position, try again\n");
        }

        if (head==null){
            System.out.println("cannot delete from empty list\n");
        }
        else if (head.next==null && pos>0){
            System.out.println("Invalid position, try again\n");
        }
        else{
            node t=head;
            int i=0;
            while(i<pos-1){
                t=t.next;
                i++;
            }
            node a=t.next;
            t.next=a.next;
            a.next=null;
            System.out.println("Succesfully delted the element\n");
        }
    }

    // Deleting at last

    static void del_last(){
        if (head==null){
            System.out.println("Cannot delete from an empty list\n");
        }
        else if(head.next==head){
            head=null;
            System.out.println("Succesfully deleted the element\n");
        }
        else{
            node t=head.next;
            while(t.next!=head){
                t=t.next;
            }
            node a =t.next;
            a.next=null;
            t.next=head;
            System.out.println("Succesfully deleted the element\n");
        }
    }

    // Reversing the list
    
    static void reverse_list(){
        if(head==null){
            System.out.println("Cannot reverse an empty list");
        }
        else if (head.next==head){
            System.out.println("Cannot reverse a list with only 1 element");
        }
        else{
            node prev=null;
            node curr=head;
            node next;

            do { 
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            } while (curr!=head);

            head.next=prev;
            head=prev;
            System.out.println("Succesfully reversed the linked list\n");
        }
    }

    // Display the full list 

    static void disp_list(){
        if (head==null){
            System.out.println("Cannot display an empty list\n");
        }
        else if(head.next==head){
            System.out.println("Element-1: "+head.data);
            System.out.println("\nEnd of list\n");
        }
        else{
            node t=head;
            int i=1;
            do { 
                System.out.println("element "+i+": "+t.data+"\n");
                i++;
                t=t.next;
            } while (t!=head);
            System.out.println("Succesfully printed all the elements\n");
        }
    } 



}


public class Circular_linked_list {
    public static void main(String[] args) {
        methods m=new methods();

        Scanner sc=new Scanner(System.in);

        boolean flag=true;

        while(flag==true){
            System.out.println("\nWELCOME!!\n");
            System.out.println("\nOPTIONS\n");
            System.out.println("\n1.) Insert at start\n2.) Insert at given position\n3.) Insert at last\n4.) Delete from start\n5.) Delete from the given position\n6.) Delete at last\n7.) Reverse the list\n8.) Display the list\n9.) Exit\n");

            int ch;

            System.out.println("Enter Your Choice: ");
            ch=sc.nextInt();

            switch (ch){
                case 1:
                    m.insert_first(sc);
                    break;
                
                case 2:
                    int a;
                    System.out.println("Enter the position for element  to be inserted: ");
                    a=sc.nextInt();
                    m.insert_pos(sc,a);
                    break;

                case 3:
                    m.insert_last(sc);
                    break;
                case 4:
                    m.del_start();
                    break;
                case 5:
                    int b;
                    System.out.println("Enter the position for element to be deleted: ");
                    b=sc.nextInt();
                    m.del_pos(b);
                    break;
                case 6:
                    m.del_last();
                case 7:
                    m.reverse_list();
                    break;
                case 8:
                    m.disp_list();
                    break;
                case 9:
                    flag=false;
                    System.out.println("Thank you\n");
                    break;
            }
        }
    }
}


