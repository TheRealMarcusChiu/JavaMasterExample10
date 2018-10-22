package design.patterns.builder;

public class Main {
    public static void main(String args[]) {
        Employee e1 = new Employee.Builder(1234, "Marcus Chiu")
                .withComment("hello, world!")
                .withDescription("this is the most talented guy in the entire world")
                .build();

        Employee e2 = new Employee.Builder(1235, "Erina Chiu")
                .withDescription("sister of marcus chiu")
                .build();
    }
}
