//https://leetcode.com/problems/add-two-numbers/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
       ListNode* head = new ListNode(0);
        ListNode* temp = head;
        int a=0,carry=0;
        while(l1&&l2){
            a = l1->val+l2->val+carry;
            if(a>9){
                carry = 1;
                a = a%10;
            }
            temp->next = new ListNode(a);
            temp = temp->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        while(l1){
            a = l1->val+carry;
            if(a>9){
                carry = 1;
                a = a%10;
            }
            temp->next = new ListNode(a);
            temp = temp->next;
            l1 = l1->next;
            
        }
        while(l2){
            a = l2->val+carry;
            if(a>9){
                carry = 1;
                a = a%10;
            }
            temp->next = new ListNode(a);
            temp = temp->next;
            l2 = l2->next;
        }
        if(carry){
            if(a>9){
            temp->next = new ListNode(1);
            temp = temp->next;
            }
        }
        
        return head->next;

    }
};
