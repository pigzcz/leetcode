/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-12 12:59
 * @Description:
 */
public class QM1603 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        fancheng fang1 = new fancheng(start1,end1);
        fancheng fang2 = new fancheng(start2,end2);

        Fenshu[] jiaodian = jiaodian(fang1, fang2);
        if (null == jiaodian){
            return new double[]{};
        }
        if (jiaodian.length == 1){

            int[] xiao1 = start1[0]<end1[0]?start1:end1;
            int[] xda1 = start1[0]<end1[0]?end1:start1;
            int[] xiao2 = start2[0]<end2[0]?start2:end2;
            int[] xda2 = start2[0]<end2[0]?end2:start2;
            if (xiao1[0]!=xiao2[0]){
                if (xiao1[0]<xiao2[0]){
                    if (xiao2[0]<=xda1[0]){
                        return new double[]{xiao2[0],xiao2[1]};
                    }
                    return new double[]{};
                } else {
                    if (xiao1[0]<=xda2[0]){
                        return new double[]{xiao1[0],xiao1[1]};
                    }
                    return new double[]{};
                }
            } else {
                int[] yxiao1 = start1[1]<end1[1]?start1:end1;
                int[] yda1 = start1[1]<end1[1]?end1:start1;
                int[] yxiao2 = start2[1]<end2[1]?start2:end2;
                int[] yda2 = start2[1]<end2[1]?end2:end1;
                if (yxiao1[1]<yxiao2[1]){
                    if (yxiao2[1]<=yda1[1]){
                        return new double[]{yxiao2[0],yxiao2[1]};
                    }
                    return new double[]{};
                } else {
                    if (yxiao1[1]<=yda2[1]){
                        return new double[]{yxiao1[0],yxiao1[1]};
                    }
                    return new double[]{};
                }
            }
        }

        if(jiaodian.length==2){
            if (onxianduan(jiaodian,start1,end1)&&onxianduan(jiaodian,start2,end2)){
                double x1fenzi = jiaodian[0].fenzi;
                double x1fenmu = jiaodian[0].fenmu;
                double x2fenzi = jiaodian[1].fenzi;
                double x2fenmu = jiaodian[1].fenmu;
                return new double[]{x1fenzi/x1fenmu,x2fenzi/x2fenmu};
            }
            return new double[]{};
        }


        return new double[]{};
    }

    boolean onxianduan(Fenshu[] jiaodian,int[] start ,int[] end){
        int[] restart = start[0]<=end[0]?start:end;
        int[] reend = start[0]<=end[0]?end:start;
        return dayudengyu(jiaodian[0],restart[0])&&xiaoyudengyu(jiaodian[0],reend[0]);
    }


    boolean dayudengyu(Fenshu f1 ,int c){
        Fenshu f2 = new Fenshu(c);
        Fenshu jian = jian(f1, f2);
        if (jian.fenzi == 0){
            return true;
        }
        if (jian.fenzi>0){
            jian.fenzi = 1;
        } else {
            jian.fenzi = -1;
        }
        if (jian.fenmu>0){
            jian.fenmu=1;
        } else {
            jian.fenmu=-1;
        }

        return jian.fenzi/jian.fenmu>=0;
    }
    boolean xiaoyudengyu(Fenshu f1,int c){
        Fenshu f2 = new Fenshu(c);
        Fenshu jian = jian(f1, f2);
        if (jian.fenzi == 0){
            return true;
        }
        if (jian.fenzi>0){
            jian.fenzi = 1;
        } else {
            jian.fenzi = -1;
        }
        if (jian.fenmu>0){
            jian.fenmu=1;
        } else {
            jian.fenmu=-1;
        }

        return jian.fenzi/jian.fenmu<=0;
    }

    Fenshu[] jiaodian(fancheng fang1,fancheng fang2){
        Fenshu x;
        Fenshu y;
        if (!fang1.isX&&!fang2.isX){
            Fenshu jian1 = jian(fang1.a, fang2.a);

            Fenshu jian2 = jian(fang2.b, fang1.b);
            if (jian1.fenzi==0){
                if (jian2.fenzi!=0){
                    return null;
                }
                Fenshu fenshu = new Fenshu(1);
                return new Fenshu[]{fenshu};
            }
            x =chu(jian2,jian1);
            y =jia(cheng(x,fang1.a),fang1.b);
            return new Fenshu[]{x,y};
        }
        if (fang1.isX && fang2.isX){
            if (fang1.xchangshu!=fang2.xchangshu){
                return null;
            } else {
                Fenshu fenshu = new Fenshu(fang1.xchangshu);
                return new Fenshu[]{fenshu};
            }
        }
        if (fang1.isX||fang2.isX){
            fancheng xf = fang1.isX?fang1:fang2;
            fancheng nxf = fang1.isX?fang2:fang1;
            y = jia(nxf.a.chengZhengShu(xf.xchangshu),nxf.b);
            x = new Fenshu(xf.xchangshu);
            return new Fenshu[]{x,y};
        }
        return null;
    }



    class fancheng{
        Fenshu a;
        Fenshu b;
        boolean isX = false;
        int xchangshu;

        public fancheng(int[] start,int[] end) {
            if (start[0]==end[0]){
                isX = true;
                this.xchangshu = start[0];
            }
            this.a = injectA(start,end);
            Fenshu y1 = new Fenshu(start[1]);
            this.b = jian(y1,a.chengZhengShu(start[0]));
        }
        private Fenshu injectA(int[] start ,int[] end){
            Fenshu y1= new Fenshu(start[1]);
            Fenshu x1 = new Fenshu(start[0]);
            Fenshu y2 = new Fenshu(end[1]);
            Fenshu x2 = new Fenshu(end[0]);
            Fenshu jian = jian(y1, y2);
            Fenshu jian1 = jian(x1, x2);
            return chu(jian,jian1);
        }
    }

    class Fenshu{
        public long fenzi;
        public long fenmu;

        public Fenshu(long zhengshu){
            this.fenzi = zhengshu;
            this.fenmu=1;
        }

        public Fenshu(long fenzi, long fenmu) {
            this.fenzi = fenzi;
            this.fenmu = fenmu;
        }
        public Fenshu daoshu(){
            return new Fenshu(this.fenmu,this.fenzi);
        }
        public void tongzhi(long n){
            this.fenzi=this.fenzi*n;
            this.fenmu=this.fenmu*n;
        }
        public Fenshu chengZhengShu(int n){
            return new Fenshu(fenzi*n,fenmu);
        }

        public Fenshu fushu(){
            return new Fenshu(this.fenzi*(-1),this.fenmu);
        }
    }

    private Fenshu cheng(Fenshu f1,Fenshu f2){
        return new Fenshu(f1.fenzi*f2.fenzi,f1.fenmu*f2.fenmu);
    }
    private Fenshu chu(Fenshu f1,Fenshu f2){
        Fenshu daoshu = f2.daoshu();
        return cheng(f1,daoshu);
    }
    private Fenshu jia(Fenshu f1, Fenshu f2){
        long yuanF1Fenmu = f1.fenmu;
        f1.tongzhi(f2.fenmu);
        f2.tongzhi(yuanF1Fenmu);
        return new Fenshu(f1.fenzi+f2.fenzi,f1.fenmu);
    }
    private Fenshu jian(Fenshu f1, Fenshu f2){
        Fenshu f2fu = f2.fushu();
        return jia(f1,f2fu);
    }

    public static void main(String[] args) {
        QM1603 qm1603 = new QM1603();
        int[] start = new int[]{-28,63};
        int[] end = new int[]{-35,20};

        int[] start2 = new int[]{-32,36};
        int[] end2 = new int[]{-26,-18};
        double[] intersection = qm1603.intersection(start, end, start2, end2);
        System.out.println(intersection);


    }

}
