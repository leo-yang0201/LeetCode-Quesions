  //设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.*;

  //  public class DesignTwitter{
//      public static void main(String[] args) {
////           Solution solution = new DesignTwitter().new Solution();
//      }
          //leetcode submit region begin(Prohibit modification and deletion)
          public class Twitter {
              /**
               * 用户id和推文（单链表）的对应关系
               */
              private Map<Integer,Tweet> twitter;

              /**
               * 用户id和他关注的用户列表的对应关系
               */
              private Map<Integer, Set<Integer>> followings;

              /**
               * 全局使用的时间戳字段，用户每发布一条推文之前+1
               */
              private static int timestamp = 0;
                /**
                 * 合并k组推文用的数据结构，声明成全局变量非必需
                 */
                private static PriorityQueue<Tweet> maxHeap;

              /**
               * Initialize your data structure here.
               */
              public Twitter() {
                  followings = new HashMap<>();
                  twitter = new HashMap<>();
                  maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp );
              }

              /**
               * Compose a new tweet.
               */
              public void postTweet(int userId, int tweetId) {
                  timestamp++;
                  if (twitter.containsKey(userId)) {
                      Tweet oldHead = twitter.get(userId);
                      Tweet newHead = new Tweet(tweetId,timestamp);
                      newHead.next = oldHead;
                      twitter.put(userId,newHead);
                  } else {
                      twitter.put(userId,new Tweet(tweetId,timestamp));
                  }
              }

              /**
               * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
               */
              public List<Integer> getNewsFeed(int userId) {
                  //由于全局使用，使用之前需要清空
                  maxHeap.clear();

                  //如果自己发了推文也要算上
                  if (twitter.containsKey(userId)) {
                      maxHeap.offer(twitter.get(userId));
                  }
                  Set<Integer> followingList = followings.get(userId);
                  if (followingList != null && followingList.size() > 0) {
                      for (Integer follwingId : followingList) {
                          Tweet tweet = twitter.get(follwingId);
                          if (tweet != null) {
                              maxHeap.offer(tweet);
                          }
                      }
                  }

                  List<Integer> res = new ArrayList<>(10);
                  int count = 0;
                  while (!maxHeap.isEmpty() && count < 10) {
                      Tweet head = maxHeap.poll();
                      res.add(head.id);
                      if (head.next != null) {
                          maxHeap.offer(head.next);
                      }
                      count++;
                  }

                  return res;
              }

              /**
               * Follower follows a followee. If the operation is invalid, it should be a no-op.
               */
              public void follow(int followerId, int followeeId) {
                  if (followeeId == followerId) return;
                  //获取我自己的关注列表
                  Set<Integer> followingList = followings.get(followerId);
                  if (followingList == null) {
                      Set<Integer> init = new HashSet<>();
                      init.add(followeeId);
                      followings.put(followerId,init);
                  } else {
                      if (followingList.contains(followeeId)) {
                          return;
                      }
                      followingList.add(followeeId);
                  }
              }

              /**
               * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
               */
              public void unfollow(int followerId, int followeeId) {
                  if (followeeId == followerId) return;
                  Set<Integer> followingList = followings.get(followerId);
                  if (followingList == null) return;
                  followingList.remove(followeeId);
              }

          private class Tweet {
              private int id;
              private int timestamp;
              private Tweet next;

              public Tweet(int id, int timestamp) {
                  this.id = id;
                  this.timestamp = timestamp;
              }
          }
          }



/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

//  }