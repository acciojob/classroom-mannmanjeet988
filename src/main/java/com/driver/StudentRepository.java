package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentDb = new HashMap<>();
    HashMap<String, Teacher> teachertDb = new HashMap<>();

    HashMap<String, List<String>> studentTeacherPair = new HashMap<>();

    public void addStudent(Student student){
        String key = student.getName();
        studentDb.put(key, student);
    }

    public void addTeacher(Teacher teacher){
        String key = teacher.getName();
        teachertDb.put(key, teacher);
    }

    public void addStudentTeacherPair(String student,String teacher){
        List<String> students = studentTeacherPair.get(teacher);

        if(students ==null){
            students = new ArrayList<>();
        }

        students.add(student);
        studentTeacherPair.put(teacher, students);

    }

    public List<String> getAllStudents(){
        List<String> students = new ArrayList<>();

        if(students ==null){
            students = new ArrayList<>();
        }

        for(String s : studentDb.keySet()){
            students.add(s);
        }
        return students;
    }

    public Student getStudentByName(String name){
        return studentDb.get(name);
    }

    public Teacher getTeacherByName(String name){
        return teachertDb.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return studentTeacherPair.get(teacher);
    }

    public void deleteTeacherByName(String teacher){
        for(String str : studentTeacherPair.get(teacher)){
            studentDb.remove(str);
        }

        studentTeacherPair.remove(teacher);
        teachertDb.remove(teacher);
    }

    public void deleteAllTeachers(){
        for(String teacher : teachertDb.keySet()){
            for(String str : studentTeacherPair.get(teacher)){
                studentDb.remove(str);
            }

            studentTeacherPair.remove(teacher);
            teachertDb.remove(teacher);
        }
    }

}
