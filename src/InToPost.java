import java.util.Stack;

public class InToPost {

    private Stack<String> input;
    private Stack<String> output;
    private Stack<String> operators;

    private CheckDataType cdt;
    
    public InToPost(Stack<String> input){

        cdt = new CheckDataType();

        this.input = input;

        output = new Stack<String>();
        operators = new Stack<String>();

    }

    public Stack<String> getOutput() {

        while (!input.empty()){
            // Se corre hasta que se vacía la lista de todos
            // los elementos dentro del input

            // Algoritmo basado en "How calculators read mathematical
            // expression with operator precedence" Recuperado de: 
            // https://bit.ly/3IQ9yLc

            // Reglas del algorítmo
            // 1. Las literales siempre van al stack del output
            // 2. Cuando un operador con menor o igual precedencia que el
            //    último elemento del stack de operadores es el siguiente, 
            //    hay que hacer pop el último elemento del stack de
            //    operadores y pasarlo al del output.
            
            String element = input.pop();

            // ver si se puede transformar a número


            if (cdt.check(element).equals("Integer")) {
                // regla 1
                System.out.println("int " + element);
                // int el = Integer.parseInt(element, 0);

                output.push(element);

            } 
            
            else if (cdt.check(element).equals("String")) {
                //regla 2

                System.out.println("op " + element);

                // revisar qué caso es

                if (!operators.isEmpty()){

                    if (element.equals("+") || element.equals("-")) {

                        if (operators.peek().equals("(")) {

                            operators.push(element);

                        } else {

                            output.push(operators.pop());
                            operators.push(element);

                        }


                    } else if (element.equals("*") || element.equals("/")) {

                        if (operators.peek().equals("+") || operators.peek().equals("-") || operators.peek().equals("(")) {

                            operators.push(element);
                                                        
                        } else {

                            output.push(operators.pop());
                            operators.push(element);

                        }
    
                    } else if (element.equals("^")) {

                        if (operators.peek().equals("^")) {

                            output.push(operators.pop());
                            operators.push(element);
                            
                        } else {

                            operators.push(element);
                        }

    
                    } else if (element.equals("(")) {

                        operators.push(element);


                    } else if (element.equals(")")) {

                        while (!operators.peek().equals("(")) {

                            output.push(operators.pop());

                        }

                        // se llega al (
                        operators.pop(); // se elimina

                    }

                } else {

                    operators.push(element);

                }
            }

            System.out.println("Input: " + input.toString());
            System.out.println("Output: " + output.toString());
            System.out.println("Operators: " + operators.toString());
            System.out.println();

        }

        while (!operators.isEmpty()) {

            // Cuando se acaben los números, todos los operandos que 
            // quedaron se sacan uno a uno del stack de operandos y se
            // agregan al stack de output
            output.push(operators.pop());

            System.out.println("Input: " + input.toString());
            System.out.println("Output: " + output.toString());
            System.out.println("Operators: " + operators.toString());
            System.out.println();

        }

        return output;
    }

}
