package database.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Customer {
    private int customer_id;
    private String customer_name;
    public String toString(){
        return String.format("%s %s", customer_id, customer_name);
    }
}