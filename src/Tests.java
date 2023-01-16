import java.util.Stack;

public class Tests {

    public static void main(String[] args){

        Stack<String> stack = new Stack<String>();

        stack.push(")");
        stack.push("4");
        stack.push("*");
        stack.push("2");
        stack.push("+");
        stack.push("5");
        stack.push("(");
        stack.push("-");
        stack.push("2");
        stack.push("+");
        stack.push("1");

        System.out.println(stack.toString());

        InToPost itp = new InToPost(stack);


    }
    
}
