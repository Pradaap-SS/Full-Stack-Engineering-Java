public class Student
{
    private int studentId;
    private String studentName,studentAddress,collegeName;
    
    public Student(int sid,String sname,String saddr)
    {
      studentId=sid;
      studentName=sname;
      studentAddress=saddr;
      collegeName="NIT";
    }
    public Student(int sid,String sname,String saddr,String scol)
    {
          studentId=sid;
      studentName=sname;
      studentAddress=saddr;
      collegeName=scol;
    }
    
    public int getStudentId()
    {
        return studentId;
    }
    
    public String getStudentName()
    {
        return studentName;
    }
    
    public String getStudentAddress()
    {
        return studentAddress;
    }
    
    public String getCollegeName()
    {
        return collegeName;
    }
    
}