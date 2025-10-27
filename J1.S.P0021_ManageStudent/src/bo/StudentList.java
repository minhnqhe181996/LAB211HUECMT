/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Course;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import utils.Validator;

/**
 *
 * @author win
 */
public class StudentList extends ArrayList<Student> {

    public StudentList(ArrayList<Student> list) {
        super(list);
    }

    public StudentList() {
        super();
    }

    public boolean isExisted(Student student) {
        for (Student students : this) {
            if (students.getId().equals(student.getId())
                    && students.getSemester().equals(student.getSemester())
                    && students.getStudentName().equals(student.getStudentName())
                    && students.getCourse().valueLanguage().equalsIgnoreCase(student.getCourse().valueLanguage())) {
                return true;
            }
        }
        return false;
    }

    public boolean create(Student student) throws Exception {
        //Kiem tra xem co truong hop them student trung ID nhung khac ten khong :)) co hoi hay vc
        StudentList search = getListStudentById(student.getId());
        if (!search.isEmpty()) {
            if (!search.get(0).getStudentName().equals(student.getStudentName())) {
                throw new Exception("This record same ID but not same name!");
            }
        }
        //Kiem tra xem ban ghi ton tai chua
        if (isExisted(student)) {
            throw new Exception("This record is existed!");
        }
        return this.add(student);
    }

    public boolean delete(String ID) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty can not update");
        }
        ArrayList<Student> list = getListStudentById(ID);
        if (list.isEmpty()) {
            throw new Exception("Can not found!!!");
        }
        StudentList result = new StudentList(list);
        System.out.println(result);
        int choice = Validator.getInt("Enter choice record you want to update:",
                "Enter 1->" + (list.size()),
                "Invalid!", 1, list.size());
        Student student = list.get(choice - 1);
        System.out.println("Your choice: "+student);
        return this.remove(student);
    }

    private int getIndexRecord(Student student) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(student)) {
                return i;
            }
        }
        return -1;
    }

    //Cap nhat semester va course cho ban ghi
    public void update(Student student) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty can not update");
        }
        String newSemester = Validator.getString("Enter Semester: ", "Invalid!", "^(Spring|Summer|Fall)\\d{4}$");
        Course newCourse = Course.
                getLanguage(Validator.getInt("Only three courses:\n"
                        + "\t1-Java\n"
                        + "\t2-.Net\n"
                        + "\t3-C/C++\n"
                        + "Enter your choice:",
                        "Please enter number 1->3", "Invalid", 1, 3));
        Student newStudentRecord = new Student(student.getId(), student.getStudentName(), newSemester, newCourse);
        if (isExisted(newStudentRecord)) {
            throw new Exception("New record be duplicate!!");
        }
        this.set(getIndexRecord(student), newStudentRecord);
    }

    public StudentList getListStudentById(String id) {
        StudentList result = new StudentList();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equalsIgnoreCase(id)) {
                result.add(this.get(i));
            }
        }
        return result;
    }

    public StudentList getListStudentByName(String name) {
        StudentList result = new StudentList();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(this.get(i));
            }
        }
        return result;
    }

    public void sortStudentsByName() {
        Collections.sort(this);
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return null;
        }
        sortStudentsByName();
        String str = String.format("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name",
                "Semester", "Course Name");
        for (int i = 0; i < this.size(); i++) {
            str += String.format("|%5s|%15s|%10s|%15s|\n", i + 1,
                    this.get(i).getStudentName(),
                    this.get(i).getSemester(),
                    this.get(i).getCourse().valueLanguage());
        }
        return str;
    }

    private HashMap<String, Integer> generateReport() {
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student student : this) {
            String key = student.getId() + "#" + student.getStudentName() + "#" + student.getCourse().valueLanguage();
            reports.put(key, reports.getOrDefault(key, 0) + 1);
        }
        return reports;
    }

    public String report() {
        if (this.isEmpty()) {
            return null;
        }
        HashMap<String, Integer> reports = generateReport();
        String str = String.format("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name", "Course", "Total of Course");
        int count = 1;
        for (String key : reports.keySet()) {
            String[] parts = key.split("#");
            String studentName = parts[1];
            String course = parts[2];
            int total = reports.get(key);
            str += String.format("|%5s|%15s|%10s|%15s|\n", count++, studentName, course, total);
        }
        return str;
    }
}
