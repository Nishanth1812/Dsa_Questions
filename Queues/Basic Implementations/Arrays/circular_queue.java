import java.util.Scanner;
public class circular_queue {
    static int size;
    static int front=-1,rear=-1;
    static Scanner sc=new Scanner(System.in);
    static int[] queue;

    static void create_queue(int s){
        queue=new int[s];
        size=s;
    }
    static void insert(){
        int x;
        System.out.println("Insert the element to be inserted: ");
        x=sc.nextInt();

        if (front==(rear+1)%size){
            System.out.println("Queue is full\n");
            return;
        }
        else if(front ==-1 && rear==-1){
            front=rear=0;
        }
        else{
            rear=(rear+1)%size;
        }
        queue[rear]=x;
        System.out.println("Succesfully added the elements\n");
    }

    static void del(){
        if (front==-1 && rear==-1){
            System.out.println("The queue is empty\n");
            return;
        }
        System.out.println("Succesfully deleted the element "+queue[rear]+"\n");
        if (front==rear){
            front=rear=-1;
        }
        else{
            front=(front+1)%size;
        }
    }

    public static void main(String[] args) {
        int s;
        System.out.println("Enter the size of the queue: ");
        s=sc.nextInt(); 
        create_queue(s);   

        boolean flag=true;
        while(flag==true){
            System.out.println("WELCOME\n");
            System.out.println("OPTIONS:");
            System.out.println("1.)Insert element\n2.)Delete element\n3.)Exit\n");
            int ch;
            System.out.println("Enter your choice: ");
            ch=sc.nextInt();

            switch(ch){
                case 1:
                    insert();
                    break;
                case 2:
                    del();
                    break;
                case 3:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice, try again\n");
                    break;
            }
        }
    }
}

