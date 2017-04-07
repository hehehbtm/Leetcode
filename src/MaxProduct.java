import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by admin on 2017/4/6.
 */
public class MaxProduct {
//    ����ԭ��  û�п��Ǹ����˻�Ϊ����
//    ���ַ������Խ����������������
    public int maxProduct1(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1]*nums[i]>nums[i]?dp[i-1]*nums[i]:nums[i];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]>res)
                res = dp[i];
        }
        return res;
    }
//     ��Ϊ���ڸ���Ϊ���������������Ҫͬʱ������Сֵ�����ֵ
//    dp�ĵ��ƹ�ʽΪ��
//    num[i]<0   max[i] = min[i-1]*num[i]  min[i-1]>0ʱ��max = num[i]
//    num[i]>0   max[i] = max[i-1]*num[i]
    public int maxProduct(int[] nums){
        if (nums==null||nums.length==0)
            return 0;
        int tmax = nums[0];
        int tmin = nums[0];
        int res = tmax;
        for (int i = 1; i < nums.length; i++) {
            int max = tmax ,min = tmin;
//            ���Ƶĸ��¹�ʽ
            tmax = Math.max(Math.max(nums[i],nums[i]*tmax),nums[i]*tmin);
            tmin = Math.min(Math.min(nums[i],nums[i]*tmax),nums[i]*tmin);
            res = Math.max(tmax,res);
        }
        return res;
    }
}
