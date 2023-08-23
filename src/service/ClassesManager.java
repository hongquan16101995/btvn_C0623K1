package service;

import model.Classes;

import java.util.ArrayList;
import java.util.Scanner;


public class ClassesManager {
    private final ArrayList<Classes> classesList;
    private final Scanner scanner;

    public ClassesManager() {
        classesList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createClasses() {
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        Classes classes = new Classes(name);
        classesList.add(classes);
    }

    public void displayClasses() {
        for (Classes c : classesList) {
            System.out.println(c);
        }
    }

    public void editClasses() {
        System.out.println("Enter id edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        Classes classes = findClassesById(id);
        if (classes == null) {
            System.out.println("Not found!");
        } else {
            System.out.println("Input new name: ");
            String newName = scanner.nextLine();
            classes.setName(newName);
        }
    }

    public Classes findClassesById(int id) {
        for (Classes c : classesList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
