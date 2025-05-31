import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        //// Take a guess as to how a programming language like java might evaluate expressions
        //  
        //  
        //  
        //////////////////////////////////////////////////////////////////////////////////////

        // Take in an expression using a scanner
        
        // Run convertInfixToPostfix on that expression

        // print the result of evaluatePostfix

    }

    public static ArrayList<String> convertInfixToPostfix(String expression) {
        // This is the Shunting-Yard algorithm
        // See https://www.youtube.com/watch?v=Wz85Hiwi5MY for a demonstration
        ArrayList<String> expressionChars = new ArrayList<String>();
        // set expressionChars to the individual characters of expression
        Stack<String> operatorStack = new Stack<String>();
        Queue<String> expressionQueue = new LinkedList<String>();
        ArrayList<String> result = new ArrayList<String>();

        // iterate through expressionChars
            // if it's an operator or opening parenthesis
                // If the top operation of the stack is of higher precedence, then
                // pop back to the beginning or last opening parenthesis in the operatorStack and enqueue
                // those operators. Then push it to the stack. Remember, you can't peek an empty stack.
            // if it's a closing parenthesis
                // pop back to the last open parenthesis, enqueueing everything in between. 
                // Fun fact: if there isn't a last open parenthesis
            // otherwise
                // enqueue to expression queue, only numbers should reach this steps
            
        

        // empty out the operator stack into the expression queue (make sure to exclude any parenthesis)
        // empty the expression queue into result
        return result;
    }

    public static double operate(String operator, double numLeft, double numRight) {
        // return the value of numLeft operator numRight
    }

    public static Double evaluatePostfix(ArrayList<String> expression) {
        Stack<Double> numStack = new Stack<Double>();
        // using a stack and the Double.parseDouble(string) method to
        // convert strings to Doubles, write a method that evaluates 
        // a postfix expression. See instructions for more details.
    }
}
