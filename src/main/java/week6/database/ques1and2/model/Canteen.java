package week6.database.ques1and2.model;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Canteen {
    int canteen_id;
    String canteen_name;
    String canteen_type;
    String canteen_bill;
    int canteen_empId;
}
