import java.util.ArrayList;

class findJudgeLab {

    public static int findJudge(int n, int[][] trust) {
        ArrayList<Integer> judge = new ArrayList<Integer>(1);
        ArrayList<Integer> blackList = new ArrayList<Integer>(1);

        for (int index = 0; index < trust.length; index++) {
            // automatic blacklist for index 1 for trusting other //
            blackList.add(trust[index][0]);

            // checks for potential judges that have trusted //
            for (int k = 0; k < blackList.size(); k++)
                for (int j = 0; j < judge.size(); j++)
                    if (judge.get(j) == blackList.get(k)) {
                        judge.remove(j);
                        break;
                    }

            // adds potentiall judge //
            boolean check = false;
            for (int j = 0; j < blackList.size(); j++)
                if (blackList.get(j) == trust[index][1]) {
                    check = true;
                    break;
                }
            for (int j = 0; j < judge.size(); j++)
                if (judge.get(j) == trust[index][1]) {
                    check = true;
                    break;
                }
            if (check == false)
                judge.add(trust[index][1]);
        }
        // return //
        if (judge.size() == 0)
            return -1;
        return judge.get(0);
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
        int arr5[][] = { { 1, 2 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        int n5 = 4;
        System.out.println("Output Example 5: " + findJudge(n5, arr5) + "\n");
    }
}