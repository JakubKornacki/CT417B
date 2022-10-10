package org.example;
import org.joda.time.DateTime;

import java.sql.Array;
import java.util.ArrayList;
public class Main {
    // driver code
    public static void main(String[] args) {
        // dates
        DateTime d1 = new DateTime(2000,10,10,10,10);
        DateTime d2 = new DateTime(2002,10,10,10,10);
        DateTime d3 = new DateTime(2001,10,10,10,10);
        DateTime d4 = new DateTime(1990,10,10,10,10);
        DateTime d5 = new DateTime(1989,10,10,10,10);

        // course programmes
        CourseProgramme c1 = new CourseProgramme("Computer Science", null, null, d2, d3);
        CourseProgramme c2 = new CourseProgramme("Biology", null, null, d2, d3);

        //students
        Student s1 = new Student(192321,"Thomas Nomas", d3, 18, "tomasnomas", c1, null);
        Student s2 = new Student(112421,"Patrick Atrick", d1, 20, "patrickatrick", c1, null);
        Student s3 = new Student(532142,"Solome Nolome", d5, 21, "solomenolome", c2, null);
        Student s4 = new Student(876123,"Michele Elechim", d2, 23, "micheleelechhim", c2, null);

        // students for module programming
        ArrayList<Student> studentsM1 = new ArrayList<Student>();
        studentsM1.add(s1);
        studentsM1.add(s2);

        // students for biology
        ArrayList<Student> studentsM2 = new ArrayList<Student>();
        studentsM1.add(s3);
        studentsM1.add(s4);

        // list of associated courses for module 1
        ArrayList<CourseProgramme> courseProgrammeM1 = new ArrayList<CourseProgramme>();
        courseProgrammeM1.add(c1);

        // list of associated courses for module 2
        ArrayList<CourseProgramme> courseProgrammeM2 = new ArrayList<CourseProgramme>();
        courseProgrammeM2.add(c2);

        // modules
        Module m1 = new Module("Programming", studentsM1, courseProgrammeM1, null );
        Module m2 = new Module("MicroBiology", studentsM2, courseProgrammeM2, null );
        Module m3 = new Module("Networks", studentsM1, courseProgrammeM1, null );
        Module m4 = new Module("Biology", studentsM2, courseProgrammeM2, null );
        // lists of modules
        ArrayList<Module> modulesComputerScience = new ArrayList<Module>();
        ArrayList<Module> modulesBiology = new ArrayList<Module>();
        modulesComputerScience.add(m1);
        modulesComputerScience.add(m3);
        modulesBiology.add(m2);
        modulesBiology.add(m4);

        // update null reference courseprogramme - list of modules
        c1.setListOfModules(modulesComputerScience);
        c2.setListOfModules(modulesBiology);

        // update null reference courseprogramme - list of students
        c1.setListOfStudents(studentsM1);
        c2.setListOfStudents(studentsM2);

        // update null reference student - list of modules
        s1.setModules(modulesComputerScience);
        s2.setModules(modulesComputerScience);
        s3.setModules(modulesBiology);
        s4.setModules(modulesBiology);


        //lecturers
        Lecturer l1 = new Lecturer("Adam Denny", 40, d5, 123232, "adamDenny", modulesComputerScience);
        Lecturer l2 = new Lecturer("Tom Kenny", 45, d3, 512314, "tomKenny", modulesBiology);

        // update null reference - lecturers for modules
        m1.setLecturer(l1);
        m2.setLecturer(l2);
        m3.setLecturer(l1);
        m4.setLecturer(l2);

        ArrayList<CourseProgramme> courses = new ArrayList<CourseProgramme>();
        courses.add(c1);
        courses.add(c2);


        // printing out data:

        for(CourseProgramme course : courses) {
            System.out.print("Course name: ");
            System.out.println(course.getCourseName());
            System.out.print("Modules:" );
            for(Module module : course.getListOfModules()){
                System.out.println(module.getModuleName());
                System.out.print("Students: ");
                for(Student student : module.getStudents()){
                    System.out.println("Username: " + student.getUserName());
                    System.out.print("Modules: ");
                    for(Module studentModule : student.getModules()){
                        System.out.println(studentModule.getModuleName());
                    }
                    System.out.print("Course: ");
                    System.out.println(student.getCourse().getCourseName());
                }
            }
        }



    }
}