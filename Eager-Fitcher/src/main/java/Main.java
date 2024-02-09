import Config.FactoryConfiguration;
import Entity.Laptop;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        // session.save(student);
       /* for (Laptop laptop : laptops) {
            session.save(laptop);*/

        Student student=session.get(Student.class,"S001");
       String student1= student.getName();
        System.out.println(student1);
        String s= student.getAddress();
        System.out.println(s);


        transaction.commit();
        session.close();
    }
}
