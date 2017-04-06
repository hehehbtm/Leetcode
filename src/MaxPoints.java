import java.math.BigDecimal;
import java.util.HashMap;

import static java.math.BigDecimal.ROUND_FLOOR;

/**
 * Created by admin on 2017/4/6.
 */
//  平面的点  最多有多少个点共线
//    特殊考虑：（1）垂直的线 斜率计算分母不能为0  如果不用斜率做KEY值，
//                  用分母，分子做Key值 ，不需考虑垂直
//    （2）除法时，精度问题
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
//                    除法存在精度问题，所以用BigDecimal 来提高精度
//                   另外一个做法是 将除数和被除数作为HashMap的key值
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
