import java.util.*;

/**
 * @Auther: johnson.zhu
 * @Date: 2020-04-13 08:38
 * @Description:
 */
public class Q355 {

    /** Initialize your data structure here. */
    public Q355() {

    }
    Map<Integer,Set<Integer>> selfTwitter = new HashMap<>();

    Map<Integer,Set<Integer>> allTwitter = new HashMap<>();

    Map<Integer,Set<Integer>> beiguanzhu = new HashMap<>();

    List<Integer> shunxu = new ArrayList<>();

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        shunxu.add(tweetId);
        Set<Integer> selfIds = selfTwitter.get(userId);
        if (null == selfIds){
            selfIds = new HashSet<>();
        }
        selfIds.add(tweetId);
        selfTwitter.put(userId,selfIds);
        Set<Integer> all = allTwitter.get(userId);
        if (null == all){
            all = new HashSet<>();
        }
        all.add(tweetId);
        allTwitter.put(userId,all);
        Set<Integer> guanzhus = beiguanzhu.get(userId);
        if (null!=guanzhus){
            for (Integer tmp : guanzhus){
                Set<Integer> allt = allTwitter.get(tmp);
                if (allt==null){
                    allt = new HashSet<>();
                }
                allt.add(tweetId);
                allTwitter.put(tmp,allt);
            }
        }

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> alt = allTwitter.get(userId);
        List<Integer> last10 = new ArrayList<>();


        if (null !=alt && !alt.isEmpty()){
         int index = shunxu.size()-1;
         while (index>=0){
             if (alt.contains(shunxu.get(index))){
                 last10.add(shunxu.get(index));
             }
             if (last10.size()==10){
                 break;
             }
             index--;
            }
        }
        return last10;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }
        Set<Integer> guanzhu = beiguanzhu.get(followeeId);
        if (null == guanzhu){
            guanzhu = new HashSet<>();
        }
        if (!guanzhu.contains(followerId)){
            guanzhu.add(followerId);
        } else {
            return;
        }

        beiguanzhu.put(followeeId,guanzhu);
        Set<Integer> alt = allTwitter.get(followerId);
        if (null == alt){
            alt = new HashSet<>();
        }
        Set<Integer> sef = selfTwitter.get(followeeId);
        if (null == sef){
            sef = new HashSet<>();
        }
        alt.addAll(sef);
        allTwitter.put(followerId,alt);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }
        Set<Integer> integers = beiguanzhu.get(followeeId);
        if (null == integers){
            integers = new HashSet<>();
        }
        integers.remove((Integer) followerId);
        beiguanzhu.put(followeeId,integers);
        Set<Integer> alt = allTwitter.get(followerId);
        if (null == alt){
            alt = new HashSet<>();
        }
        Set<Integer> sef = selfTwitter.get(followeeId);
        if (null == sef){
            sef = new HashSet<>();
        }
        alt.removeAll(sef);
        allTwitter.put(followerId,alt);
    }

    public static void main(String[] args) {
        Q355 q355 = new Q355();
        q355.postTweet(1,5);
        q355.getNewsFeed(1);
        q355.follow(1,2);
    }
}
