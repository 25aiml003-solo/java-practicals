import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface NotBlank {}
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface MaxLength { int value(); }
class SignupForm {
    @NotBlank @MaxLength(20) String name;
    @NotBlank @MaxLength(30) String email;
    @NotBlank @MaxLength(15) String password;
    SignupForm(String name,String email,String password){this.name=name;this.email=email;this.password=password;}
}
class FormChecker {
    static List<String> validate(Object object) {
        List<String> errors=new ArrayList<>();
        for(Field field:object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                Object raw=field.get(object); String value=raw==null?"":raw.toString();
                if(field.isAnnotationPresent(NotBlank.class)&&value.isBlank()) errors.add(field.getName()+" must not be blank");
                MaxLength limit=field.getAnnotation(MaxLength.class);
                if(limit!=null&&value.length()>limit.value()) errors.add(field.getName()+" exceeds "+limit.value()+" characters");
            } catch(IllegalAccessException exception){errors.add("Cannot read "+field.getName());}
        }
        return errors;
    }
}
public class FormValidator {
    public static void main(String[] args){
        try(Scanner input=new Scanner(System.in)){
            System.out.print("Name: ");String name=input.nextLine();
            System.out.print("Email: ");String email=input.nextLine();
            System.out.print("Password: ");String password=input.nextLine();
            List<String> errors=FormChecker.validate(new SignupForm(name,email,password));
            if(errors.isEmpty())System.out.println("Form is valid.");
            else errors.forEach(System.out::println);
        }
    }
}
