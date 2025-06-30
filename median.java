import java.util.*;

class median {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // To store the result digits
        List<Integer> ans = new ArrayList<>();

        // Start from the last digit of the array
        int p = num.length - 1;
        int carry = 0;

        // Loop until we have digits from either the array or k
        while (p >= 0 || k > 0) {
            // Get the current digit from num[], or 0 if p < 0
            int numval = (p >= 0) ? num[p] : 0;

            // Get last digit of k
            int d = k % 10;

            // Add digits and carry
            int sum = numval + d + carry;

            // Current digit to store in answer
            int digit = sum % 10;

            // Update carry
            carry = sum / 10;

            // Add to result list (in reverse order)
            ans.add(digit);

            // Move to next digits
            p--;
            k /= 10;
        }

        // If carry is left after loop, add it
        if (carry > 0) {
            ans.add(carry);
        }

        // Since we added digits in reverse order, reverse the list
        Collections.reverse(ans);

        return ans;
    }
}
