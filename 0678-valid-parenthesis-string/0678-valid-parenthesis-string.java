class Solution {
    public boolean checkValidString(String s) {

        ArrayDeque<Integer> openBrackets = new ArrayDeque<> ();
        ArrayDeque<Integer> asterisks = new ArrayDeque<> ();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openBrackets.push(i);
            }
            else if (ch == '*') {
                asterisks.push(i);
            } 
            else {
                if (!openBrackets.isEmpty()) {
                    openBrackets.pop();
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } else {
                    return false;
                }
            }
        }

        while (!openBrackets.isEmpty() && !asterisks.isEmpty()) {

            if (openBrackets.pop() > asterisks.pop()) {
                return false; 
            }
        }

        return openBrackets.isEmpty();
    }
}