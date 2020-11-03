package org.algorithm.datastructure.custom;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @fileName: LeetCode355.java
 * @description: 设计推特
 * @author: by echo huang
 * @date: 2020/11/3 5:40 下午
 */
public class LeetCode355 {
    /**
     * Initialize your data structure here.
     */
    public LeetCode355() {

    }

    static int timestamp = 0;

    public static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    public static class User {
        private int id;
        private Set<Integer> followed;
        private Tweet head;

        public User(int userId) {
            this.id = userId;
            this.head = null;

            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            // 不可以取关自己
            if (userId != this.id)
                followed.remove(userId);
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 将新建的推文插入链表头
            // 越靠前的推文 time 值越大
            twt.next = head;
            head = twt;
        }
    }

    // 我们需要一个映射将 userId 和 User 对象对应起来
    private HashMap<Integer, User> userMap = new HashMap<>();

    /**
     * user 发表一条 tweet 动态
     */
    public void postTweet(int userId, int tweetId) {
        // 若 userId 不存在，则新建
        if (!userMap.containsKey(userId))
            userMap.put(userId, new User(userId));
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    /**
     * follower 关注 followee
     */
    public void follow(int followerId, int followeeId) {
        // 若 follower 不存在，则新建
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        // 若 followee 不存在，则新建
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * follower 取关 followee，如果 Id 不存在则什么都不做
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User flwer = userMap.get(followerId);
            flwer.unfollow(followeeId);
        }
    }

    /**
     * 返回该 user 关注的人（包括他自己）最近的动态 id，
     * 最多 10 条，而且这些动态必须按从新到旧的时间线顺序排列。
     */
    public List<Integer> getNewsFeed(int userId) {
        // 需要理解算法，见下文
        return null;
    }
}
