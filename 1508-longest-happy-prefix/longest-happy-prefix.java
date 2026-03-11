class Solution {
    public String longestPrefix(String s) {
        char str[]=s.toCharArray();
        int n=str.length;
        int arr[]=new int[n];
        int max=0,i=1;
        while(i<n){
            if(str[max]==str[i]){
                max++;
                arr[i]=max;
                i++;
            }else{
                if(max>0){
                    max=arr[max-1];
                }else{
                    arr[i]=0;
                    i++;
                }
            }
        }
        return s.substring(0,arr[n-1]);
    }
}