class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int low_digits = getNumDigits(low);
        int high_digits = getNumDigits(high);
        
        List<Integer> result = new ArrayList<>();
        int digits = low_digits;
        for (int i = 0; i <= high_digits - low_digits; i++) {
            generateNum(digits, 1, low, high, result);
            digits++;
        }
        return result;
    }
    
    private void generateNum(int total_digits, int start_digit, int low, int high, List<Integer> result) {
        boolean flag = true;
        while (flag) {
            int num = 0;
            int start = start_digit;
            int digits = total_digits;
            while (digits > 0) {
                if (start > 9) {
                    flag = false;
                    break;
                }
                
                num = num * 10 + start;
                digits--; 
                start++;
            }
            
            if (flag) {
                if (num >= low && num <= high) {
                    result.add(num);
                }
                if (num > high) {
                    flag = false;
                    break;
                }
                start_digit++;
            }
        }
    }
    
    private int getNumDigits(int num) {
        int digits = 0;
        while (num != 0) {
            digits++;
            num = num / 10;
        }
        return digits;
    }
}






class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int low_digits = getNumDigits(low);
        int high_digits = getNumDigits(high);
        
        for (int total_digits = low_digits; total_digits <= high_digits; total_digits++) {
            for (int first_digit = 1; first_digit <= 9; first_digit++) {
                generateNum(total_digits, first_digit, res, low, high);
            }
        }
        return res;
    }
    
    private void generateNum(int total_digits, int first_digit, List<Integer> res, int low, int high) {
        int val = 0;
        for (int i = first_digit; i <= 9 && total_digits > 0; i++) {
            val = val * 10 + i;
            total_digits--;
        }
        if (total_digits <= 0 && val >= low && val <= high) {
            res.add(val);
        }
    }
    
    private int getNumDigits(int num) {
        int digits = 0;
        while (num != 0) {
            digits++;
            num = num / 10;
        }
        return digits;
    }
}