import java.util.Arrays;
import java.util.Collections;

/**
 * Created by admin on 2017/4/6.
 */
//  单词翻转
//    注意：单词之间可以存在多个空格
//    （1）判断是否拆分的数组元素为空
//    （2）split的参数（" +"）

public class ReverseWords {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
//            处理多个空格
            if (!strs[i].equals(""))
                sb.append(strs[i]+" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }


    public String reverseWords1(String s) {
//        开头结尾的空格去掉
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReverseWords test = new ReverseWords();
        System.out.println(test.reverseWords(" 1"));
    }
}
