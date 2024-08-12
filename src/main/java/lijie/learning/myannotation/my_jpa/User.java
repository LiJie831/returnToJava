package lijie.learning.myannotation.my_jpa;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
}
