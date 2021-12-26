package com.demo.course.experiment02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: nitaotao
 * date: 2021/12/26 20:11
 * version: 1.0
 * description: todo
 */
public class StudentManage {
    /**
     * 获取所有学生指定科目的最高分数
     *
     * @param students
     * @param subject
     * @return
     */
    public static double maxOfAll(List students, String subject) {
        List<Student> studentList = students;
        double[] score = new double[studentList.size()];
        if ("math".equals(subject)) {
            for (int i = 0; i < studentList.size(); i++) {
                score[i] = studentList.get(i).getMath();
            }
        } else if ("english".equals(subject)) {
            for (int i = 0; i < studentList.size(); i++) {
                score[i] = studentList.get(i).getEnglish();
            }
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                score[i] = studentList.get(i).getHistory();
            }
        }
        Arrays.sort(score);
        return score[studentList.size() - 1];
    }

    /**
     * 获取所有学生指定科目的最小分数
     *
     * @param students
     * @param subject
     * @return
     */
    public static double minOfAll(List students, String subject) {
        List<Student> studentList = students;
        double[] score = new double[studentList.size()];
        if ("math".equals(subject)) {
            for (int i = 0; i < studentList.size(); i++) {
                score[i] = studentList.get(i).getMath();
            }
        } else if ("english".equals(subject)) {
            for (int i = 0; i < studentList.size(); i++) {
                score[i] = studentList.get(i).getEnglish();
            }
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                score[i] = studentList.get(i).getHistory();
            }
        }
        Arrays.sort(score);
        return score[0];
    }

    /**
     * 获取所有学生指定科目的平均分
     *
     * @param students
     * @param subject
     * @return
     */
    public static double meanOfAll(List students, String subject) {
        List<Student> studentList = students;
        double avgScore = 0;
        if ("math".equals(subject)) {
            for (int i = 0; i < studentList.size(); i++) {
                avgScore += studentList.get(i).getMath();
            }
        } else if ("english".equals(subject)) {
            for (int i = 0; i < studentList.size(); i++) {
                avgScore += studentList.get(i).getEnglish();
            }
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                avgScore += studentList.get(i).getHistory();
            }
        }
        return avgScore / students.size();
    }

    /**
     * 添加一个学生数据
     *
     * @param students
     * @param newStudent
     */
    public static void add(List students, Student newStudent) {
        students.add(newStudent);
    }

    /**
     * 获取指定科目分数高于指定分数的所有学生
     *
     * @param students
     * @param subject
     * @param mark
     * @return
     */
    public static List query(List students, String subject, double mark) {
        List<Student> studentList = students;
        List<Student> studentResult = new ArrayList<>();
        if ("math".equals(subject)) {
            for (int i = 0; i < students.size(); i++) {
                if (studentList.get(i).getMath() >= mark) {
                    studentResult.add(studentList.get(i));
                }
            }
        } else if ("english".equals(subject)) {
            for (int i = 0; i < students.size(); i++) {
                if (studentList.get(i).getEnglish() >= mark) {
                    studentResult.add(studentList.get(i));
                }
            }
        } else {
            for (int i = 0; i < students.size(); i++) {
                if (studentList.get(i).getHistory() >= mark) {
                    studentResult.add(studentList.get(i));
                }
            }
        }
        return studentResult;
    }

    /**
     * 获取学生id号为指定id的学生
     *
     * @param students
     * @param id
     * @return
     */
    public static Student record(List students, int id) {
        List<Student> studentList = students;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return new Student(studentList.get(i));
            }
        }
        return null;
    }

    /**
     * 获取名称为指定名称的所有学生
     *
     * @param students
     * @param name
     * @return
     */
    public static List record(List students, String name) {
        List<Student> studentList = students;
        List<Student> studentsResult = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name)) {
                studentsResult.add(new Student(studentList.get(i)));
            }
        }
        return studentsResult;
    }

    /**
     * 删除名称为指定名称的所有学生
     *
     * @param students
     * @param name
     */
    public static void remove(List students, String name) {
        List<Student> studentList = students;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name)) {
                students.remove(i);
            }
        }
    }

    /**
     * 删除指定科目分数低于指定分数的所有学生
     *
     * @param students
     * @param subject
     * @param mark
     */
    public static void remove(List students, String subject, double mark) {
        List<Student> studentList = students;
        if ("math".equals(subject)) {
            //防止删除后前面位置改变，要倒着删
            for (int i = students.size() - 1; i > -1; i--) {
                if (studentList.get(i).getMath() < mark) {
                    students.remove(studentList.get(i));
                }
            }
        } else if ("english".equals(subject)) {
            for (int i = students.size() - 1; i > -1; i--) {
                if (studentList.get(i).getEnglish() < mark) {
                    students.remove(studentList.get(i));
                }
            }
        } else {
            for (int i = students.size() - 1; i > -1; i--) {
                if (studentList.get(i).getHistory() < mark) {
                    students.remove(studentList.get(i));
                }
            }
        }
    }

    /**
     * 将id为指定id的学生的指定科目分数更新为指定分数
     *
     * @param students
     * @param subject
     * @param id
     * @param mark
     */
    public static void update(List students, String subject, int id, double mark) {
        List<Student> list = students;
        Student student;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                student = list.get(i);
                if ("math".equals(subject)) {
                    student.setMath(mark);
                } else if ("english".equals(subject)) {
                    student.setEnglish(mark);
                } else {
                    student.setHistory(mark);
                }
            }
        }
    }

    /**
     * 检查学生1中所有受试者的平均值是否大于学生2中的平均值
     *
     * @param students1
     * @param students2
     * @return
     */
    public static boolean totalGreaterThan(List students1, List students2) {
        return StudentManage.meanOfAll(students1, "math") + StudentManage.meanOfAll(students1, "english") + StudentManage.meanOfAll(students1, "history") > StudentManage.meanOfAll(students2, "math") + StudentManage.meanOfAll(students2, "english") + StudentManage.meanOfAll(students2, "history");
    }

    /**
     * 检查students1中指定科目的平均值是否大于students2中指定科目的平均值
     *
     * @param students1
     * @param students2
     * @param subject
     * @return
     */
    public static boolean subjectGreaterThan(List students1, List students2, String subject) {
        if ("math".equals(subject)) {
            return StudentManage.meanOfAll(students1, "math") > StudentManage.meanOfAll(students2, "math");
        } else if ("english".equals(subject)) {
            return StudentManage.meanOfAll(students1, "english") > StudentManage.meanOfAll(students2, "english");
        } else {
            return StudentManage.meanOfAll(students1, "history") > StudentManage.meanOfAll(students2, "history");
        }
    }

    /**
     * 获取至少有一门不及格科目的所有学生人数
     *
     * @param students
     * @return
     */
    public static int numberOfFailed(List students) {
        int count = 0;
        List<Student> list = students;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMath() < 60 || list.get(i).getHistory() < 60 || list.get(i).getEnglish() < 60) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List list804 = new ArrayList();
        Student yh = new Student();
        yh.setId(8041);
        yh.setName("杨浩");
        yh.setMath(95.5);
        yh.setEnglish(92);
        yh.setHistory(85);

        Student ntt = new Student();
        ntt.setId(8042);
        ntt.setName("倪涛涛");
        ntt.setMath(94.5);
        ntt.setEnglish(59);
        ntt.setHistory(97);

        Student zr = new Student();
        zr.setId(8033);
        zr.setName("朱瑞");
        zr.setMath(96);
        zr.setEnglish(67);
        zr.setHistory(82);

        Student jys = new Student();
        jys.setId(8034);
        jys.setName("蒋元生");
        jys.setMath(95);
        jys.setEnglish(83);
        jys.setHistory(74);

        list804.add(yh);
        list804.add(ntt);
        list804.add(zr);
        list804.add(jys);


        List list807 = new ArrayList();
        Student shf = new Student();
        shf.setId(8071);
        shf.setName("孙鹤飞");
        shf.setMath(92);
        shf.setEnglish(89.5);
        shf.setHistory(95);

        Student ymh = new Student();
        ymh.setId(8072);
        ymh.setName("郁明辉");
        ymh.setMath(99);
        ymh.setEnglish(91);
        ymh.setHistory(67);

        Student zzc = new Student();
        zzc.setId(8073);
        zzc.setName("钟志成");
        zzc.setMath(95);
        zzc.setEnglish(98.5);
        zzc.setHistory(84);

        Student lq = new Student();
        lq.setId(8074);
        lq.setName("李强");
        lq.setMath(85);
        lq.setEnglish(80);
        lq.setHistory(76);

        list807.add(shf);
        list807.add(ymh);
        list807.add(zzc);
        list807.add(lq);

        System.out.println("==========maxOfAll方法测试=========");
        System.out.println("804 english 最高分:" + StudentManage.maxOfAll(list804, "english"));
        System.out.println("==========minOfAll方法测试=========");
        System.out.println("804 english 最低分:" + StudentManage.minOfAll(list804, "english"));
        System.out.println("==========meanOfAll方法测试=========");
        System.out.print("804 history 平均分:");
        System.out.printf("%.2f", StudentManage.meanOfAll(list804, "history"));
        System.out.println();
        System.out.println("==========add方法测试=========");
        Student girl = new Student();
        girl.setId(8045);
        girl.setName("女朋友");
        girl.setEnglish(99.5);
        girl.setMath(98);
        girl.setHistory(92);
        StudentManage.add(list804, girl);
        Student newGirl = (Student) list804.get(4);
        System.out.println(newGirl.getName());
        System.out.println("==========query方法测试=========");
        List<Student> studentsHistory = StudentManage.query(list804, "history", 90);
        for (int i = 0; i < studentsHistory.size(); i++) {
            System.out.print(studentsHistory.get(i).getName() + " ");
        }
        System.out.println();
        System.out.println("==========record根据id查询方法测试=========");
        System.out.println(StudentManage.record(list804, 8042).getName());
        System.out.println("==========record根据姓名查询方法测试=========");
        List<Student> studentsRecord = StudentManage.record(list804, "倪涛涛");
        System.out.println(studentsRecord.get(0).getId());
        System.out.println("==========remove根据名字方法测试=========");
        StudentManage.remove(list804, "女朋友");
        List<Student> studentsRemove = list804;
        for (int i = 0; i < list804.size(); i++) {
            System.out.print(studentsRemove.get(i).getName() + " ");
        }
        System.out.println();
        System.out.println("==========studentsRemoveByMark方法测试=========");
        StudentManage.remove(list804, "history", 90);
        List<Student> studentsRemoveByMark = list804;
        for (int i = 0; i < list804.size(); i++) {
            System.out.print(studentsRemoveByMark.get(i).getName() + " ");
        }
        System.out.println();
        System.out.println("==========update方法测试=========");
        StudentManage.update(list804, "history", 8042, 99);
        List<Student> students = list804;
        System.out.println(students.get(0).getHistory());
        System.out.println("==========totalGreaterThan方法测试=========");
        System.out.println("list804平均成绩比list807高：" + StudentManage.totalGreaterThan(list804, list807));
        System.out.println("==========subjectGreaterThan方法测试=========");
        System.out.println("list804的history平均成绩比list807高：" + StudentManage.subjectGreaterThan(list804, list807, "history"));
        System.out.println("==========numberOfFailed方法测试=========");
        System.out.println("list804有成绩不及格人数："+StudentManage.numberOfFailed(list804));

    }

}
