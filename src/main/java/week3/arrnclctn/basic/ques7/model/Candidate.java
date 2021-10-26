package week3.arrnclctn.basic.ques7.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Candidate {
    int candidate_id;
    String candidate_name;
    String constituency;
    long votes;
}
