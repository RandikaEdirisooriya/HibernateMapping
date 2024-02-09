import Config.FactoryConfiguration;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {


        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

      /*  NativeQuery nativeQuery= session.createNativeQuery("Select * from Student");
        nativeQuery.addEntity(Student.class);

        List<Student> studentList=nativeQuery.list();
        for (Student s:studentList){
            System.out.println(s.getName());
        }*/
        Query query=session.createQuery("from Student where name=?1");
        query.setParameter(1,"ggggg");
        Student student= (Student) query.uniqueResult();
        System.out.println(Student.class.getName());


        Query query1 = session.createQuery("select id, name from Student");
        query1.setParameter(1,"hhhh");
      //  Objects[] objects= (o) query.uniqueResult();
        List<Object[]> studentList = query1.list();

        for (Object[] stude : studentList) {
            String id = (String) stude[0];
            String name = (String) stude[1];


            System.out.println("ID: " + id + ", Name: " + name);
        }
        transaction.commit();
        session.close();
    }
}
