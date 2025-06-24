import java.util.Scanner;
class node{
    int data;
    node next;

    node(){}

    node(int data){
        this.data=data;
    }
}

public class Stack_using_linked_list {
    static node top;
    static Scanner sc=new Scanner(System.in);

    static void push(){
        int a;
        System.out.println("Entered the element to be added into the stack: ");
        a=sc.nextInt();

        node x=new node(a);

        if(top==null){
            
            top=x;
        }
        else{
            x.next=top;
            top=x;
            System.out.println("Succesfully added the new element\n");
        }
    }

    static void pop(){
        if (top==null){
            System.out.println("Cannot delete an element from an empty stack\n");
        }
        else{
            top=top.next;
            System.out.println("Succesfully deleted the element\n");
        }
    }

    static void disp_top(){
        if (top==null){
            System.out.println("The stack is empty\n");
        }
        else{
            System.out.println("The top element is "+top.data+"\n");
        }
    }

    static void disp_stack(){
        if (top==null){
            System.out.println("Cannot display empty stack\n");
        }
        else{
            node t=top;
            int i=1;
            while(t!=null){
                System.out.println("Element "+(i)+": "+t.data);
                t=t.next;
                i++;
            }
            System.out.println("Displayed all the elements present in the stack\n");
        }
    }

    public static void main(String[] args) {
        boolean flag=true;
        int ch;

        while(flag==true){
            System.out.println("WELCOME\n");
            System.out.println("OPTIONS:\n");
            System.out.println("1.)PUSH\n2.)POP\n3.)Display top element\n4.)Display entire stack\n5.)EXIT\n");
            System.out.println("Enter your choice: ");
            ch=sc.nextInt();

            switch (ch){
                case 1:
                    push();
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    disp_top();
                    break;
                case 4:
                    disp_stack();
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice, try again\n");
            }
        }
    }
}
