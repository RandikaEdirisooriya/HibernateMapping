import Config.FactoryConfiguration;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        NativeQuery nativeQuery= session.createNativeQuery("Select * from Student");
        nativeQuery.addEntity(Student.class);

        List<Student> studentList=nativeQuery.list();
        for (Student s:studentList){
            System.out.println(s.getName());
        }

        transaction.commit();
        session.close();
    }
}
