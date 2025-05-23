import java.util.*;
class Solution {
    int[][] dp;
    public int[] solution(int target) {
        // dp[i][0] : 던진 횟수
        // dp[i][1] : 싱글/불 맞춘 횟수
        // i: 점수

        dp = new int[target+1][2];
        int[] answer = new int[2];
        for(int i=0;i<=target;i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }
        dp[0][0] = 0;

        for(int i=1;i<=target;i++) {
            for(int j=1;j<=20;j++){
                // 1. 불인 경우
                if(i-50 >= 0){
                    if(dp[i][0] > dp[i-50][0]+1){ // 더 적게 던지는 경우로 갱신
                        dp[i][0] = dp[i-50][0]+1;
                        dp[i][1] = dp[i-50][1]+1;
                    }
                    else if(dp[i][0] == dp[i-50][0]+1){
                        dp[i][1] = Math.max(dp[i][1], dp[i-50][1]+1);
                    }
                }
                // 2. 싱글인 경우
                if(i-j >= 0){
                    if(dp[i][0] > dp[i-j][0]+1){ // 더 적게 던지는 경우로 갱신
                        dp[i][0] = dp[i-j][0]+1;
                        dp[i][1] = dp[i-j][1]+1;
                    }
                    else if(dp[i][0] == dp[i-j][0]+1){
                        dp[i][1] = Math.max(dp[i][1], dp[i-j][1]+1);
                    }
                }
                // 3. 더블인 경우
                if(i-2*j >= 0){
                    if(dp[i][0] > dp[i-2*j][0]+1){
                        dp[i][0] = dp[i-2*j][0]+1;
                        dp[i][1] = dp[i-2*j][1];
                    }
                }
                // 4. 트리플인 경우
                if(i-3*j >= 0){
                    if(dp[i][0] > dp[i-3*j][0]+1){
                        dp[i][0] = dp[i-3*j][0]+1;
                        dp[i][1] = dp[i-3*j][1];
                    }
                }
            }
        }
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        return answer;
    }
}