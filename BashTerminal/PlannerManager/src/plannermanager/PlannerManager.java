
package plannermanager;

/**
 * An driver program used to test out the <CODE>Array</CODE> Abstract Data Type
 * written as part of this assignment.  The user can use the commands below
 * to perform operations on <CODE>Planner</CODE> objects.
 * <dt><b>Commands:</b><dd>
 *    
 * 
    A - Add Course <Name> <Code> <Section> <Instructor> <Position>
    Adds a new course into the list.
    G - Get Course <Position>
    Displays information of a Course at the given position.
    R - Remove Course <Position>
    Removes the Course at the given position.
    P - Print Courses in Planner
    Displays all courses in the list.
    F - Filter By Department Code <Code>
    Displays courses that match the given department code.
    L - Look For Course <Name> <Code> <Section> <Instructor>
    Determines whether the course with the given attributes is in the list.
    S - Size
    Determines the number of courses in the Planner.
    B - Backup
    Creates a copy of the given Planner. Changes to the copy will not affect the original and vice versa.
    PB - Print Courses in Backup
    Displays all the courses from the backed-up list.
    RB - Revert to Backup
    Reverts the current Planner to the backed up copy.
    Q - Quit
    Terminates the program.

 * @author 
 *    Mark Paddy, SBU, 111876646
 * <dt><b>Assignment:</b><dd>
 *    Homework #1 for CSE 214, Summer 2018
 * <dt><b>Date:</b><dd>
 *    July 17th, 2018
 */
import java.util.*;
public class PlannerManager extends Planner{
    public static void main(String[] args) 
    {
    Planner newPlan = new Planner();
    Planner backPlan = new Planner();
    Scanner scantron = new Scanner(System.in);
    String input;
    do{

    
    System.out.print(
            "    A - Add Course <Name> <Code> <Section> <Instructor>"
            + " <Position>\n" +
            "    Adds a new course into the list.\n" +
            "    G - Get Course <Position>\n" +
            "    Displays information of a Course at the given position.\n" +
            "    R - Remove Course <Position>\n" +
            "    Removes the Course at the given position.\n" +
            "    P - Print Courses in Planner\n" +
            "    Displays all courses in the list.\n" +
            "    F - Filter By Department Code <Code>\n" +
            "    Displays courses that match the given department code.\n" +
            "    L - Look For Course <Name> <Code> <Section> <Instructor>\n" +
            "    Determines whether the course with the given attributes is in the list.\n" +
            "    S - Size\n" +
            "    Determines the number of courses in the Planner.\n" +
            "    B - Backup\n" +
            "    Creates a copy of the given Planner. Changes to the copy will not affect the "
                    + "original and vice versa.\n" +
            "    PB - Print Courses in Backup\n" +
            "    Displays all the courses from the backed-up list.\n" +
            "    RB - Revert to Backup\n" +
            "    Reverts the current Planner to the backed up copy.\n" +
            "    Q - Quit\n" +
            "    Terminates the program. \n");
        System.out.println("Enter Input:");
        input = scantron.nextLine();
        switch(input)
        {
            case "A":
                System.out.println("Enter Name");
                String name = scantron.nextLine();
                System.out.println("Enter department");
                String depart = scantron.nextLine();
                System.out.println("Enter Code");
                int code = scantron.nextInt();
                System.out.println("Enter Section");
                byte section = scantron.nextByte();
                System.out.println("Enter Instructor");
                scantron.nextLine();
                String Instructor = scantron.nextLine();
                System.out.println("Enter position");
                int position = scantron.nextInt();
                Course inCourse = new Course(name, depart, code,section,Instructor);
                newPlan.addCourse(inCourse,position);
                break;
            case "G":
                System.out.println("Enter position");
                int pos = scantron.nextInt();
                //calls function
                Course sR = newPlan.getCourse(pos);
                //display
                System.out.println(sR.toString());
                break;
            case "R":
                try{
                    //input
                    System.out.println("Enter the position");
                    int pos1 = scantron.nextInt();
                    //function call
                    newPlan.removeCourse(pos1);
                    //display
                    System.out.println("Course removed at position: "+pos1);
                    break;
                    }catch(IllegalArgumentException f){
                        System.out.println(f);
                        break;
                    }
                
            case "P":
                newPlan.printAllCourses();
                break;
            case "F":
                try{
                System.out.println("Enter the Department: ");
                String dFind = scantron.nextLine();
                newPlan.getCoursesbyDepartment(newPlan, dFind);
               
                }catch(NullPointerException  f){
                   System.out.println("No courses found");
                }
                    break;

            case "L":
                System.out.println("Enter Name");
                String nameL = scantron.nextLine();
                System.out.println("Enter Department");
                String departmentL = scantron.nextLine();
                System.out.println("Enter Code");
                int codeL = scantron.nextInt();
                System.out.println("Enter Section");
                Byte sectionL = scantron.nextByte();
                System.out.println("Enter Instructor");
                scantron.nextLine();
                String instructorL = scantron.nextLine();
                Course lookC = new Course(nameL,departmentL, codeL,sectionL,instructorL);
                if(newPlan.exists(lookC))
                {
                    System.out.println(lookC.toString()+" is in the list");
                }
                
                
                break;
            case "S":
                int fill = 0;
                for(int i =1;i<newPlan.size();i++)
                {
                    try{
                    if(newPlan.getCourse(i).getCode()!=0)
                    {
                        fill++;
                    }
                    }catch(NullPointerException f){
                            i++;
                            }
                        
                }
                System.out.println("Number of courses in planner is: "+ fill);

                break;
            case "B":
                backPlan = newPlan;
                System.out.println("Backup created");
                break;
            case "PB":System.out.println("Printing all courses in backup: ");
               backPlan.printAllCourses();
                break;
            case "RB":
                newPlan =backPlan;
                System.out.println("Reverted to backup");
                break;
            case"Q":
                System.out.println("Program terminating...");
                break;
            default:
                System.out.println("Invalid input");


        }
        scantron.nextLine();
    } while(!(input.equals("Q")));
    
  }
}
