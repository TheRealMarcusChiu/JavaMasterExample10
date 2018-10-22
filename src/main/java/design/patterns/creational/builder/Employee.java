package design.patterns.creational.builder;

public class Employee {

    private Integer id;
    private String name;
    private String description;
    private String comment;

    public static class Builder {
        // required
        private Integer id;
        private String name;

        // optional
        private String description;
        private String comment;

        public Builder(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Employee build() {
            Employee e = new Employee();
            e.id = this.id;
            e.name = this.name;
            e.description = this.description;
            e.comment = comment;
            return e;
        }
    }
}
