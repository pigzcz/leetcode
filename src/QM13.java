/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-08 13:49
 * @Description:
 */
public class QM13 {
    public int movingCount(int m, int n, int k) {
        int count =0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (canArrive(i,j,k)){
                    count++;
                }
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
}
