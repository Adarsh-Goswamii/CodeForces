class Solution {
    public boolean uniqueOccurrences(int[] arr)
    {
        int [] map= new int[2001];
        int [] map1= new int[1000];
        int c=0;
        for(int i=0;i<arr.length;i++)
            map[1000+arr[i]]++;
        for(int i=0;i<map.length;i++)
            map1[map[i]]++;

        for(int i=1;i<map1.length;i++)
        {
            if(map1[i]>=2 && map1[i]!=0) {
                c = 1;
                break;
            }
        }

        if(c==1)
            return false;
        else
            return true;
    }


}