import java.io.*;
public class SerializationDemo {
    private static final String FILE_NAME="students.dat";
    static class Student implements Serializable {
        private static final long serialVersionUID=1L;
        final int id;final String name;transient String password;
        Student(int id,String name,String password){this.id=id;this.name=name;this.password=password;}
    }
    public static void main(String[] args){
        Student[] students={new Student(1,"Asha","secret"),new Student(2,"Ravi","hidden")};
        try(ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(FILE_NAME))){output.writeObject(students);}
        catch(IOException exception){System.out.println(exception.getMessage());return;}
        try(ObjectInputStream input=new ObjectInputStream(new FileInputStream(FILE_NAME))){
            Student[] loaded=(Student[])input.readObject();
            for(Student student:loaded)System.out.println(student.id+" "+student.name+" password="+student.password);
        }catch(IOException|ClassNotFoundException exception){System.out.println(exception.getMessage());}
    }
}
