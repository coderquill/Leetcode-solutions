/*https://leetcode.com/problems/defanging-an-ip-address/*/

class Solution {
    public String defangIPaddr(String address) {
        String ans = "";
        for(int i = 0; i<address.length(); i++){
            if(address.charAt(i) == '.'){
                ans = ans+"[.]";
            }else{
                ans = ans + address.charAt(i);
            }
        }
        return ans;
    }
}
