package project1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {

    
    public static void main(String[] args) throws IOException{
        
        String line;
        
        //reads in a predefined list of courses
        Scanner in = new Scanner(Paths.get("courseList.csv"), "UTF-8");
        
        //Initialize Variables
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Course> ts = new ArrayList<Course>();
        String[] values;
        Course selectedCourse = null;
        boolean exit = false;
        
        //Read in the file
        while (in.hasNextLine() ) {
            line = in.nextLine();
                
            values = line.split("\t");
            
            //Some classes are traditional classes and have 11 fields, these are read in as TraditionalClass objects.
            if(values.length == 11){
                Course tradClass = new TraditionalClass(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10]);
                courses.add(tradClass);
            }
            
            //Some classes are online classes and only have 7 fields, these are read in as OnlineClass objects.
            else if(values.length == 7){
                Course onlineClass = new OnlineClass(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
                courses.add(onlineClass);
            }
        }
        
        //Main while loop for the menu system
        while(exit == false){
        
            //Welcome statement and user instructions
            System.out.println("Welcome to the schedule builder!\nTo begin, enter the number of the operation you would like to perform:\n1. Search Courses\n2. Register for course\n3. View Schedule\n4. Exit\nYour Choice:");
            Scanner input = new Scanner(System.in);

            String choice = input.nextLine();

            //THe following if statements handle the user's choice in the main menu.
            if(choice.equals("1")){

                System.out.println("Enter the department and course number of the class as SS NNN. (i.e CS 201)");
                choice = input.nextLine();

                for(Course course: courses){
                    if(course.getCourseNum().equals(choice))
                        System.out.println(course.toString());

                    else
                        continue;
                }
            }
            
            else if(choice.equals("2")){
                System.out.println("Enter the CRN of the course you wish the register:");
                choice = input.nextLine();

                
                //Select the chosen course
                for(Course course : courses){
                    if(course.getCRN().equals(choice)){
                        selectedCourse = course;
                    }

                    else
                        continue;
                }
                
                //Initialize the boolean for the conflict
                boolean conflict = false;
                
                //If the trial schedule is empty, there can't be a conflict
                if(ts.isEmpty())
                    conflict = false;
                
                //If the schedule has elements
                else{
                    
                    //Check each course in the trial schedule for conflicts
                    for(Course course : ts){
                        conflict = selectedCourse.conflictsWith(course);
                    }
                }
                
                //If conflict is found, report the error
                if(conflict == true)
                    System.out.println("Error:: Selected course conflicts with one or more classes in your schedule!");

                //If no conflict is found, add the course
                else if(conflict == false){
                    ts.add(selectedCourse);
                    System.out.println("Course added successfully!");
                }
                

            }

            else if(choice.equals("3")){
                for(Course course : ts){
                    System.out.println(course.toString());
                }
            }

            else if(choice.equals("4")){
                System.out.println("Goodbye!");
                exit = true;
            }

            else{
                System.out.println("Error: Input was not an acceptable option!");
            }
            
            System.out.println("\n\n\n");
        }
        }
        
}
