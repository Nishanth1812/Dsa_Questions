
import java.util.Scanner;

public class Stack_using_array {
    static int[] stack;
    static int size;
    static int top;
    static Scanner sc=new Scanner(System.in);

    static void create_stack(int s){
        stack=new int[s];
        size=s;
        top=-1;
    }

    static void push(){
        if (top==size-1){
            System.out.println("Stack Overflow,cannot insert elements\n");
        }
        else{
            int a;
            System.out.println("Enter the new element to be added to the stack: ");
            a=sc.nextInt();
            
            stack[top+1]=a;
            top=top+1;
            
        }
    }

    static void pop(){
        if (top==-1){
            System.out.println("Stack UnderFlow , cannot delete elements\n");
        }
        else{
            stack[top]=0;
            top=top-1;
            System.out.println("Succesfully popped the element\n");
        }
    }

    static void disp_top(){
        if (top==-1){
            System.out.println("Stack Underflow , cannot display element\n");
        }
        else{
            System.out.println("The top element is "+stack[top]);
        }
    }

    static void display_stack(){
        if(top==-1){
            System.out.println("Stack underflow , cannot display elements\n");
        }
        else{
            int i=0;
            while(i<=top){
                System.out.println("Element "+(i+1)+": "+stack[i]);
                i++;
            }
            System.out.println("Succesfully displayed all elements\n");
        }
    }

    public static void main(String[] args) {
        boolean flag=true;
        int s;
        System.out.println("Enter the size of the stack: ");
        s=sc.nextInt();
        create_stack(s);

        while(flag==true){
            System.out.println("\nWELCOME");
            System.out.println("OPTIONS:");
            System.out.println("1.)PUSH\n2.)POP\n3.)Display Top\n4.)Display Stack\n5.)Exit\n");

            int ch;
            System.out.println("Enter your choice: ");
            ch=sc.nextInt();

            switch(ch){
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
                    display_stack();
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid Choicde , try again\n");
            }
        }
    }
}
