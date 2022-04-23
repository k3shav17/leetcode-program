class Solution {
    public boolean isValid(String s) {
        char st[] = s.toCharArray();


        if(st[0] == ')' || st[0] == '}' || st[0] == ']')
        return false;

        Stack<Character> s1 = new Stack<>();

        for(int i=0;i<st.length;i++){
            if(st[i]=='(' || st[i] == '{' || st[i] == '[') {
                s1.push(st[i]);
            }
            else if(st[i] == ')' || st[i] == '}' || st[i] == ']'){
                if(s1.empty())
                    return false;
                if(st[i]==')' && s1.peek()=='(')
                    s1.pop();
               else if(st[i]=='}' && s1.peek()=='{')
                    s1.pop();
                else if(st[i]==']' && s1.peek()=='[')
                    s1.pop();
                else
                    return false;
            }
        }

        if(s1.empty())
            return true;
        else
            return false;
    }
}
