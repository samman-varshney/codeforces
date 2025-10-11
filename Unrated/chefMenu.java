package Unrated;
import java.util.*;

class Codechef
{   
    static int minCost;
    static int maxBenefit;
    static List<int[]> res;
    
    private static List<int[]> deepCopy(List<int[]> originalList)
    {
        
        List<int[]> copiedList = new ArrayList<>();

        for (int[] item : originalList) {
            int[] temp = new int[]{item[0], item[1], item[2]};
            copiedList.add(temp);
        }
        
        return copiedList;
    }
    
    public static int[] calc(List<int[]> list)
    {
        int cost = 0, benefit = 0;
        for(int[] x: list){
            cost += x[1];
            benefit += x[2];
        }
        return new int[]{cost, benefit};
    }
    
    public static void helper(int prev, int times, int k, int m, int[][] nums, List<int[]> list){
        if(k == 0)
        {
            int[] temp = calc(list);
            if((temp[1] > maxBenefit) || 
            (temp[0] < minCost && temp[1] == maxBenefit)){
                res = deepCopy(list);
                minCost = temp[0];
                maxBenefit = temp[1];
            }
            return;
        }
        
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i][1] <= m){
                int benefit = ((prev == i)?(times == 1?nums[i][1]/2: 0):(nums[i][1]));
                int idx = i;
                int cost = nums[i][0];
                int[] element = new int[]{idx, cost, benefit};
                list.add(element);
                helper(i, (prev==1?times+1:1), k-1, m-cost, nums, list);
                list.remove(list.size()-1);
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		while(true){
		    int k = sc.nextInt();
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    
		    if(k==0 && n ==0 && m==0){
		        break;
		    }
		    
		    int[][] nums = new int[n][2];
		    for(int i=0; i<n; i++){
		        nums[i][0] = sc.nextInt();
		        nums[i][1] = sc.nextInt();
		    }
		    
		    res = new ArrayList<>();
		    minCost = Integer.MAX_VALUE;
		    maxBenefit = Integer.MIN_VALUE;
		    
		    helper(-1, 0, k, m, nums, new ArrayList<>());
		    System.out.println(maxBenefit);
		    for(int[] element: res){
		        System.out.print(element[0]+" ");
		    }
            System.out.println();
		}
        sc.close();

	}
}
