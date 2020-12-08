package test;

import java.util.*;


/*
      Sample Input:
          bizOwnerId: 42
          allMessages: [
              {"sender": 1,  "recipient": 42, "conversationId": 1},
              {"sender": 42, "recipient": 1,  "conversationId": 1},
              {"sender": 2,  "recipient": 42, "conversationId": 2},
              {"sender": 2,  "recipient": 42, "conversationId": 2},
              {"sender": 3,  "recipient": 88, "conversationId": 3},
              {"sender": 3,  "recipient": 42, "conversationId": 4},
          ]

      Sample Output:
          33 (Business owner 42 received three conversations total (1, 2, and 4), but only
          responded to one conversation (conversation ID 1)).
  */

public class Solution {
    public static void main(String[] args) {
        int bizOwnerId = 42;
        List<Message> allMessages = new ArrayList<>();
        allMessages.add(new Message(1, 42, 1));
        allMessages.add(new Message(42, 1, 1));
        allMessages.add(new Message(2, 42, 2));
        allMessages.add(new Message(2, 42, 2));
        allMessages.add(new Message(3, 88, 3));
        allMessages.add(new Message(3, 42, 4));

        int result = businessResponsivenessRate(bizOwnerId, allMessages);
        System.out.println(result);
    }

    public static int businessResponsivenessRate(int bizOwnerId, List<Message> allMessages) {
        // TODO: COMPLETE ME

        if(allMessages.isEmpty()) return 0;

        Map<Integer, Set<Integer>> recipientMap = new HashMap<>();
        Map<Integer, Set<Integer>> senderMap = new HashMap<>();

        for(Message m : allMessages){
            recipientMap.computeIfAbsent(m.conversationId, (integer) -> new HashSet<>()).add(m.recipient);
            senderMap.computeIfAbsent(m.conversationId, (integer) -> new HashSet<>()).add(m.sender);
        }

        double recipientCount = recipientMap.values()
                .stream()
                .flatMap(integers -> integers.stream().filter(integer -> integer == bizOwnerId))
                .count();

        double senderCount = senderMap.values()
                .stream()
                .flatMap(integers -> integers.stream().filter(integer -> integer == bizOwnerId))
                .count();

        double result = (senderCount/recipientCount) * 100;

        return (int) result;

    }

    public static List<Integer> findUsersWithOptChange(List<User> currentUserList, List<OptInChange> optInChangeLog) {
        // TODO: Complete Me!
        return new ArrayList<>();
    }
}
