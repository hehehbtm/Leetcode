import java.math.BigDecimal;
import java.util.HashMap;

import static java.math.BigDecimal.ROUND_FLOOR;

/**
 * Created by admin on 2017/4/6.
 */
//  ƽ��ĵ�  ����ж��ٸ��㹲��
//    ���⿼�ǣ���1����ֱ���� б�ʼ����ĸ����Ϊ0  �������б����KEYֵ��
//                  �÷�ĸ��������Keyֵ �����迼�Ǵ�ֱ
//    ��2������ʱ����������
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class MaxPoints {
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length == 0||points.length==1||points.length==2)
            return points.length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int samePoint = 0;
            int vertical = 1;
            HashMap<BigDecimal,Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j!=i){
                    if (points[i].x==points[j].x&&points[i].y==points[j].y){
                        samePoint++;
                    }
                    if (points[i].x==points[j].x){
                        vertical++;
                        continue;
                    }
//                    �������ھ������⣬������BigDecimal ����߾���
//                   ����һ�������� �������ͱ�������ΪHashMap��keyֵ
                    BigDecimal k = BigDecimal.valueOf((points[i].y - points[j].y)).divide(BigDecimal.valueOf( points[i].x-points[j].x),20,ROUND_FLOOR);
                    if (map.containsKey(k)){
                        map.put(k,map.get(k)+1);
                    }else {
                        map.put(k,2);
                    }
                    result = Math.max(result,map.get(k)+samePoint);
                }
            }
            result = Math.max(result,vertical);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxPoints test = new MaxPoints();
        int[][] list = new int[][]{{0,0},{94911151,94911150},{94911152,94911151}};
        Point[] points = new Point[list.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(list[i][0],list[i][1]);
        }
        System.out.println(test.maxPoints(points));
    }
}
