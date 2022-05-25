package chooldong.request;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

class Person {
    public String name;
    public String[] classes;
    private final String pw;
    public String id;

    public Person(String name, String[] classes, String id, String pw) {
        this.name = name;
        this.classes = classes;
        this.id = id;
        this.pw = pw;
    }

    public boolean login(String pw) {
        return Objects.equals(pw, this.pw);
    }
}

class Student extends Person {
    public Student(String name, String[] classes, String id, String pw) {
        super(name, classes, id, pw);
    }
}

class Teacher extends Person {
    public Teacher(String name, String[] classes, String id, String pw) {
        super(name, classes, id, pw);
    }
}

class Lecture {
    public String name;
    public String teacher;
    public String[] students;
    public HashMap<String, String> choolseok;
    public String code;

    public Lecture(String name, String teacher, String[] students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
        this.choolseok = new HashMap<String, String>();
        for (String student : students
        ) {
            this.choolseok.put(student, "미처리");
        }
    }
}

public class MockDB {
    public static HashMap<String, Lecture> lectures = new HashMap<String, Lecture>();
    public static HashMap<String, Person> persons = new HashMap<String, Person>();
    public MockDB() {
        String[] studentList = {"이재명", "윤석열", "안철수", "심상정"};
        String[] studentIDList = {"mrlee", "mryoon", "mrahn", "mrsshim"};
        String[][] studentLectureList = {
                {"융합프로그래밍2", "자료구조및알고리즘2", "웹프로그래밍"},
                {"융합프로그래밍2", "융합캡스톤디자인", "웹프로그래밍"},
                {"융합캡스톤디자인", "자료구조및알고리즘2", "웹프로그래밍"},
                {"융합프로그래밍2", "융합캡스톤디자인", "자료구조및알고리즘2"}};
        String[] lectureList = {"융합프로그래밍2", "융합캡스톤디자인", "자료구조및알고리즘2", "웹프로그래밍"};
        String[][] lectureStudentList =
                {{"이재명", "윤석열", "심상정"},
                {"윤석열", "안철수", "심상정"},
                {"이재명", "안철수", "심상정"},
                {"이재명", "윤석열", "안철수"}};
        String[] lectureTeacherList = {"홍길동", "홍길동", "김철수", "김철수"};
        String[] teacherList = {"홍길동", "김철수"};
        String[] teacherIDList = {"profhong", "profkim"};
        String[][] teacherLectureList = {{"융합프로그래밍2", "융합캡스톤디자인"}, {"자료구조및알고리즘2", "웹프로그래밍"}};
        String passwd = "passwd";

        for(int i=0; i < 4; i++) {
            persons.put(studentIDList[i], new Student(studentList[i], studentLectureList[i], studentIDList[i], passwd));
            lectures.put(lectureList[i], new Lecture(lectureList[i], lectureTeacherList[i], lectureStudentList[i]));
        }

        for(int i=0; i < 2; i++) {
            persons.put(teacherIDList[i], new Teacher(teacherList[i], teacherLectureList[i], teacherIDList[i], passwd));
        }
    }
}

