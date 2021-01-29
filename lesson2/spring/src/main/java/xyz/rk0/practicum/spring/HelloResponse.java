package xyz.rk0.practicum.spring;

public class HelloResponse {

    public final String name;
    public final int age;
    public final boolean isProfessor;

    public HelloResponse(String name, int age, boolean isProfessor) {
        this.name = name;
        this.age = age;
        this.isProfessor = isProfessor;
    }
}
