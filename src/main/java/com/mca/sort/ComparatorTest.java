package com.mca.sort;

import java.util.*;

/**
 * @ClassName ComparatorTest
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/9/24 18:14
 * @Version 1.0
 **/
public class ComparatorTest {


    public static void main(String[] args) {
        Student s1 = new Student("A", 2, 20);
        Student s2 = new Student("B", 3, 21);
        Student s3 = new Student("C", 2, 22);
        Student[] arr = {s2, s1, s3};
        Arrays.stream(arr).forEach(System.out::println);
        Arrays.sort(arr, new IdAscComparator());
        Arrays.stream(arr).forEach(System.out::println);

        //对于同age的元素，只能存后面出现的，因为哈希值相同，所以需要判断
//        TreeMap<Student,String> map = new TreeMap<>((a,b)-> a.age-b.age);
        TreeMap<Student, String> map = new TreeMap<>((a, b) -> a.age != b.age ? a.age - b.age : System.identityHashCode(a) - System.identityHashCode(b));
        map.put(s1, "1");
        map.put(s2, "3");
        map.put(s3, "3");
    }

    public static class IdAscComparator implements Comparator<Student> {
        /**
         * 任何比较器的compare方法都遵循一个统一的规范：
         * 返回负数的时候，第一个参数在第二个参数后面
         * 反正正数的时候，第一个参数在第二个参数前面
         * 返回0的时候，谁在前后无所谓
         * <p>
         * 个人总结  减号，升序就 A-B 降序就B-A
         */
        @Override
        public int compare(Student o1, Student o2) {
//            if (o1.age < o2.age) {
//                return -1;
//            } else if (o1.age > o2.age) {
//                return 1;
//            } else {
//                return 0;
//            }
//            return o1.id - o2.id;
            // 根据id从小到大，如果一样，根据年龄从大到小
            if (o1.id == o2.id) {
                return o2.age - o1.age;
            } else {
                return o1.id - o2.id;
            }
        }
    }

    public static class Student {
        String name;
        int id;
        int age;

        Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id && age == student.age && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id, age);
        }
    }

}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input name");
        String name = sc.nextLine();
        System.out.println("please input pets count");
        int n = sc.nextInt();
        String[] names = new String[n];
        int i = 0;
        while (i < n) {
            // take care of  Carriage return character is treated as character input
            sc = new Scanner(System.in);
            String petNames = sc.nextLine();
            // I also like said upstairs , ArrayList more appropriate than Array
            for (int j = 0; j < n; j++) {
                if (petNames.equals(names[j])) {
                    System.out.println("this name is repeat");
                    i--;
                    break;
                }
            }
            names[i] = petNames;
            i++;
        }
        System.out.println(name);
        for (int j = 0; j < n; j++) {
            System.out.print(names[j] + " ");
        }
    }
}


