import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Please type in your expression: ");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        sc.close();
        
        ArrayList<String> postfix = convertInfixToPostfix(expression);

        System.out.println(postfix);

        System.out.println(evaluatePostfix(postfix));


    }

    public static ArrayList<String> convertInfixToPostfix(String expression) {
        ArrayList<String> expressionChars = new ArrayList<String>();
        for (int i =0; i < expression.length(); i++) {
            expressionChars.add(expression.substring(i, i+1));
        }
        // set expressionChars to the individual characters of expression
        Stack<String> operatorStack = new Stack<String>();
        Queue<String> expressionQueue = new LinkedList<String>();
        ArrayList<String> result = new ArrayList<String>();
        for (String i: expressionChars) {
            
            if (i.equals("+") || i.equals("-") || i.equals("/") || i.equals("*") || i.equals("^") || i.equals("(")) {
                
                if (operatorStack.isEmpty()) {
                    operatorStack.push(i);
                }
                else if ((operatorStack.peek().equals("*") || operatorStack.peek().equals("/") || operatorStack.peek().equals("^")) && (i.equals("+") || i.equals("-"))) {
                    while(!operatorStack.isEmpty() && operatorStack.peek() != "(") {
                        expressionQueue.add(operatorStack.pop());
                    }
                    operatorStack.push(i);
                }
                else if ((operatorStack.peek().equals("^")) && (i.equals("*") || i.equals("/"))) {
                    while(!operatorStack.isEmpty() && operatorStack.peek() != "(") {
                        expressionQueue.add(operatorStack.pop());
                    }
                    operatorStack.push(i);
                } else {
                    operatorStack.push(i);
                }
                
                // Append it to the list. If the top operation of the stack is of higher precedence, then
                // pop back to the beginning or last opening parenthesis in the operatorStack and enqueue
                // those operators
            } else if (i.equals(")")) {
                while(!operatorStack.peek().equals("(")) {
                    expressionQueue.add(operatorStack.pop());
                    // If there's an error here it's cause the parenthesis aren't matching  
                }
                
                operatorStack.push(i);
            } else {
                
                expressionQueue.add(i);
                // enqueue to expression queue, only numbers should reach this steps

            }
            System.out.println(i);
            System.out.println(expressionQueue);
            System.out.println(operatorStack);
            System.out.println();
        }

        while(!operatorStack.isEmpty()) {
            while (operatorStack.peek().equals("(") || operatorStack.peek().equals(")")) {  operatorStack.pop(); }
            expressionQueue.add(operatorStack.pop());
        }
       while(!expressionQueue.isEmpty()) {
            result.add(expressionQueue.remove());
        }
        return result;
    }

    public static double operate(String operator, Double numLeft, Double numRight) {
        if (operator.equals("+")) {
            return numLeft + numRight;
        } else if (operator.equals("-")) {
            return numLeft - numRight;
        } else if (operator.equals("*")) {
            return numLeft * numRight;
        } else if (operator.equals("/")) {
            return numLeft / numRight;
        } else if (operator.equals("^")) {
            return Math.pow(numLeft,numRight);
        } else {
            return Double.NEGATIVE_INFINITY;
        }
    }

    public static Double evaluatePostfix(ArrayList<String> expression) {
        Stack<Double> numStack = new Stack<Double>();
        // iterate through expression
        for (String i: expression) {
            
            if (i.equals("+") || i.equals("-") || i.equals("/") || i.equals("*") || i.equals("^"))  {
            // if it's a operator
                Double right = numStack.pop();
                Double left = numStack.pop();
                numStack.push(operate(i, left, right));
                // pop the top two values of the stack into variables
                // push operate(operator, firstvalue, second value)
            }
            // if it's a number
            else {
                numStack.push(Double.parseDouble(i));
                // convert it to a double using Double.parseDouble(string)
                // then push it to the stack
            }
        }
        return numStack.pop();
    }
}
