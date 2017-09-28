package www.linhao007.pojo;

/**
 * Created by linhu on 17/9/28.
 */
public class User {
    private String name;
    private Long identityId;
    private Integer age;
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Long identityId) {
        this.identityId = identityId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", identityId=" + identityId +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
