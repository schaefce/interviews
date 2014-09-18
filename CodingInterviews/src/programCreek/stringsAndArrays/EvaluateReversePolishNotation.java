package programCreek.stringsAndArrays;

/* Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be integer or another expression

Some examples:

["2", "1", "+", "3", "*"] --> ((2+1)*3) -> 9
["4", "13", "5", "/", "+"] --> (4+(13/5)) -> 6

*/
public class EvaluateReversePolishNotation{
    public static int evaluate(String[] expression){
        String[] operands = "+-*/";
        Stack<String> evalStack = new Stack<String>();
        for(String s : expression){
            if(operands.contains(t)){
                int b = Integer.valueOf(evalStack.pop());
                int a = Integer.valueOf(evalStack.pop());
                int op = operands.indexOf(s);
                switch(op){
                    case 0:
                        evalStack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        evalStack.push(String.valueOf(a-b));
                        break;
                    case 2:
                        evalStack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        evalStack.push(String.valueOf(a/b));
                        break;
                }
            }
            else{
                evalStack.push(t);
            }
        }
        return Integer.valueOf(stack.pop());
    }


    public static void main(String[] args){
        String[] exp1 = {"2", "1", "+", "3", "*"};
        assert(evaluate(expr1) == 9);
        String[] exp2 = {"4", "13", "5", "/", "+"};
        assert(evaluate(expr1) == 6);
    }
}
