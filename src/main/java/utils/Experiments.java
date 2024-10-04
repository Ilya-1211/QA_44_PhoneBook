package utils;

public class Experiments {
    public static void main(String[] args) {
        String res = method("str1","str2");
    }
    public static <T> T method(String... per){
        return (T) per[per.length-1];
    }
}
