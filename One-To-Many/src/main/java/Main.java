import Config.FactoryConfiguration;
import Entity.Laptop;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student=new Student();
        student.setId("11e");
        student.setName("Randika");
        student.setAddress("Medagama");


        Laptop laptop1=new Laptop();
        laptop1.setId("10111");
        laptop1.setModel("woow");
        laptop1.setStudent(student);
        Laptop laptop2=new Laptop();
        laptop2.setId("1011111");
        laptop2.setModel("woo1");
        laptop2.setStudent(student);

        List<Laptop> laptops=new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        for (Laptop laptop : laptops) {
            session.save(laptop);
        }

        transaction.commit();
        session.close();
    }
}
