package www.linhao007.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by linhu on 17/9/28.
 */
@Data
@ToString
@EqualsAndHashCode
public class User {
    private Long userId;
    private String name;
    private Long identityId;
    private Integer age;
    private String sex;
}
