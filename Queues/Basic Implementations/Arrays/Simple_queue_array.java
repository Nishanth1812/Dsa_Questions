import  java.util.Scanner;
public class Simple_queue_array {
    static Scanner sc=new Scanner(System.in);
    static int front=-1;
    static int rear=-1;
    static int size;
    static int[] queue;

    static void create_queue(int s){
        queue=new int[s];
        size=s;
    }

    static void enqueue(){
        int x;
        System.out.println("Enter the element to be added to the queue\n");
        x=sc.nextInt();

        if(rear==size){
                System.out.println("The queue is full\n");
                return;
            }

        if (front ==-1 && rear==-1){
            rear=0;
            front=0;
        }    
        queue[rear]=x;
        rear++;

    }

    static void dequeue(){
        if(front==-1 || front==rear){
            System.out.println("The queue is empty\n");
            
        }
        else if(front==rear-1){
            System.out.println("Succesfully deleted "+queue[front]+"\n");
            front=-1;
            rear=-1;
            System.out.println("Queue is empty\n");
        }
        else{
            queue[front]=0;
            front++;
            System.out.println("Succesfuly deleted the element\n");
            
        }
    }

    static void display_top(){
        if (front==-1 || front==rear){
            System.out.println("The queue is empty\n");
        }
        else{
            System.out.println("The top most element is "+queue[front]+"\n");
        }
    }

    static void display_queue(){
        if (front==-1){
            System.out.println("Cannot display from an empty list\n");
        }
        else{
        for (int i=front;i<rear;i++){
            System.out.println("Element: "+queue[i]);
            }
        System.out.println("Succesfully displayed all the elements\n");

        }
    }

    public static void main(String[] args){
        int s;
        System.out.println("Enter the size of the queue ");
        s=sc.nextInt();
        create_queue(s);

        int ch;
        boolean flag=true;

        while(flag==true){
            System.out.println("WELCOME");
            System.out.println("OPTIONS\n");
            System.out.println("1.)ENQUEUE\n2.)DEQUEUE\n3.)Display top\n4.)Display queue\n5.)Exit\n");
            System.out.println("Enter your choice: ");
            ch=sc.nextInt();

            switch (ch){
                case 1:
                    enqueue();
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display_top();
                    break;
                case 4:
                    display_queue();
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
