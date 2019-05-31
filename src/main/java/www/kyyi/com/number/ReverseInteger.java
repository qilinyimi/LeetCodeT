package www.kyyi.com.number;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 一个32位含符号整数，转置整数数值
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger.Solution();
        System.out.println(solution.reverse(-2147483642));
        System.out.println(solution.reverse2(-2147483642));
    }
    /**
     *
     */
    static class  Solution {
        public  int reverse(int x) {
            int rev=0;
            while(x!=0){
                int pop = x%10;
                x/=10;
                /////////最优秀的点是下面这两行
                if(rev>Integer.MAX_VALUE/10||rev==Integer.MAX_VALUE/10&&pop>7) return 0;
                if(rev<Integer.MIN_VALUE/10||rev==Integer.MIN_VALUE/10&&pop<-8) return 0;
                rev = rev*10+pop;
            }
            return rev;
        }

        public int reverse2(int x) {
            //这个处理很机智啊，，用Long接收
            long res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }

            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int)res;
            }
        }
    }
}


