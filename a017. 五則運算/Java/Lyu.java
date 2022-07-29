import java.util.Scanner;
import java.util.Stack;

public class Lyu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> numsStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();
        String[] elements;
        char nowOp = ' ';
        int newOpWeight = 0, oldOpWeight = -1;
        int result = 0;
        while (scan.hasNext()) {
            nowOp = ' '; // initialize all local variables
            newOpWeight = result = 0;
            oldOpWeight = -1;
            numsStack.clear();
            opStack.clear();
            elements = scan.nextLine().split(" "); // input string split to string array
            for (String str : elements) { // run all element in string array
                // System.out.println("number stack : " + Arrays.toString(numsStack.toArray()));
                // System.out.println("operator stack : " + Arrays.toString(opStack.toArray()));
                try {
                    numsStack.push(Integer.valueOf(str)); // if string is numeric, push into number stack
                } catch (Exception e) { // otherwise it will be operator
                    nowOp = str.charAt(0); // get operator in char
                    newOpWeight = getWeight(nowOp); // get operator's weight ( '+', '-' : 0 | '*', '/', '%' : 1 )
                    if (nowOp == ')') { // if ')' detected, calculate all the numbers until '('
                        int partResult = 0; // part result inside (algorithm)
                        if (getWeight(opStack.peek()) == 1) { // handle like "4*5)" need to compute 4*5 first
                            numsStack.push(compute(numsStack.pop(), numsStack.pop(), opStack.pop()));
                        }
                        while (opStack.peek() != '(') { // calculate all the numbers in (algorithm)
                            partResult += compute(numsStack.pop(), partResult, opStack.pop());
                        }
                        partResult += (!numsStack.isEmpty()) ? numsStack.pop() : 0; // calculate the last number
                        numsStack.push(partResult); // push the part result into number stack
                        opStack.pop();// pop '(' out
                        oldOpWeight = (!opStack.isEmpty()) ? getWeight(opStack.peek()) : 0;
                        continue; // old op weight must set the one before the parenthesis, then continue
                    }
                    if (!opStack.isEmpty() && newOpWeight <= oldOpWeight && newOpWeight != 2 && oldOpWeight != 2) {
                        numsStack.push(compute(numsStack.pop(), numsStack.pop(), opStack.pop()));
                    } // if the operator weight is less than or equal to the previous , compute first
                    opStack.push(nowOp); // push current operator into operator stack
                    oldOpWeight = newOpWeight; // store the previous operator weight
                }
            }
            while (!opStack.isEmpty()) { // do loop until operator stack is empty
                if (getWeight(opStack.peek()) == 1) // handle like "4*5)" need to compute 4*5 first
                    numsStack.push(compute(numsStack.pop(), numsStack.pop(), opStack.pop()));
                else { // handle the remain algorithm
                    result = compute(numsStack.pop(), result, opStack.pop());
                }
            }
            result += numsStack.pop(); // calculate the last number
            System.out.println(result); // perfect!
        }
        scan.close();
    }

    private static int getWeight(char c) { // get operator weight
        return (c == '+' || c == '-') ? 0 : (c == '(') ? 2 : 1;
    }

    private static int compute(int num1, int num2, char operator) {
        switch (operator) { // calculate given two numbers with given operator
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            case '%':
                return num2 % num1;
            default: // shouldn't come here
                return 0;
        }
    }
}