import java.io.*;
import java.util.Scanner;
public class Process {

    int index; //variable that contains the last index of the element added
    int size; //size of the array
    Student[] stude; //object array of the student type
    Student[] studeDuplicate; //duplicated array to store the data of the original array
    int invalid = 0; //variable to store the numbers of invalid data error found

    //constructor to initialise the class variables
    public Process(int size) {
        this.size = size;
        index = 0;
        stude = new Student[size];
    }

    //method to store the data from the csv file into the array
    public void storeData() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/Users/giordanobruno/IdeaProjects/CA Algorithms/src/CFP_DATA.csv"));//opening the csv file

        sc.nextLine();
        String st = "";
        while (sc.hasNextLine() && index < size) {//traveling the file

            st = sc.nextLine();//storing a single line at a time of the file
            st = st.replace("\"", "");//replacing a " with the blank
            String[] data = st.split(",");//storing the individual data from a single string to an array

            if (data[3] == "") {//if the distance is blank make it 0
                data[3] = "0";
            }
            if (validate(Integer.parseInt(data[3]))) {//validating the distance
                stude[index] = new Student(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), Float.parseFloat(data[4]));//creating a new element
                index++;
            }
        }
        sc.close();
        studeDuplicate = new Student[size];
        studeDuplicate = stude; //duplicating the array
    }

    //Part 1: Question 1
    public void sort(int left, int right) {//method to break the array in 2 parts for merge sort
        if (left < right) {
            int middle = left + (right - left) / 2; //determine the middle index for dividing
            sort(left, middle);
            sort(middle + 1, right);
            merge(left, middle, right);
        }
    }
    //Part 1: Question 1
    public void merge(int left, int middle, int right) {//merging all the divided pieces to form the sorted array
        int sizeL = middle - left + 1;
        int sizeR = right - middle;
        Student tempL[] = new Student[sizeL];
        Student tempR[] = new Student[sizeR];
        for (int i = 0; i < sizeL; i++) {
            tempL[i] = stude[left + i];
        }
        for (int i = 0; i < sizeR; i++) {
            tempR[i] = stude[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < sizeL && j < sizeR) {//loop to put the smallest element in left part of the array
            if (tempL[i].getStudentName().compareTo(tempR[j].getStudentName()) <= 0) {
                stude[k] = tempL[i];
                i++;
            } else {
                stude[k] = tempR[j];
                j++;
            }
            k++;
        }
        while (i < sizeL) {
            stude[k] = tempL[i];
            i++;
            k++;
        }
        while (j < sizeR) {
            stude[k] = tempR[j];
            j++;
            k++;
        }
    }

    public void show() {//method to display all the array elements

        for (int i = 0; i < stude.length; i++) {
            System.out.println(stude[i].toString());
        }
    }

    //Part 1: Question 3
    public void search(int id) {//method to binary search

        int left = 0;
        int right = size - 1;


        while (left <= right) {//loop to find the middle element is the element to be searched or not
            int middle = left + (right - left) / 2;//determine the middle value
            if (studeDuplicate[middle].getStudentCode() == id) {//checking if the item in the middle is the required item or not
                System.out.println("item is found\n" + studeDuplicate[middle].toString());
                return;
            } else if (studeDuplicate[middle].getStudentCode() < id) {//serching the right part of the middle index
                left = middle + 1;
            } else {//searching the left part of the middle index
                right = middle - 1;
            }
        }
        System.out.println("item not found");
    }

    //Part 2: Question 2
    public boolean validate(int distance) {//method to validate distance
        try {//try block for distance validation
            if (distance < 1 || distance > 500) {//checking if the distance is valid
                throw new DistanceException();//throwing distance exception error if the distance is inappropriate
            }
        } catch (DistanceException e) {//catch block in reference to the try block
            invalid++;//calculating the invalid number of input
            return false;
        }
        return true;
    }
}