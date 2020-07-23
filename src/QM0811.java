public class QM0811 {
    public int waysToChange(int n) {
        int[][] x = new int[4][2];
        x[0][0] = 25;
        x[1][0] =10;
        x[2][0] =5;
        x[3][0] = 1;
        x[0][1] = n/x[0][0];
        x[1][1]=n/x[1][0];
        x[2][1]=n/x[2][0];
        x[3][1]=n/x[3][0];

        int count =0;
        for (int i=0;i<=x[0][1];i++){
            for (int j=0;j<=x[1][1];j++){
                for (int k=0;k<=x[2][1];k++){
                    for (int f=0;f<=x[3][1];f++){
                        if (x[0][0]*i+x[1][0]*j+x[2][0]*k+x[3][0]*f==n){
                            count++;
                        }
                    }
                }
            }
        }
        return count;

    }
}
