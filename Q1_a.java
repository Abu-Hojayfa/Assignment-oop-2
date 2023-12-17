interface RA{
    String ROLE = "research assistant";
    void conductResearch();
}
interface TA{
    String ROLE = "teaching assistant";
    void assistProfessor();
}
abstract class student{
    String firstName, lastName,  studentID;
    int age;
    abstract void register();
    void display(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(studentID);
        System.out.println(age);
    }
}

class  UG_SuperStudent  extends student  implements RA ,TA{

    String professor,  research;
    int salary;
    @Override
    void register() {
        System.out.println("okay");
    }

    @Override
    public void conductResearch() {
        System.out.println("research: "+ research);
    }

    @Override
    public void assistProfessor() {
        System.out.println("professor: "+ professor);
    }
   public void display(){
       System.out.println(firstName);
       System.out.println(lastName);
       System.out.println(studentID);
       System.out.println(age);
       System.out.println(salary);
   }
}

public class Q1_a {
    public static void main(String[] args) {

    }
}
