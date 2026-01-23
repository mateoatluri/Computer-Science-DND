import java.lang.Math;
import java.lang.StringBuilder;

public class Arithmetic {
    
    //Evaluates a String exp that has an arithmetic expression, written in 
    // classic notation
    
    public static int evaluate(String exp) {
        String stoutExp = convertClassicToStout(exp);
        return evaluateStout(stoutExp);
    }

    //Returns the result of doing operand1 operation operand2,
    //e.g. operate(5, 2, "-") should return 3
    public static int operate(int operand1, int operand2, String operation) {
        
        if (operation.equals("+")) {
            return operand1 + operand2;
        } else if (operation.equals("-")) {
            return operand1 - operand2;
        } else if (operation.equals("*")) {
            return operand1 * operand2;
        } else if (operation.equals("/")) {
            return operand1 / operand2;
        } else if (operation.equals("^")) {
            return (int) Math.pow(operand1, operand2);
        } else if (operation.equals("%")) {
            return (int) operand1 % operand2;
        } 
        
        
        else {
            throw new IllegalArgumentException("Invalid Operation");
        }

    }
    
    //Evaluates a String exp that has an arithmetic expression written in STOUT
    // notation
    
    public static int evaluateStout(String exp) {
        String[] newExp = exp.split(" ");
        MyStack<String> newStack = new MyStack<String>();
        
        for (int i = 0; i < newExp.length; i++) {
            String currentVar = newExp[i];
            if (isOperator(currentVar) == false) {
                newStack.push(currentVar);
            } else {
                int operand2 = Integer.parseInt(newStack.pop());
                int operand1 = Integer.parseInt(newStack.pop());
                
                int newValue = operate(operand1, operand2, currentVar);
                String newValueString = String.valueOf(newValue);
                newStack.push(newValueString);
            }
        }
        return Integer.parseInt(newStack.pop());
    }


    //helper method
    public static boolean isOperator (String var) {
        if (var.equals("+") || var.equals("-") || var.equals("*") || var.equals("/")
             || var.equals("(") || var.equals(")")
            || var.equals("^") || var.equals("%")) {
            return true;
        } else {
            return false;
        }
    }

    //helper method
    public static int priority (String operation) {
         if (operation.equals("+")) {
            return 4;
        } else if (operation.equals("-")) {
            return 4;
        } else if (operation.equals("*")) {
            return 5;
        } else if (operation.equals("/")) {
            return 5;
        } else if (operation.equals("^")) {
            return 6;
        } else if (operation.equals("%")) {
            return 5;
        } else if (operation.equals("(")) {
            return 8;
        } else if (operation.equals(")")) {
            return 8;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String convertClassicToStout(String exp) {
        String[] newExp = exp.split(" ");
        //String result = "";
        StringBuilder result = new StringBuilder();
        MyStack<String> newStack = new MyStack<String>();
        int numPriority = 0;


        for (int i = 0; i < newExp.length; i++) {
            String character = newExp[i];
            if (isOperator(character)) {
                if (character.equals(")")) {
                    while (!newStack.peek().equals("(")) {
                        result.append(newStack.pop());
                        result.append(" ");
                    }
                    newStack.pop();

                } else if (priority(character) > numPriority || newStack.peek().equals("(")) {
                    numPriority = priority(character);
                    newStack.push(character);
                } else {
                    if (priority(character) <= numPriority) {
                        while (!newStack.empty() && !newStack.peek().equals("(")) {
                            result.append(newStack.pop());
                            result.append(" ");
                        }
                        newStack.push(character);

                        if (!newStack.empty()) {
                            numPriority = priority(newStack.peek());
                        }

                    }
                }
            } else {
                result.append(character);
                result.append(" ");
            }

        }
        while (!newStack.empty()) {
            result.append(newStack.pop());
            result.append(" ");
        }
        
        String toReturn = result.toString();
        return toReturn;
        //return toReturn.substring(0, result.length() - 2);
    }
    
}
