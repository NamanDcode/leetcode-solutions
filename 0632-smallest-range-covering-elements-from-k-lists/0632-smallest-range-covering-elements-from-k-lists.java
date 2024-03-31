class Solution {
    public int[] smallestRange(List<List<Integer>> nums)
    {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        PriorityQueue<Info> minHeap = new PriorityQueue<>((a,b) -> a.data- b.data);

        int k = nums.size();
        for (int i = 0; i < k; i++) {
            int element = nums.get(i).get(0);
            maxi = Math.max(maxi, element);
            minHeap.add(new Info(element, i ,0));
        }

        if(!minHeap.isEmpty()) mini = minHeap.peek().data;
        int start = mini, end = maxi;

        while(!minHeap.isEmpty())
        {
            Info temp = minHeap.poll();
            mini =temp.data;


            if(maxi - mini < end - start)
            {
                start = mini;
                end = maxi;
            }

            int n = nums.get(temp.row).size();
            if(temp.column + 1 < n)
            {
                maxi = Math.max(maxi , nums.get(temp.row).get(temp.column+1));
                minHeap.add(new Info(nums.get(temp.row).get(temp.column+1), temp.row, temp.column+1));
            }
            else break;

        }
        return new int[]{start, end};
    }
}

class Info {
    int data, row, column;

    public Info(int data, int row, int column)
    {
        this.data = data;
        this.row = row;
        this.column = column;
    }
}