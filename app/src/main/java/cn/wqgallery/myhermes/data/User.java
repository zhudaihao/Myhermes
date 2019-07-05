package cn.wqgallery.myhermes.data;

public class User {
    private String name;
    private int age;
    private String add;


    public User() {
        this.name = "";
        this.age = 0;
        this.add = "";

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", add='" + add + '\'' +
                '}';
    }
}
