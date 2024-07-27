package 第二讲;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/1456/
 *
 * 给出 n个互不相同的正整数。问存在多少个子集，使得子集中所有数的异或和是质数。
 *
 * 由于答案可能很大，请你输出对 10^9+7取模后的结果。
 */
public class _1454_异或和是质数的子集数 {
    /*
        dp[x]:来表示有多少种方法可以通过子集的异或得到结果 x。
        状态转移：
        对于每个新考虑的数字 num，更新 dp 数组。对于每个可能的异或结果 x，你可以通过
            不使用 num（保持 dp[x] 不变）   
            或使用 num（异或 num 来更新 dp[x ^ num]）来得到新的状态。
     */
    private static final int MOD = 1000000007;

    public static int countPrimeSetBits(int[] arr) {
        int maxNum = 0;
        for (int num : arr) {
            maxNum ^= num;  // 更新最大异或和
        }

        int[] dp = new int[maxNum + 1];
        dp[0] = 1;  // 空集的异或和为 0，有一种方式

        for (int num : arr) {
            for (int j = maxNum; j >= 0; j--) {
                dp[j ^ num] = (dp[j ^ num] + dp[j]) % MOD;
            }
        }

        boolean[] isPrime = sieve(maxNum);  // 获取质数表
        int result = 0;
        for (int i = 1; i <= maxNum; i++) {
            if (isPrime[i]) {
                result = (result + dp[i]) % MOD;
            }
        }

        return result;
    }

    private static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countPrimeSetBits(arr));
    }
}
