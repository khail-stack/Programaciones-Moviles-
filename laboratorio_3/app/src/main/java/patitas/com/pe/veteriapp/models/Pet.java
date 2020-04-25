package patitas.com.pe.veteriapp.models;

public class Pet {

    private String name;
    private String race;
    private int age;
    private String sex;

    public Pet() {
    }

    public Pet(String name, String race, int age, String sex) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}

