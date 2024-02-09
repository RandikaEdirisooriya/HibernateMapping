import Config.FactoryConfiguration;
import Entity.Laptop;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


      /*  student.setId("S001");
        student.setName("Randika");
        student.setAddress("Medagama");


        Laptop laptop1=new Laptop();
        laptop1.setId("I001");
        laptop1.setModel("Asus");
        laptop1.setStudent(student);
        Laptop laptop2=new Laptop();
        laptop2.setId("I002");
        laptop2.setModel("dell");
        laptop2.setStudent(student);

        List<Laptop> laptops=new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);*/

        Session session= FactoryConfiguration.getInstance().getSession();
      Transaction transaction=session.beginTransaction();
       // session.save(student);
       /* for (Laptop laptop : laptops) {
            session.save(laptop);*/

        Student student=session.get(Student.class,"S001");
        String student1= student.getName();
        System.out.println(student1);

        transaction.commit();
        session.close();

    }
}
