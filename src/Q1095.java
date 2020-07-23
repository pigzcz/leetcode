public class Q1095 {

      interface MountainArray {
      public int get(int index);
      public int length();
  }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int point = findPoint(mountainArr, 0, mountainArr.length()-1);
        if (mountainArr.get(point)==target){
            return point;
        }
        int z = findZ(mountainArr, 0, point-1, target);
        if (z!=-1){
            return z;
        }
        return findJ(mountainArr,point+1,mountainArr.length()-1,target);
    }

    public int findPoint(MountainArray mountainArray,int start,int end){
          int mid = (start+end)/2;
        if(mid-1<0){
            return findPoint(mountainArray,mid+1,end);
        }
        if(mid+1>=mountainArray.length()){
            return findPoint(mountainArray,start,mid-1);
        }
          int midn = mountainArray.get(mid);
          int midd = mountainArray.get(mid+1);
          int midx = mountainArray.get(mid-1);
          if (midn>midd&&midn>midx){
              return mid;
          }
          if (midd>midn&&midd>midx){
              return findPoint(mountainArray,mid+1,end);
          }
          if (midx>midn&&midx>midd){
              return findPoint(mountainArray,start,mid-1);
          }
          return -1;
    }

    public int findZ(MountainArray mountainArray,int start,int end,int target){
        if (start>end){
            return -1;
        }
        int mid = (start+end)/2;
        int midn = mountainArray.get(mid);
        if (midn==target){
            return mid;
        }
        if (midn>target){
            return findZ(mountainArray,start,mid-1,target);
        }
        if (midn<target){
            return findZ(mountainArray,mid+1,end,target);
        }
        return -1;
    }
    public int findJ(MountainArray mountainArray,int start,int end,int target){
        if (start>end){
            return -1;
        }
        int mid = (start+end)/2;
        int midn = mountainArray.get(mid);
        if (midn==target){
            return mid;
        }
        if (midn>target){
            return findZ(mountainArray,mid+1,end,target);
        }
        if (midn<target){
            return findZ(mountainArray,start,mid-1,target);
        }
        return -1;
    }
}
