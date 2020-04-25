/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannermanager;

/**
 *
 * @author T420
 */
public class Course extends Exceptions implements Cloneable{
    private String name;
    private String department;
    private int code;
    private byte section;
    private String instructor;
    Course c;

    public Course(String name, String department, int code, byte section, String
            instructor)
    {
        this.name=name;
        this.department=department;
        this.code=code;
        this.section=section;
        this.instructor=instructor;
    }
    
    public Course()
    {
        this.name="";
        this.department="";
        this.code=0;
        this.section=0;
        this.instructor="";
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDepartment(String department)
    {
        this.department=department;
    }
    public void setCode(int code)
    {
        this.code=code;
    }
    public void setSection(byte Section)
    {
        this.section=Section;
    }
    public void setInstructor(String Instructor)
    {
        this.instructor=Instructor;
    }
    public String getName()
    {
        return this.name;
    }
    public String getDepartment()
    {
        return this.department;
    }
    public int getCode()
    {
       return this.code;
    }
    public byte getSection()
    {
       return this.section;
    }
    public String getInstructor()
    {
       return this.instructor;
    }
    public Course(Course c)
    {
        this(c.getName(),c.getDepartment(),c.getCode(),c.getSection(),
                c.getInstructor());
    }
    @Override
    public Object clone()
    {
      return this.c;
    }
    public boolean equals(Object obj)
    {
         if (obj instanceof Course){
             Course sR = (Course) obj;
            return this.getCode()==(sR.getCode())
                    && this.getDepartment().equals(sR.getDepartment()) 
                    && this.getInstructor().equals(sR.getInstructor())
                    && this.getName().equals(sR.getName())
                    && this.getSection() == sR.getSection();
                    }
         return false; 
        }

    @Override
    public String toString(){
        String string = String.format("%2s%5s%5d%5d%10s", this.getName(), 
                this.getDepartment(), this.getCode(),
                this.getSection(),this.getInstructor());
        return string;
    }
    
    
}
