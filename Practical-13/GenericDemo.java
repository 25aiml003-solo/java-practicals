class Box<T> {
    private T value;
    void set(T value){this.value=value;}
    T get(){return value;}
}
class Pair<A,B> {
    private final A first;private final B second;
    Pair(A first,B second){this.first=first;this.second=second;}
    public String toString(){return first+" / "+second;}
}
public class GenericDemo {
    static <T>T first(T[] values){
        if(values.length==0)throw new IllegalArgumentException("Empty array");
        return values[0];
    }
    public static void main(String[] args){
        Box<Integer> number=new Box<>();number.set(100);
        Box<String> text=new Box<>();text.set("Java Generics");
        Pair<String,Integer> student=new Pair<>("Asha",20);
        String[] names={"Asha","Ravi"};
        System.out.println(number.get());System.out.println(text.get());
        System.out.println(student);System.out.println(first(names));
    }
}
