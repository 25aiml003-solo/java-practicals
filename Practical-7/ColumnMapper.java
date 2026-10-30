import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.Scanner;
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface Column { String name(); }
class StudentRecord {
    @Column(name="id") int id;
    @Column(name="name") String name;
    @Column(name="age") int age;
    public String toString(){return id+" | "+name+" | "+age;}
}
public class ColumnMapper {
    static void populate(Object target,String[] headers,String[] values)throws ReflectiveOperationException{
        if(headers.length!=values.length)throw new IllegalArgumentException("Header/value count differs");
        for(Field field:target.getClass().getDeclaredFields()){
            Column column=field.getAnnotation(Column.class);if(column==null)continue;
            for(int index=0;index<headers.length;index++){
                if(headers[index].trim().equalsIgnoreCase(column.name())){
                    field.setAccessible(true);String value=values[index].trim();
                    if(field.getType()==int.class)field.setInt(target,Integer.parseInt(value));
                    else field.set(target,value);
                }
            }
        }
    }
    public static void main(String[] args){
        try(Scanner input=new Scanner(System.in)){
            System.out.print("Headers (id,name,age): ");String[] headers=input.nextLine().split(",");
            System.out.print("Values: ");String[] values=input.nextLine().split(",");
            try{StudentRecord student=new StudentRecord();populate(student,headers,values);System.out.println(student);}
            catch(Exception exception){System.out.println("Mapping error: "+exception.getMessage());}
        }
    }
}
