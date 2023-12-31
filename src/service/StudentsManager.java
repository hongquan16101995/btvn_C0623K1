package service;

import model.Classes;
import model.Students;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsManager {
    private final ArrayList<Students> studentList;
    private final Scanner scanner;

    public StudentsManager() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent(ClassesManager classesManager){
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Input gender: ");
        String gender = scanner.nextLine();
        System.out.println("Input avg: ");
        double avg = Double.parseDouble(scanner.nextLine());
        //-------------------------------
        // hiển thị danh sách lớp => cho ng dùng nhập id
        // lấy đối tượng id từ manager => thêm vào student
        System.out.println("Choice classes: ");
        classesManager.displayClasses();
        System.out.println("Enter id classes your choice: ");
        int idClasses = Integer.parseInt(scanner.nextLine());
        Classes classes = classesManager.findClassesById(idClasses);
        //-------------------------------
        Students students = new Students(name, age, gender, avg, classes);
        studentList.add(students);
    }

    public void displayStudent(){
        for (Students student : studentList) {
            System.out.println(student);
        }
    }

    public void displayStudentById(){
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Students students : studentList) {
            if (students.getId() == id) {
                System.out.println(students);
                break;
            }
        }
    }
    public void deleteStudent(){
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Students students = findById(id);
        if (students == null) {
            System.out.println("Not found!");
        } else {
            studentList.remove(students);
            System.out.println("Delete successfully!");
        }
    }
    public void editStudent(ClassesManager classesManager){
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Students students = findById(id);
        if (students == null) {
            System.out.println("Not found!");
        } else {
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            System.out.println("Enter new age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new gender: ");
            String gender = scanner.nextLine();
            System.out.println("Enter new avg point: ");
            double avg = Double.parseDouble(scanner.nextLine());
            //-------------------------------
            // hiển thị danh sách lớp => cho ng dùng nhập id
            // lấy đối tượng id từ manager => thêm vào student
            System.out.println("Choice new classes: ");
            classesManager.displayClasses();
            System.out.println("Enter id classes your choice: ");
            int idClasses = Integer.parseInt(scanner.nextLine());
            Classes classes = classesManager.findClassesById(idClasses);
            //-------------------------------

            students.setName(name);
            students.setAge(age);
            students.setGender(gender);
            students.setAvgPoint(avg);
            students.setClasses(classes);
            System.out.println("Edit successfully!");
        }
    }

    private Students findById(int id) {
        for (Students s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }


    public void findStudent(){
        ArrayList<Students> listFind = new ArrayList<>();
        System.out.println("Enter name: ");
        String nameSearch = scanner.nextLine();
        for (Students s : studentList) {
            if (s.getName().contains(nameSearch)) {
                listFind.add(s);
            }
        }
        if (listFind.isEmpty()) {
            System.out.println("Not exists student have this name!");
        } else {
            for (Students students : listFind) {
                System.out.println(students);
            }
        }
    }

    public void sortByAge(ComparatorAge comparatorAge) {
        studentList.sort(comparatorAge);
    }

    public void sortByAvgPoint(ComparatorAvgPoint comparatorAvgPoint) {
        studentList.sort(comparatorAvgPoint);
    }
}
