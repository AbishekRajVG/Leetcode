
class Solution {
    
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public int[] candidates;
    public int target;

    public void dfs(int i, List<Integer> current, int total) {

            //debug 
            // System.out.println("i = " + i + " current = " + current.toString() + " total = " + total);

            // ideal exit condition is when we meet target
            if(total == this.target){
                System.out.println("equal hit");
                // make a deep copy
                List<Integer> curr = new ArrayList<>(current);
                this.result.add(curr);
                System.out.println(this.result);

                return;
            }
            // worst case exit
            if(total > this.target || i > this.candidates.length - 1) return;

            current.add(this.candidates[i]);
            dfs(i, current, total + this.candidates[i]); // left decision including candidate[i]
            current.remove(current.size()-1); // pop out candidate to ignore duplicate combinations
            dfs(i+1, current, total); // right decision excluding candidate[i] but all other candidates
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        dfs(0, new ArrayList<Integer>(), 0);
        return this.result;

    }
}