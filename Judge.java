// JOnathan Jaco //
// ID: 2051601 //

class Judge {

    public static int findJudge(int n, int[][] trust) {
        // judgeList: [specific person] [num of people that trust them] //
        int[][] judgeList = new int[n][2];

        // safety switch for n = 1 //
        if (n < 2)
            return -1;
        // safety switch for n = 2 //
        if (n < 3)
            return trust[0][1];

        // count trusts among town people//
        for (int i = 0, judgeCounter = 0; i < trust.length; i++, judgeCounter++) {

            // determines whether to add a new person to judgelist //
            boolean isInArr = false;

            // search for trusts in judgeList //
            for (int j = 0; j < judgeList.length; j++) {

                // increases num of person taht is trusted //
                if (trust[i][1] == judgeList[j][0]) {
                    judgeList[j][1]++;
                    isInArr = true;
                }

                // if a person trusts another, then that person loses //
                // ability to judge by losing a trust, //
                // thus never reaching n - 1 (becoming a judge) //
                if (trust[i][0] == judgeList[j][0]) {
                    judgeList[j][1]--;
                    isInArr = true;
                }

                // once a person reaches trust with all people and array //
                // is at final index, then that person must be a judge //
                if (judgeList[j][1] == (n - 1) && i >= (trust.length - 1))
                    return judgeList[j][0];
            }

            // adds trusted person to judge array //
            if (!isInArr) {
                judgeList[judgeCounter][0] = trust[i][1];
                judgeList[judgeCounter][1] = 1;
            }
        }

        // no judge is found //
        return -1;
    }

    public static void main(String[] args) {

        // Example 1 //
        int arr[][] = { { 1, 2 } };
        int n = 2;
        System.out.println("\nOutput Example 1: " + findJudge(n, arr) + "\n");

        // Example 2 //
        int arr2[][] = { { 1, 3 }, { 2, 3 } };
        int n2 = 3;
        System.out.println("Output Example 2: " + findJudge(n2, arr2) + "\n");

        // Example 3 //
        int arr3[][] = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        int n3 = 3;
        System.out.println("Output Example 3: " + findJudge(n3, arr3) + "\n");

        // Example 4 //
        int arr4[][] = { { 1, 2 }, { 2, 3 } };
        int n4 = 3;
        System.out.println("Output Example 4: " + findJudge(n4, arr4) + "\n");

        // Example 5 //
        int arr5[][] = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        int n5 = 4;
        System.out.println("Output Example 5: " + findJudge(n5, arr5) + "\n");
    }
}