package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Departmen;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            Departmen dep = new Departmen("HR", 500, 1500);
            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);

            // сохранение в таблицу департатмента и работников
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//
//            session.save(dep);
//
//            session.getTransaction().commit();

            // удаление работников
            session.beginTransaction();

            Employee employee = session.get(Employee.class,18);
            session.delete(employee);

            session.getTransaction().commit();

            // удаление департамента
//            session.beginTransaction();
//
//            Departmen departmen = session.get(Departmen.class,8);
//            session.delete(departmen);
//
//            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
