//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* temp = head;
        if(temp->next == NULL)
            {
                head = NULL;
                return head;}
        else{
            int i = 1;
            while(temp->next!=NULL){
                temp = temp->next;
                i++;
            }
        //cout<<i<<endl;
                i = i-n;
       // cout<<i;
                if( i == 0)
                    return head->next;
                temp = head;
                 for(int k = 0; k<i-1; k++){
                     temp = temp->next;
                 }
                ListNode* deleteNode = temp->next;
                temp->next = (temp->next)->next;
                deleteNode->next = NULL;
        
            return head;
        }
    }
    
};
