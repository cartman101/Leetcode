public class superWasher {
    /*解题思路: 有四个洗衣机，装的衣服数为[0, 0, 11, 5]，
    最终的状态会变为[4, 4, 4, 4]，那么我们将二者做差，
    得到*[-4, -4, 7, 1]，这里负数表示当前洗衣机还需要的衣服数，
    正数表示当前洗衣机多余的衣服数。我们要做的是*要将这个差值数组每一项都变为0，
    对于第一个洗衣机来说，需要四件衣服可以从第二个洗衣机获得，
    那么就可以 把-4移给二号洗衣机，那么差值数组变为[0, -8, 7, 1]，
    此时二号洗衣机需要八件衣服，那么至少需要移动8次。
    然后二号洗衣机把这八件衣服从三号洗衣机处获得，
    那么差值数组变为[0, 0, -1, 1]，此时三号洗衣机还缺1件，
    就从四号洗衣机处获得，此时差值数组成功变为了[0, 0, 0, 0]，
    成功。那么移动的最大次数就是差值 数组中出现的绝对值最大的数字，8次 */
    public int findMinMoves(int[] machines) {
        int n = machines.length, dressTotal = 0;
        for (int m : machines) dressTotal += m;
        if (dressTotal % n != 0) return -1;

        int dressPerMachine = dressTotal / n;
        // Change the number of dresses in the machines to
        // the number of dresses to be removed from this machine
        // (could be negative)
        for (int i = 0; i < n; i++) machines[i] -= dressPerMachine;

        // currSum is a number of dresses to move at this point, 
        // maxSum is a max number of dresses to move at this point or before,
        // m is number of dresses to move out from the current machine.
        int currSum = 0, maxSum = 0, tmpRes = 0, res = 0;
        for (int m : machines) {
            currSum += m;
            maxSum = Math.max(maxSum, Math.abs(currSum));
            tmpRes = Math.max(maxSum, m);
            res = Math.max(res, tmpRes);
        }
        return res;

    }
}
