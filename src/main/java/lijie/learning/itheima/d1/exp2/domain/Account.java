package lijie.learning.itheima.d1.exp2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class Account implements Serializable {
    @Getter@Setter
    private String name;
    @Getter@Setter
    private Integer id;
    @Getter@Setter
    private Float money;
}
