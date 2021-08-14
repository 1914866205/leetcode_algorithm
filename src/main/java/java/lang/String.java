package java.lang;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName String.java
 * @Description TODO
 * @createTime 2021年06月19日 20:09:00
 */
public class String {
    @Override
    public String toString(){
        return "hello";
    }

    public static void main(String[] args) {
        String s = new String();
//        System.out.println(s.toString());
        System.out.println(s.getClass().getClassLoader());
    }
}
