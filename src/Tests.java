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
        Stack<String> output = itp.getOutput();

        System.out.println(output.toString());

        Operate operate = new Operate(output);
        int resultado = operate.Calculate();

        System.out.println("resultado: " + resultado);

        // System.out.println(stack.search("5"));

        Stack<String> prueba = new Stack<String>();

        prueba.push("1");
        prueba.push("1");
        prueba.push("1");
        prueba.push("1");

        prueba.setElementAt("2", 1);

        System.out.println(prueba.toString());


    }
    
}
