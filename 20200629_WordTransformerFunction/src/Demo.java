import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {

        Function<String, String[]> getWord = string -> string.split(" ");
        String[] words = getWord.apply("aafd Fgg gg OpO lll");

        String result = Arrays.stream(words).map(Demo::apply).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static String apply(String str) {
        Predicate<String> checkWord = s -> s.length() == 3;
        if (checkWord.test(str)) {
            return str.toUpperCase();
        }
        return str;
    }


}


//        Function<String, String> wt = string -> string.toUpperCase();
//        System.out.println(wt.apply("aafd Fgg gg OpO lll"));

        /*
        Predicate<String> s = str -> str.length() == 2;
        System.out.println(s.test("AAAFD Fgg gg OpO gg LLL"));

        Function<String, String> wt2 = string -> string.replaceFirst(String.valueOf(string.charAt(0)), "*");
        System.out.println(wt2.apply("aafd Fgg gg OpO lll"));

        Function<String, String> wt3 = string -> string.toLowerCase();
        System.out.println(wt3.apply("AAAFD Fgg gg OpO LLL"));

        Function<String, String> wt4 = string -> string.length() == 3 ? string.toUpperCase() : string;
        System.out.println(wt4.apply("aaa jbkbkjb hjk"));

        */
