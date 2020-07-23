public class QM13 {
    public int movingCount(int m, int n, int k) {
        if(k==0){
            return 1;
        }
        int count =0;
        int[][] flag = new int[m][n];
        count = count(0,0,count,k,flag,m,n);


        return count;
    }

    private int count(int x,int y,int count,int k,int[][]flag,int m,int n){
        if (canArrive(x,y,k)&&flag[x][y]==0){
            count++;
            flag[x][y]=1;
            if (x+1<m&&flag[x+1][y]==0){
                count = count(x+1,y,count,k,flag,m,n);
            }
            if (x-1>=0&&flag[x-1][y]==0){
                count = count(x-1,y,count,k,flag,m,n);
            }
            if (y+1<n&&flag[x][y+1]==0){
                count = count(x,y+1,count,k,flag,m,n);
            }
            if (y-1>=0&&flag[x][y-1]==0){
                count = count(x,y-1,count,k,flag,m,n);
            }
        }

        return count;

    }




    private boolean canArrive(int x,int y,int k){
        int xs = 0;
        int ys =0;

        while(x/10!=0){
            xs=xs+x%10;
            x=x/10;
        }
        xs=x%10+xs;

        while (y/10!=0){
            ys=ys+y%10;
            y=y/10;
        }
        ys=y%10+ys;
        if (xs+ys>k){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        QM13 qm13 = new QM13();
        int i = qm13.movingCount(16, 8, 4);
        System.out.println(i);
    }
}
