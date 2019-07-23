package medium;

/**
 * SingleNumberIII
 *
 * @author black
 * @date 2019-07-23
 */
public class SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {1,2,1,3,2,5}));
    }

    public static int[] singleNumber(int[] nums) {
        int eO = 0;
        int[] result = new int[2];
        // 1.第一次循环得到单次出现的num1^num2的结果
        for (int i = 0; i < nums.length; i++) {
            eO ^= nums[i];
        }
        // 2.将上一步得到的结果与取反+1的结果做与操作，获得最右一位2进制的位置(num1/num2中必然存在一个数字在相同位为1)
        int rightOne = eO & (~eO + 1);
        int resultFirst = 0;
        // 3.再次遍历数组，找到相同位为1的数字，进行异或，由于其他数字出现偶数次，异或结果必为0，所以最终结果是num1或num2
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightOne) != 0) {
                resultFirst ^= nums[i];
            }
        }
        // 4.将步骤3中的结果与eO进行异或，得到最后一个数字
        result[0] = resultFirst;
        result[1] = (resultFirst ^ eO);
        return result;
    }
}
