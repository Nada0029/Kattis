import java.util.Arrays;
import java.util.Scanner;

public class IncludeScoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numContestants = sc.nextInt();
        int[] scoreBoard = {100,75,60,50,45,40,36,32,29,26,24,22,20,18,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int[][] scores = new int[numContestants][5];

        for(int k = 0; k < numContestants; k++) {
            int q = sc.nextInt();
            int p = sc.nextInt();
            int s = sc.nextInt();
            int e = sc.nextInt();
            scores[k][0] = q; scores[k][1] = p; scores[k][2] = s; scores[k][3] = e; scores[k][4] = k;
        }
        int[] value = new int[numContestants];
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        for(int i = 0; i < numContestants; i++) {
            if(i < 30) {
                int next = 1;
                int duplicate = 0;
                while(i + next < numContestants && scores[i][0] == scores[i+next][0] && scores[i][1] == scores[i+next][1] && scores[i][2] == scores[i+next][2]) {
                    duplicate++;
                    next++;
                }
                if(duplicate != 0) {
                    int sum = 0;
                    int temp = duplicate;
                    while(temp >= 0) {
                        if(i + temp < 30){ sum += scoreBoard[i+temp]; }
                        temp--;
                    } sum = (int) Math.ceil((double)sum / next); // round up;
                    temp = duplicate;
                    while(temp >= 0) {
                        value[scores[i+temp][4]] = sum + scores[i+temp][3];
                        temp--;
                    } i += duplicate;

                } else {
                    value[scores[i][4]] = scoreBoard[i] + scores[i][3];
                }
            } else {
                value[scores[i][4]] = scores[i][3];
            }
        }
        for(int l = 0; l < numContestants; l++) {
            System.out.println(value[l]);
        }
        sc.close();
    }
}