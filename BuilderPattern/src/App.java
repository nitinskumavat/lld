import builder.Student;

public class App {
    public static void main(String[] args) throws Exception {
        Student s = Student.getBuilder()
                .setEmail("sds@test.com")
                .setAge(10)
                .setName("Nitin")
                .build();
        System.out.println(s);
    }
}
