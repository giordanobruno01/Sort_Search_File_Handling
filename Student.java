
import java.util.Scanner;

//class to store the information of individual students
public class Student {
    private int StudentCode;
    private String StudentName;
    private String ModeOfTransport;
    private int Distance;
    private float Emission;

    // constructor to store the data
    public Student(int studentCode, String studentName, String modeOfTransport, int distance, float emission) {
        this.StudentCode = studentCode;
        this.StudentName = studentName;
        setModeOfTransport(modeOfTransport);
        this.Distance = distance;
        this.Emission = emission;
    }

    //getter and setter
    public int getStudentCode() {
        return StudentCode;
    }

    public void setStudentCode(int studentCode) {
        StudentCode = studentCode;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getModeOfTransport() {
        return ModeOfTransport;
    }

    //Part 2: Question 1
    public void setModeOfTransport(String modeOfTransport) {
        Scanner scan = new Scanner(System.in);
        try {//try block to handle invalid mode of transport errors
            if (modeOfTransport.equalsIgnoreCase("Bus") || modeOfTransport.equalsIgnoreCase("Train") || modeOfTransport.equalsIgnoreCase("Car") || modeOfTransport.equalsIgnoreCase("Motor Bike") || modeOfTransport.equalsIgnoreCase("Bike") || modeOfTransport.equalsIgnoreCase("E-scooter") || modeOfTransport.equalsIgnoreCase("Walk") || modeOfTransport.equalsIgnoreCase("E-scooter")) {
                ModeOfTransport = modeOfTransport;
            } else {
                throw new TransportException(); //throwing transport exception error
            }
        } catch (TransportException i) {// catch block with reference to the try block
            System.out.println("‘Unsupported Mode of Transport. Please correct the transportation mode by choosing from (Bus, Train, Car, Motor Bike, Bike, E-scooter, Walk)’");
            System.out.println("Provide a valid Mode of Transportation");
            ModeOfTransport = scan.next();//storing new mode of transport if invalid mode of transport is entered
        }
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    public float getEmission() {
        return Emission;
    }

    public void setEmission(float emission) {
        Emission = emission;
    }

    @Override//overriding the toString method of string class and modifying to return all the details of a student
    public String toString() {
        return "Student{" + "StudentCode=" + StudentCode + ", StudentName='" + StudentName + '\'' + ", ModeOfTransport='" + ModeOfTransport + '\'' + ", Distance=" + Distance + ", Emission=" + Emission + '}';
    }

}
