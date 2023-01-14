import java.util.Stack;

public class Tests {

    public static void main(String[] args){

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (Object ss : stack){
            System.out.print(ss);
        }

        while (!stack.isEmpty()){
            System.out.print("\n"+stack.peek());
            stack.pop();
        }
        
    }
    
}
