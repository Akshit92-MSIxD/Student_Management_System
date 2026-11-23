package com.akshit.studentmanagementsystem.service;

import com.akshit.studentmanagementsystem.model.Department;
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

       // Cascading


    // Cascade Persist (propagate persist operation to associated entity :)
    // make sure you set cascade = CascadeType.PERSIST in student model
    @Transactional
    public void testCascadePersist(){

        Student student = new Student();

        student.setName("Mihir Gupta");
        student.setEmail("mihir@gmail.com");
        student.setAge(25);
        student.setCity("Gorakhpur");

        Department department = new Department();

        department.setName("Artificial Intelligence");

        student.setDepartment(department);

        System.out.println("Before Persist Student : "+entityManager.contains(student));
        System.out.println("Before Persist Department : "+entityManager.contains(department));

        entityManager.persist(student);

        System.out.println("After making student Persist -> Student : "+entityManager.contains(student));
        System.out.println("After making student Persist -> Department : "+entityManager.contains(department));


        entityManager.flush();
    }

    // Testing merge operation without or with cascade (Make sure you change this (cascade = CascadeType.?) in student model , ? can be anything except MERGE to perform "without-cascade-test" and MERGE to perform "with-cascade-test" :)

    @Transactional
    public void testMergeWithoutOrWithCascade(){

        Student student = entityManager.find(Student.class,7);

        student.getDepartment().getName(); // lazy loaded the uninitialized association department field and hibernate will put that association in the persistent context :)

        Department department = student.getDepartment(); // contains initialized Association deparment entity at this moment :)


        entityManager.detach(student);
        entityManager.detach(department);

        student.setName("Akshay Rajput");
        student.setAge(30);
        student.setCity("Rajasthan");
        student.setEmail("akshayrajput@gmail.com");

        department.setName("Cyber Security");

        System.out.println("Before merge -> Student : "+entityManager.contains(student));
        System.out.println("Before merge -> Association Department : "+entityManager.contains(department));

        Student managedStudent = entityManager.merge(student);

        System.out.println("After merge(student) -> Student : " + entityManager.contains(student));
        System.out.println("After merge(student) -> managedStudent : " + entityManager.contains(managedStudent));
        System.out.println("After merge(student) -> Association Department  : " + entityManager.contains(department));



        entityManager.flush();

    }



    // Testing remove operation without or with cascade (Make sure you change this (cascade = CascadeType.?) in student model , ? can be anything except REMOVE to perform "without-cascade-test" and REMOVE to perform "with-cascade-test" :)
    @Transactional
    public void testRemoveWithoutOrWithCascade(){

     Student student = entityManager.find(Student.class,17);

     Department department = student.getDepartment(); // contains uninitialized lazy proxy association

     // Initialize the LAZY Department association. or Lazy Loading the association department
     department.getName();

     System.out.println("===============BEFORE REMOVE================");

     System.out.println("Student managed by persistence context ? : " + entityManager.contains(student));
     System.out.println("Association Department managed by persistence context ? : " + entityManager.contains(department));


      entityManager.remove(student);


        System.out.println("===============AFTER REMOVE================");

        System.out.println("Student managed by persistence context ? : " + entityManager.contains(student));
        System.out.println("Association Department managed by persistence context ? : " + entityManager.contains(department));


        System.out.println("===============AFTER FLUSH================");
       entityManager.flush();

    }



    // Testing refresh operation without or with cascade (Make sure you change this (cascade = CascadeType.?) in student model , ? can be anything except REFRESH to perform "without-cascade-test" and REFRESH to perform "with-cascade-test" :)

    /*
     * CASCADE REFRESH:
     *
     * Refresh reloads an entity's state from the database and
     * overwrites its current in-memory state.
     *
     * Without CascadeType.REFRESH:
     * Only the Student entity is refreshed.
     * Associated Department's in-memory changes are not refreshed.
     *
     * With CascadeType.REFRESH:
     * Refresh operation propagates to the associated Department.
     * Both Student and Department are restored to their database state.
     *
     * IMPORTANT:
     * Refresh does not replace the existing managed Java object.
     * It updates the state of the existing managed instance.
     *
     * Both entities remain managed after refresh.
     */

    @Transactional

   public void testRefreshWithoutOrWithCascade(){

        Student student = entityManager.find(Student.class,9);

        Department department = student.getDepartment();

        department.getName();

        student.setName("Asmit Pepsu");
        student.setAge(1000);

        department.setName("Doodh Dahi Engineering");

        System.out.println("===============BEFORE REFRESH=====================");

        System.out.println("Student name : "+student.getName());
        System.out.println("Student age : "+student.getAge());
        System.out.println("Department name : "+department.getName());

        entityManager.refresh(student);  // overrites the current "unflushed managed student's" state with current database state of id = 9 :) or Reloads database state into a managed entity :)

        System.out.println("=================AFTER REFRESH===================");

        System.out.println("Student name : "+student.getName());
        System.out.println("Student age : "+student.getAge());
        System.out.println("Department name : "+department.getName());


        System.out.println("Student managed : " + entityManager.contains(student));
        System.out.println("Department managed : " + entityManager.contains(department));


    }




}
