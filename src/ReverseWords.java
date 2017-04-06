import java.util.Arrays;
import java.util.Collections;

/**
 * Created by admin on 2017/4/6.
 */
//  ���ʷ�ת
//    ע�⣺����֮����Դ��ڶ���ո�
//    ��1���ж��Ƿ��ֵ�����Ԫ��Ϊ��
//    ��2��split�Ĳ�����" +"��

public class ReverseWords {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
//            �������ո�
            if (!strs[i].equals(""))
                sb.append(strs[i]+" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }


    public String reverseWords1(String s) {
//        ��ͷ��β�Ŀո�ȥ��
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReverseWords test = new ReverseWords();
        System.out.println(test.reverseWords(" 1"));
    }
}
