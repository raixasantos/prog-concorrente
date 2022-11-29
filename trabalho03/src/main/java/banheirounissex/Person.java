package banheirounissex;

public class Person {
    private Integer id;
    private char gender;
    private Long time;

    public Person() {

    }

    public Person(Integer id, char gender, Long time) {
        this.id = id;
        this.gender = gender;
        this.time = time;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
