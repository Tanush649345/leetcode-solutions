class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        if(n==0) return new int[0];
        List<Integer> st = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(asteroids[i] > 0) st.add(asteroids[i]);
            else{
                while(st.size() != 0 && st.get(st.size()-1) > 0 && st.get(st.size()-1) < -asteroids[i]) st.remove(st.size() -1);
                if(st.isEmpty() || st.get(st.size() -1) < 0) st.add(asteroids[i]);
                else if(st.get(st.size() - 1) == -asteroids[i]) st.remove(st.size() -1);
            }
        }
        int[] ans = new int[st.size()];
        for(int i=0;i<st.size();i++){
            ans[i] = st.get(i);
        }
        return ans;
    }
}