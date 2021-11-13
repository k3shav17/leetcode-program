class Solution {
    public String[] findRelativeRanks(int[] score) {
        //time complexity = O(nlog(n))
        //space complexity = O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<score.length; i++){
            map.put(score[i], i);
        }
        Queue<Integer> max_heap = new PriorityQueue<>((child, parent) -> parent - child );
        for(int value : score) max_heap.add(value);
        int count = 1;
        String[] result = new String[score.length];
        while(max_heap.size() > 0){
            int value = max_heap.poll();
            if(count == 1){
                result[map.get(value)] = "Gold Medal";
            }
            else if(count == 2){
                result[map.get(value)] = "Silver Medal";
            }
            else if(count == 3){
                result[map.get(value)] = "Bronze Medal";
            }else{
                result[map.get(value)] = count+"";
            }
            count++;
        }
        return result;
    }
}