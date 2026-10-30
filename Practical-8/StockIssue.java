import java.util.HashMap;
import java.util.Map;
class OutOfStockException extends Exception {
    private static final long serialVersionUID=1L;
    private final int shortfall;
    OutOfStockException(String message,int shortfall){super(message);this.shortfall=shortfall;}
    int getShortfall(){return shortfall;}
}
class InvalidQuantityException extends Exception {
    private static final long serialVersionUID=1L;
    InvalidQuantityException(String message){super(message);}
}
class Warehouse {
    private final Map<String,Integer> stock=new HashMap<>();
    Warehouse(){stock.put("Laptop",5);stock.put("Mouse",10);stock.put("Keyboard",3);}
    void issue(String item,int quantity)throws OutOfStockException,InvalidQuantityException{
        if(quantity<=0)throw new InvalidQuantityException("Quantity must be positive");
        int available=stock.getOrDefault(item,0);
        if(available<quantity)throw new OutOfStockException("Insufficient stock for "+item,quantity-available);
        stock.put(item,available-quantity);
        System.out.println("Issued "+quantity+" "+item);
    }
}
public class StockIssue {
    public static void main(String[] args){
        Warehouse warehouse=new Warehouse();
        String[][] requests={{"Laptop","2"},{"Mouse","15"},{"Keyboard","0"},{"Keyboard","2"},{"Monitor","1"}};
        for(String[] request:requests){
            try{warehouse.issue(request[0],Integer.parseInt(request[1]));}
            catch(OutOfStockException exception){System.out.println(exception.getMessage()+"; shortfall="+exception.getShortfall());}
            catch(InvalidQuantityException exception){System.out.println(exception.getMessage());}
        }
    }
}
