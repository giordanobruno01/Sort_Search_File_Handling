import java.util.Scanner;

public class ProcessApp {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        //Part 1: Question 2

        System.out.println("how many students?");
        int size = scan.nextInt();
        Process obj1 = new Process(size);//object for 10 students
        obj1.storeData();
        System.out.println(obj1.invalid +" invalid data");
        double start = System.nanoTime();//recording the current time in nanoseconds
        obj1.sort(0, obj1.index - 1);//sorting the array
        double end = System.nanoTime();//recording the current time
        double time = end - start;//calculating the time taken to sort
        System.out.println("the process took: " + time/1000 + " ms");//displaying the time taken to sort in milliseconds

        System.out.println("how many students?");
        size = scan.nextInt();
        Process obj2 = new Process(size);//object for 100 students
        obj2.storeData();
        System.out.println(obj2.invalid +" invalid data");
        start = System.nanoTime();
        obj2.sort(0, obj1.index - 1);
        end = System.nanoTime();
        time = end - start;
        System.out.println("the process took: " + time/1000 + " ms");

        System.out.println("how many students?");
        size = scan.nextInt();
        Process obj3 = new Process(size); //object for 1000 students
        obj3.storeData();
        System.out.println(obj3.invalid +" invalid data");
        start = System.nanoTime();
        obj3.sort(0, obj1.index - 1);
        end = System.nanoTime();
        time = end - start;
        System.out.println("the process took: " + time/1000 + " ms");

        System.out.println("how many students?");
        size = scan.nextInt();
        Process obj4 = new Process(size);//object for 10000 students
        obj4.storeData();
        System.out.println(obj4.invalid +" invalid data");
        start = System.nanoTime();
        obj4.sort(0, obj1.index - 1);
        end = System.nanoTime();
        time = end - start;
        System.out.println("the process took: " + time/1000 + " ms");


    }
}
