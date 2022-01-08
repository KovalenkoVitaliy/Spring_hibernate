package hibernate_many_to_many;

import hibernate_many_to_many.Entity.Child;
import hibernate_many_to_many.Entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Child.class).addAnnotatedClass(Section.class).buildSessionFactory();
        Session session = null;
                try{
//                    session =factory.getCurrentSession();
//                    Section section1 = new Section("Football");
//                    Child child1 = new Child("Vit", 6);
//                    Child child2 = new Child("Masha", 7);
//                    Child child3 = new Child("Vasya", 10);
//                    section1.addChildToSection(child1);
//                    section1.addChildToSection(child2);
//                    section1.addChildToSection(child3);
//                    session.beginTransaction();
//
//                    session.save(section1);
//
//                    session.getTransaction().commit();
//                  ***********************************
//                    session =factory.getCurrentSession();
//                    Section section1 = new Section("Volleyball");
//                    Section section2 = new Section("Chess");
//                    Section section3 = new Section("Math");
//                    Child child1 = new Child("Igor", 10);
//                    child1.addSectionToChild(section1);
//                    child1.addSectionToChild(section2);
//                    child1.addSectionToChild(section3);
//
//                    session.beginTransaction();
//
//                    session.save(child1);
//
//                    session.getTransaction().commit();
//                  ***********************************
//                    session =factory.getCurrentSession();
//
//                    session.beginTransaction();
//
//                    Section section = session.get(Section.class,2);
//                    System.out.println(section);
//                    System.out.println(section.getChildren());
//
//                    session.getTransaction().commit();

//                  ***********************************
//                    session =factory.getCurrentSession();
//                    session.beginTransaction();
//
////                    Section section = session.get(Section.class, 1);
//                    Child child = session.get(Child.class, 2);
//                    session.delete(child);
//
//                    session.getTransaction().commit();
//                  ***********************************
//                    session =factory.getCurrentSession();
//                    Section section1 = new Section("Proba");
//                    Child child1 = new Child("Ivan", 6);
//                    Child child2 = new Child("Vova", 7);
//                    section1.addChildToSection(child1);
//                    section1.addChildToSection(child2);
//                    session.beginTransaction();
//
//                    session.persist(section1);
//
//                    session.getTransaction().commit();
//                  ***********************************
                    session =factory.getCurrentSession();
                    Section section1 = new Section("Dance");
                    Child child1 = new Child("Polina", 11);
                    Child child2 = new Child("Katya", 12);
                    session.beginTransaction();

                    session.save(section1);
                    session.save(child2);
                    session.save(child1);
                    session.save(child2);
                    section1.addChildToSection(child1);
                    section1.addChildToSection(child2);

                    session.getTransaction().commit();

                } finally {
                    session.close();
                    factory.close();
                }
    }
}
