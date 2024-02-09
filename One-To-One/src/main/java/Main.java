import Config.FactoryConfiguration;
import Entity.Laptop;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Student student=new Student();
        Laptop laptop=new Laptop();
        laptop.setId("100");
        laptop.setModel("woow");

        student.setId("1112");
        student.setName("Randika");
        student.setAddress("Medagama");
    student.setLaptop(laptop);
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
       session.save(laptop);

        transaction.commit();
        session.close();
    }
}
