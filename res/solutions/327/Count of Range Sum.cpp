#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#define ordered_set tree<pair<long long,int>,null_type,less<pair<long long,int>>,rb_tree_tag,tree_order_statistics_node_update>
using namespace __gnu_pbds;

class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        int ans=0;
        int n=nums.size();
        vector<long long> prefixSum(n);
        prefixSum[0]=nums[0];
        for (int i=1; i<n; i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        ordered_set os;
        for (int i=n-1; i>=0; i--){
            // count how many right bounds if the left one is at position i
            // lower <= prefixSum[x]-prefixSum[i-1] <= upper
            // count how many values inside the range [lower+prefixSum[i-1], upper+prefixSum[i-1]]
            os.insert(make_pair(prefixSum[i],i));
            long long leftSum=(i-1>=0 ? prefixSum[i-1] : 0);
            long long left=lower+leftSum;
            long long right=upper+leftSum;
            ans+=os.order_of_key(make_pair(right+1,0))-os.order_of_key(make_pair(left,0));
        }
        return ans;
    }
};