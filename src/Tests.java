import java.util.Stack;

public class Tests {

    public static void main(String[] args){

        Stack<String> stack = new Stack<String>();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        for (Object ss : stack){
            System.out.println(ss);
        }

        /*
         * while (!stack.isEmpty()){
            System.out.print("\n"+stack.peek());
            stack.pop();
        }
         * 
         */

         InToPost itp = new InToPost(stack);

         //CheckDataType cdt = new CheckDataType();

         //System.out.println(cdt.check("2"));



    }
    
}
