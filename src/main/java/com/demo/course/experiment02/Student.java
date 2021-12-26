package com.demo.course.experiment02;

/**
 * author: nitaotao
 * date: 2021/12/26 12:21
 * version: 1.0
 * description: todo
 */
public class Student {
    private int id; //学号
    private String name; //姓名
    private double math; //数学成绩
    private double english; //英语成绩
    private double history; //历史成绩

    //无参构造
    public Student() {
    }

    //带参构造
    public Student(Student student) {
        this.id = student.id;
        this.name = student.name;
        this.english = student.english;
        this.math = student.math;
        this.history = student.history;
    }

    /**
     * 打印学生
     */
    public void print() {
        System.out.print("id:" + id);
        System.out.print("  name:" + name);
        System.out.print("  math:" + math);
        System.out.print("  english:" + english);
        System.out.println("  history:" + history);
    }

    /**
     * 平均值
     *
     * @return 返回三科平均值
     */
    public double mean() {
        return (math + english + history) / 3;
    }

    /**
     * 最大值
     *
     * @return 返回三科最大值
     */
    public double max() {
        return (math > english ? math : english) > history ? (math > english ? math : english) : history;
    }

    /**
     * 最小值
     *
     * @return 返回三科最小值
     */
    public double min() {
        return (math < english ? math : english) < history ? (math < english ? math : english) : history;
    }

    /**
     * 和其他学生平均分比较
     *
     * @param student
     * @return 是否比其他学生平均分低
     */
    public boolean isMeanLower(Student student) {
        return this.mean() < student.mean();
    }

    /**
     * 和其他学生最高分比较
     *
     * @param student
     * @return 是否比其他学生最高分低
     */
    public boolean isMaxLower(Student student) {
        return this.max() < student.max();
    }

    /**
     * 和其他学生最第分比较
     *
     * @param student
     * @return 是否比其他学生最低分低
     */
    public boolean isMinLower(Student student) {
        return this.min() < student.min();
    }

    /**
     * 返回三科差异
     *
     * @param student
     * @return 返回当前学生与指定学生各科差值
     */
    public double[] difference(Student student) {
        double[] difference = new double[3];
        difference[0] = math - student.math;
        difference[1] = english - student.english;
        difference[2] = history - student.history;
        return difference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public static void main(String[] args) {
        Student tom = new Student();
        tom.setId(101);
        tom.setName("tom");
        tom.setMath(99.5);
        tom.setEnglish(76.5);
        tom.setHistory(87);

        Student jerry = new Student(tom);
        jerry.setId(102);
        jerry.setName("jeery");
        jerry.setMath(83);
        jerry.setEnglish(92.5);
        jerry.setHistory(77.5);

        System.out.println("tom的信息");
        tom.print();
        System.out.print("tom的平均成绩：");
        System.out.printf("%.2f", tom.mean());
        System.out.print("  tom的最高成绩：");
        System.out.printf("%.2f", tom.max());
        System.out.print("  tom的最低成绩：");
        System.out.printf("%.2f", tom.min());
        System.out.println();
        System.out.println("jerry的信息");
        jerry.print();
        System.out.print("jerry的平均成绩：");
        System.out.printf("%.2f", jerry.mean());
        System.out.print("  jerry的最高成绩：");
        System.out.printf("%.2f", jerry.max());
        System.out.print("  jerry的最低成绩：");
        System.out.printf("%.2f", jerry.min());
        System.out.println();
        System.out.println("tom和jeery相比");
        System.out.println("tom平均分比jerry低:" + tom.isMeanLower(jerry));
        System.out.println("tom最高分比jerry低:" + tom.isMaxLower(jerry));
        System.out.println("tom最低分比jerry低:" + tom.isMinLower(jerry));
        double[] difference = tom.difference(jerry);
        System.out.print("tom和jerry比，三科差异分别为:");
        for (int i = 0; i < difference.length; i++) {
            System.out.print(difference[i] + " ");
        }
    }
}
