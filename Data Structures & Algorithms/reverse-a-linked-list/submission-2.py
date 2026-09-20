# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return head
        prev = head
        head = head.next
        prev.next = None
        while(head is not None):
            temp = head.next
            head.next = prev
            prev = head
            head = temp
        return prev