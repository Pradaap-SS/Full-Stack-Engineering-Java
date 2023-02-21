import java.util.*;
public class Student
{
    protected int studentId;
    protected String name;
    protected int departmentId;
    protected String gender;
    protected String phone;
    
    public void setStudentId(int id)
    {
        studentId=id;
    }
    public int getStudentId()
    {
        return studentId;
    }
    
    public void setName(String n)
    {
        name=n;
    }
    public String getName()
    {
        return name;
    }
    
    public void setDepartmentId(int did)
    {
        departmentId=did;
    }
    public int getDepartmentId()
    {
        return departmentId;
    }
    
    public void setGender(String g)
    {
        gender=g;
    }
    public String getGender()
    {
        return gender;
    }
    
    public void setPhone(String ph)
    {
        phone=ph;
    }
    public String getPhone()
    {
        return phone;
    }
}