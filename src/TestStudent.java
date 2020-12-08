import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class TestStudent {
    public static void main(String[] args) throws UnsupportedEncodingException {

        // student > 70

        // List Students

//        String test = "Å...land Islands";
//        String garbage = new String(test.getBytes(), Charset.forName("ISO-8859-1"));
//        System.out.println(garbage);
//
//        for(char ch : garbage.toCharArray()){
//            System.out.println(ch);
//        }
//
//        String correct = new String(garbage.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
//        System.out.println(correct);
//
//        String test2 = "Ã...land Islands";
//        byte[] isoBytes = test2.getBytes("ISO-8859-1");
//        System.out.println(new String(isoBytes, "ISO-8859-1"));

        String temp = "Ã\u0085...";
        System.out.println(new String(temp.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8")));

        String temp2 = "Ã...";
        System.out.println(new String(temp2.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8")));

//        String encode = URLEncoder.encode(test2, "ISO-8859-1");
//        System.out.println(encode);
//
//        System.out.println(URLDecoder.decode(new String(encode.getBytes("ISO-8859-1")), "UTF-8"));


    }

    public static List<Student> resultStudent(List<Student> input){

        // Stream
        // filter marks > 70 -- intermediate
        // Collection -- terminate

        return input.stream().filter(s -> s.getMarks() > 70).collect(Collectors.toList());
    }
}
