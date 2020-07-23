public class QM0107 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int xyl = 0;
        if (len%2==0){
            xyl=len/2-1;
        } else {
            xyl=len/2;
        }
        for (int i=0;i<=xyl;i++){
            int bottom=i;
            int top=len-i-1;
            int n=top-bottom;
            for (int j=i;j<top;j++){

                int[] clockwise = clockwise(i, j, bottom, top, n);
                int tmp=matrix[clockwise[0]][clockwise[1]];
                matrix[clockwise[0]][clockwise[1]]=matrix[i][j];
                while (clockwise[0]!=i||clockwise[1]!=j){

                    clockwise=clockwise(clockwise[0],clockwise[1],bottom,top,n);
                    int newTmp = matrix[clockwise[0]][clockwise[1]];
                    matrix[clockwise[0]][clockwise[1]] = tmp;
                    tmp=newTmp;
                }


            }
        }

    }
    private int[] clockwise(int x,int y,int bottom,int top,int n){
        while (n-->0){
            int[] fangxiang=fangxiang(x,y,bottom,top);
            x=x+fangxiang[0];
            y=y+fangxiang[1];
        }
        int[] xy=new int[2];
        xy[0]=x;xy[1]=y;
        return xy;

    }
    private int[] fangxiang(int x,int y, int bottom,int top){

        int [] r = new int[2];
        if (bottom==top){
            r[0]=0;
            r[1]=0;
            return r;
        }
        if (x==bottom&&y>=bottom&&y<top){
            r[0]=0;r[1]=1;
            return r;
        }
        if (y==top&&x>=bottom&&x<top){
            r[0]=1;r[1]=0;
            return r;
        }
        if (x==top&&y>bottom&&y<=top){
            r[0]=0;r[1]=-1;
            return r;
        }
        if (y==bottom&&x<=top&&x>bottom){
            r[0]=-1;r[1]=0;
            return r;
        }
        return null;
    }

    public static void main(String[] args) {
        QM0107 qm0107 = new QM0107();
        int[][] x = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        qm0107.rotate(x);
        System.out.println(x);

    }
}
