import  java.util.Scanner;
public class doubly_ended_queue {
    static int front=-1,rear=-1;
    static int size;
    static int[] queue;
    static Scanner sc=new Scanner(System.in);

    static void create_queue(int s){
        queue=new int[s];
        size=s;
    }

    // insertion from the front

    static void insert_front(){
        int x;
        System.out.println("Enter the element to be inserted: ");
        x=sc.nextInt();

        if (front==(rear+1)%size){
            System.out.println("Queue is full\n");
            return;
        }
        else if (front==-1 && rear==-1){
            front=rear=0;
        }
        
        else{
            front=(front+size-1)%size;
        }
        queue[front]=x;
        System.out.println("Succesfully inserted element\n");
        
    }

    static void insert_rear(){
        int x;
        System.out.println("Enter the element to be inserted: ");
        x=sc.nextInt();

        if(front==(rear+1)%size){
            System.out.println("The queue is full");
            return;
        }
        else if(front==-1 &&rear==-1){
            front=rear=0;
        }
        else{
            rear=(rear+1)%size;
        }

        queue[rear]=x;
        System.out.println("Succesfully inserted element\n");
    } 

    static void del_front(){
        if (front==-1 && rear==-1){
            System.out.println("The queue is empty\n");
            return;
        }
        System.out.println("Succesfully deleted element "+queue[front]+"\n");

        if(front==rear){
            front=rear=-1;
        }
        else{
            front=(front+1)%size;
        }
    }

    static void del_rear(){
        if (front==-1 && rear==-1){
            System.out.println("The queue is empty\n");
            return;
        }

        System.out.println("Succesfully deleted element "+queue[rear]+"\n");

        if(front==rear){
            front=rear=-1;
        }
        else{
            rear=(rear-1+size)%size;
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
            System.out.println("OPTIONS:\n");
            System.out.println("1.)Enqueue Front\n2.)Enqueue Rear\n3.)Dequeue front\n4.)Dequeue rear\n5.)EXIT\n");
            int ch;
            System.out.println("Enter your choice: ");
            ch=sc.nextInt();

            switch(ch){
                case 1:
                    insert_front();
                    break;
                case 2:
                    insert_rear();
                    break;
                case 3:
                    del_front();
                    break;
                case 4:
                    del_rear();
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
