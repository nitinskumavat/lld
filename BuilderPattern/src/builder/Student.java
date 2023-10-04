package builder;

public class Student {
    private int age;
    private String name, email, batchName;

    public int getAge(int age) {
        return this.age;
    }

    public String getName(String name) {
        return this.name;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public String getBatchName(String batchName) {
        return this.batchName;
    }

    @Override
    public String toString() {
        return "Student name: " + this.name + ", age: " + this.age;
    }

    private Student(Builder b) {
        this.age = b.age;
        this.name = b.name;
        this.email = b.email;
        this.batchName = b.batchName;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int age;
        private String name, email, batchName;

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setBatchName(String batchName) {
            this.batchName = batchName;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }
}
