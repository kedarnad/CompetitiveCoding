package TejasDataCore;

import java.util.Stack;

public class practice {

    public static void main(String args[]) {
        Stack<Object> st = new Stack<>();
        st.add(1);
        st.add(1.1);
        st.add('z');
        st.add("Heello");

        for (Object e : st) {
            System.out.println(e);
        }

    }
}
