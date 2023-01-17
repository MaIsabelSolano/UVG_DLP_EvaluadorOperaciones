import java.util.Stack;

public class Operate {

    private int position = 0;
    private int left = 0;
    private int right = 0;
    private int resultado = 0;

    private String operation;

    private Stack<String> input;

    private CheckDataType cdt;

    public Operate(Stack<String> input) {

        this.input = input;

        cdt = new CheckDataType();

    }

    public int Calculate() {

        while (input.size() > 1) {
            System.out.println("input: " + input.toString());
            System.out.println("Último operador: " + getOperationPosition());
            
            // obtener el primer operador
            position = getOperationPosition();

            // obtener izquierda y derecha
            left = position - 2;
            right = position - 1;

            // obtener valores
            String operador = input.get(position);
            String left_String = input.get(left);
            String right_String = input.get(right);

            System.out.println(left_String +" "+ operador +" "+ right_String);

            // transformar a ints
            int left_int = Integer.parseInt(left_String);
            int right_int = Integer.parseInt(right_String);

            int res = 0;

            if (operador.equals("+")) {

                res = left_int + right_int;

            } else if (operador.equals("-")) {

                res = left_int - right_int;

            } else if (operador.equals("*")) {

                res = left_int * right_int;

            } else if (operador.equals("/")) {

                //realizar correcciones

                res = left_int / right_int;

            } else if (operador.equals("^")) {

                Double double_res = Math.pow(left_int, right_int);

                res = Math.round(res);

            }

            System.out.println("res op: " + res);

            // eliminar y reemplazar valores
            System.out.println("Antes del reemplazo: " + input.toString());
            System.out.println(left);
            input.remove(left); // izquierda
            input.remove(left); // derecha
            input.remove(left); // operador

            // añadir el valor que quedó

            try {

                input.insertElementAt(Integer.toString(res), left);
                
            } catch (ArrayIndexOutOfBoundsException e) {
                input.push(Integer.toString(res));
            }

            System.out.println("Después del reemplazo: " + input.toString());
            
            
        }

        return resultado;
    }

    private int getOperationPosition() {

        int pos = 0;
        Stack<String> temp = new Stack<String>();

        // darle vuelta
        while (!input.empty()) {
            temp.push(input.pop());
        }

        // revisar todo el stack de input
        int contador = 0;
        boolean notFound = true;
        while (!temp.empty()) {

            String dataTemp = temp.pop();

            if (cdt.check(dataTemp).equals("String") && notFound) {
                // Es un operador
                pos = contador;
                notFound = false;
            }

            input.push(dataTemp);
            contador += 1;

        }

        return pos;
    }
    
}
