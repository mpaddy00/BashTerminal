package plannermanager;


/**
 * An abstract data type meant to serve as a representation of a Planner
 * containing Courses, which have: a name, a department, a code, a section,
 * and an instructor.
 * @author 
 *  Mark Paddy SBU, 111876646
 * <dt><b>Assignment:</b><dd>
 *    Homework #1 for CSE 214, Fall 2018
 * <dt><b>Date:</b><dd>
 *    August 11, 2018
 */

public class Planner extends Course{
    /**
     * Constructs an instance of the Planner with no Course objects in it.
     * <dt><b>Postcondition:</b><dd>
     *      The planner has been initialized to a list of empty courses
     */
    final int MAX_COURSES=50;
    Course[] cHold = new Course[MAX_COURSES];
    public Planner(){
        super();
    }
    /**
     * Determines the number of courses currently in the list. 
     * <dt><b>Precondition:</b><dd>
     *      The Planner has been initialized
     * @return 
     *  number of courses in planner
     */
    public int size()
    {
        try{
            if(cHold==null||cHold.length==0)
                throw new FullPlannerException("Planner has not been initialized");
            }catch(FullPlannerException e){
            System.out.println(e);
                }
        return cHold.length;
    }
    /**
     * Adds a new Course to the <CODE>Array</CODE>.
     * @param newCourse
     * newCourse:the new course to add to the list
     * position: the position of this course on the list
     * <dt><b>Precondition:</b><dd>
     *    This <CODE>Array</CODE> has been instantiated and element is within the
     *    valid range.
     * <dt><b>Postcondition:</b><dd>
     *     This course is listed in the correct position and all courses greater
     *     are moved to a higher position.
     * @exception IllegalArgumentException
     *    Indicates position isn't valid
     * @exception FullPlannerException
     *    Indicates that there is no more room.
     */
    public void addCourse(Course newCourse,int position)
    {
         try{
                if(cHold.length==500)
                    throw new FullPlannerException("Planner is full. Unable to add course");
        }catch(FullPlannerException e){
            System.out.println(e);
        }
        
        try{
            if(position<1||position>cHold.length+1)
                throw new IllegalArgumentException("Position is not in range.");
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }
        cHold[position-1]=newCourse;
    }
    public void addCourse(Course newCourse)
    {
        this.addCourse(newCourse, this.size()-1);
    }
    /**
     * Removes course at position
     * @param position 
     *  -the position where the course will be removed from
     *  <dt><b>Precondition:</b><dd>
     *    This <CODE>Array</CODE> has been instantiated and element is within the
     *    valid range.
     * <dt><b>Postcondition:</b><dd>
     *     This course is listed in the correct position and all courses greater
     *     are moved to a higher position.
     * @exception IllegalArgumentException
     *    Indicates position isn't valid
     */
    public void removeCourse(int position)
    {
        Course empty = new Course();
        try{
            if(position<1||position>cHold.length+1)
                throw new IllegalArgumentException("Position is not in range.");
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }
        this.addCourse(empty,position);
    }
    /**
     * gets course at position
     * @param position 
     *  -the position where the course will be removed from
     *  <dt><b>Precondition:</b><dd>
     *    This <CODE>Array</CODE> has been instantiated and element is within the
     *    valid range.
     * <dt><b>Postcondition:</b><dd>
     *     This course is listed in the correct position and all courses greater
     *     are moved to a higher position.
     * @exception IllegalArgumentException
     *    Indicates position isn't valid
     */
    public Course getCourse(int position)
    {
        try{
            if(position<1||position>cHold.length)
                throw new IllegalArgumentException("Position is not in range.");
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }
        return cHold[position-1];
    }
    /**
     * Prints all courses within a specified department
     * @param planner
     *      -list of courses to search in
     * @param department 
     *      -the 3 letter department code for the course
     * <dt><b>Precondition:</b><dd>
     *    Planner has been instantiated
     * <dt><b>Postcondition:</b><dd>
     *     Displays stuff in a formatted manner
     */
    public static void filter(Planner planner, String department)
    {       
        for(int i=0;i<planner.cHold.length;i++){
            if(planner.cHold[i].getDepartment().equalsIgnoreCase(department))
                System.out.println(planner.cHold[i]);
        } 
    }
    /**
     * Checks whether a certain course is already in the list
     * @param course
     *  -course we are looking for
     * <dt><b>Precondition:</b><dd>
     *    This <CODE>Planner</CODE> and  <CODE>Planner</CODE> 
     *    has been instantiated and element is within the
     *    valid range.
     * @return 
     * true if the planner contains the course, false otherwise
     */
    public boolean exists(Course course)
    {
        boolean boo = false;

        for(int i=0;i<cHold.length;i++)
        {
            try{
            if(this.cHold[i].getCode()==course.getCode()
                    &&this.cHold[i].getDepartment().equals(course.getDepartment())
                    &&this.cHold[i].getInstructor().equals(course.getInstructor())
                    &&this.cHold[i].getName().equals(course.getName())
                    &&this.cHold[i].getSection()==course.getSection())
                {
                    boo=true;
                    break;

            }
            }catch(NullPointerException e){
                i++;
            }
        }
        return boo;
    }
    public Planner(Planner c)
    {
        
        for(int i=0;i<cHold.length;i++)
        {
            c.cHold[i]=this.cHold[i];
        }
    }
    /**
     * creates a copy of planner
     * <dt><b>Precondition:</b><dd>
     *    This <CODE>Planner</CODE>
     *    has been instantiated and element is within the
     *    valid range.
     * 
     * @return 
     *  - a copy of the planner object
     */
    @Override
    public Object clone()
    {
       return this.c;
    }
    public void getCoursesbyDepartment(Planner originalPlan, String Department){
        try{
            if(cHold==null||cHold.length>50)
                throw new FullPlannerException("Planner has not been initialized");
        }catch(FullPlannerException e){
            System.out.println(e);
        }
        for(int i=0;i<originalPlan.size();i++)
        {
            try{
                if(originalPlan.cHold[i].getDepartment().equalsIgnoreCase(Department))
                    System.out.println(originalPlan.cHold[i]);
                }catch(NullPointerException e){
                        i++;
                }
        }
    }
    /**
     * String representation of planner object
     * @return 
     * String representation of planner object.
     */
    @Override
    public String toString(){
        String s=null;
        try{
            if(cHold==null||cHold.length==0)
                throw new FullPlannerException("Planner has not been initialized");
        }catch(FullPlannerException e){
            System.out.println(e);
        }
        for(int i = 0; i < cHold.length; i++){
	    s+=String.format("%-3d%s\n",i+1, cHold[i].toString());
        }
        return s;
    }
    /**
     * Print a table of each item in the list with position number
     * <dt><b>Precondition:</b><dd>
     *    This <CODE>Planner</CODE>
     *    has been instantiated and element is within the
     *    valid range.
     * <dt><b>Postcondition:</b><dd>
     *    displays a table
     */
    public void printAllCourses()
    {
        try{
            if(cHold==null||cHold.length==0)
                throw new FullPlannerException("Planner has not been initialized");
        }catch(FullPlannerException e){
            System.out.println(e);
        }
        for(int i = 0; i < cHold.length; i++){
            try{
            if(cHold[i].getCode()!=0)
	    System.out.printf("%-3d%s\n",i+1, cHold[i].toString());
            }catch(NullPointerException e){
                i++;
            }
        }
    }
}

