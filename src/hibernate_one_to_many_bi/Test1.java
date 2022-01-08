package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Departmen;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Departmen.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Departmen dep = new Departmen("HR", 300, 1200);
            Employee emp4 = new Employee("Serg", "Koval", 100);
            Employee emp5 = new Employee("Vit1", "Koval1", 800);
//            Employee emp1 = new Employee("Zaur", "Treguloc", 800);
//            Employee emp2 = new Employee("Elrna", "Smirnova", 1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);

//            session.beginTransaction();
//
////            session.save(dep);
////            session.get(Employee.class,6).setDepartmen(null);
////            session.get(Employee.class,7).setDepartmen(null);
//            Departmen depDelete = session.get(Departmen.class, 4);
//            session.delete(depDelete);
////            System.out.println(dep);
////            System.out.println("************************************");
////            System.out.println(dep.getEmps());
//
//
//
//            session.getTransaction().commit();

            ArrayList<Employee> list = new ArrayList<>();
            dep.setEmps(list);
            dep.getEmps().add(emp4);

            session.beginTransaction();
//            session.save(emp4);
            session.save(dep);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
