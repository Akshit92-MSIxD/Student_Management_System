package com.akshit.studentmanagementsystem.service;

import com.akshit.studentmanagementsystem.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EntityLifecycleExperimentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void testTransientToPersistent(){

        Student student = new Student();

        student.setName("Lifecycle Test");
        student.setAge(24);
        student.setEmail("lifecycle@test.com");

        System.out.println("Before persist (Transient State ) : " + entityManager.contains(student));

        entityManager.persist(student);

        student.setAge(30);

        System.out.println("After persist (Persistent State) : " + entityManager.contains(student));

        entityManager.flush();

        System.out.println("After flush (Still Persistent State) :" + entityManager.contains(student));

    }

    @Transactional
    public void testPersistentToDetach1(){

        Student student = entityManager.find(Student.class,3);

        System.out.println("Before detach (Persistent State) : " + entityManager.contains(student));

        entityManager.detach(student);

        System.out.println("After detach (Detach State) : " + entityManager.contains(student));

        student.setAge(30);

        entityManager.flush();

        System.out.println("After modifying the detach entity : " + entityManager.contains(student));
    }

    @Transactional
    public void testPersistentToDetach2(){

        Student student1 = entityManager.find(Student.class,2);
        Student student2 = entityManager.find(Student.class,3);
        Student student3 = entityManager.find(Student.class,4);

        System.out.println("Before clear (Persistent State) - Student1 : " + entityManager.contains(student1));
        System.out.println("Before clear (Persistent State) - Student2 : " + entityManager.contains(student2));
        System.out.println("Before clear (Persistent State) - Student3 : " + entityManager.contains(student3));

        entityManager.clear(); // will detach every managed entity in that Persistence Context managed by Hibernate :).

        System.out.println("After clear (Detached State) - Student1 : " + entityManager.contains(student1));
        System.out.println("After clear (Detached State) - Student2 : " + entityManager.contains(student2));
        System.out.println("After clear (Detached State) - Student3 : " + entityManager.contains(student3));
    }


    @Transactional
    public void testPersistentToDetachToPersistent(){

        Student student = entityManager.find(Student.class,3);

        System.out.println("Before detach (Persistent State) - Original Student : " + entityManager.contains(student));

        entityManager.detach(student);

        System.out.println("After detach (Detached State) - Original Student : " + entityManager.contains(student));

        Student copyOfStudent = entityManager.merge(student); // copies a detached entity's state into a managed instance and returns that instance.

        System.out.println("After merge (Detach State) - Original Student : " + entityManager.contains(student));
        System.out.println("After merge (Persistent State) - Copy of Student : " + entityManager.contains(copyOfStudent));
        System.out.println("Are both objects the same? : " + (student == copyOfStudent));

        entityManager.flush();

        System.out.println("After flush (Still Detached State) - Original Student : " + entityManager.contains(student));
        System.out.println("After flush (Persistent State) - Copy of Student : " + entityManager.contains(copyOfStudent));






    }
}
