class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };
        int[] preSum = new int[days.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= days.length; i++) {
            preSum[i] = preSum[i - 1] + days[i - 1];
        }

        int aliceCome = countdate(arriveAlice, preSum);
        int aliceGo = countdate(leaveAlice, preSum);
        int bobCome = countdate(arriveBob, preSum);
        int bobGo = countdate(leaveBob, preSum);

        int start = Math.max(aliceCome, bobCome);
        int end = Math.min(aliceGo, bobGo);

        if (start > end)
            return 0;

        return end - start + 1;
    }

    public int countdate(String arriveDay, int[] preSum) {

        int aanaM = Integer.parseInt(arriveDay.substring(0, 2));
        int aanaD = Integer.parseInt(arriveDay.substring(3));
        return preSum[aanaM - 1 ] + aanaD;
    }
}