// 1237. Find Positive Integer Solution for a Given Equation
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int x = 1;
        int y = 100;
        while (x <= 100 && y > 0) {
            int sum = customfunction.f(x, y);
            if (sum == z) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                result.add(list);
                x++;
                y--;
            } else if (sum < z) {
                x++;
            } else {
                y--;
            }
        }
        return result;
    }
}

// binary search on two dimensional array
// same as LC240: Search a 2D Matrix II