import java.util.PriorityQueue;

class search {
    int min;
    int max;
    public int[] searchRange(int[] nums, int target) {
        min=nums.length-1;
        max=0;
        binarySearch(nums,target,0,nums.length-1);
        return new int[]{min,max};
    }

    public void binarySearch(int[] nums , int target, int s ,int e){
        if(s>e)return;
        int p=s+((e-s)>>1);
        if(nums[p]==target&&s==e){
            updateResult(p);
            return;
        }
        if(nums[p]==target){
            updateResult(p);
            if(nums[s]==target&&nums[e]==target){
                updateResult(s);
                updateResult(e);
                return;
            }
            if(nums[s]==target){
                updateResult(s);
                binarySearch(nums,target,p+1,e);
                return;
            }
            if(nums[e]==target){
                updateResult(e);
                binarySearch(nums,target,s,p-1);
                return;
            }
            binarySearch(nums,target,s+1,e-1);
            return;
        }
        if(nums[p]<target){
            binarySearch(nums,target,p+1,e);
            return;
        }
        if(nums[p]>target){
            binarySearch(nums,target,s,p-1);
            return;
        }
    }

    public void updateResult(int index){
        min=min<index?min:index;
        max=max>index?max:index;
    }

    public static void main(String[] args) {
        search solution = new search();
        solution.searchRange(new int[]{5,7,7,8,8,10},8);
        PriorityQueue heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

    }
}