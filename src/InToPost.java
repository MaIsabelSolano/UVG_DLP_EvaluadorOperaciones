import java.util.Stack;

public class InToPost {
    
    public InToPost(Stack<String> input){

        CheckDataType cdt = new CheckDataType();

        Stack<String> output = new Stack<String>();
        Stack<String> operators = new Stack<String>();

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
                int el = Integer.parseInt(element, 0);
            } 
            
            else {
                //regla 2
            }

        }

    }
}
