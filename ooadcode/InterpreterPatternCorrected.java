import java.util.Stack;

interface Expression {
    int evaluate();
}

class WholeNumber implements Expression {
    private int number;

    public WholeNumber(int number) {
        this.number = number;
    }

    public WholeNumber(String str) {
        this.number = Integer.parseInt(str);
    }

    @Override
    public int evaluate() {
        return number;
    }
}

class Addition implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public Addition(Expression leftOp, Expression rightOp) {
        this.leftOperand = leftOp;
        this.rightOperand = rightOp;
    }

    @Override
    public int evaluate() {
        return leftOperand.evaluate() + rightOperand.evaluate();
    }
}

class Subtraction implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public Subtraction(Expression leftOp, Expression rightOp) {
        this.leftOperand = leftOp;
        this.rightOperand = rightOp;
    }

    @Override
    public int evaluate() {
        return leftOperand.evaluate() - rightOperand.evaluate();
    }
}

class Multiply implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public Multiply(Expression leftOp, Expression rightOp) {
        this.leftOperand = leftOp;
        this.rightOperand = rightOp;
    }

    @Override
    public int evaluate() {
        return leftOperand.evaluate() * rightOperand.evaluate();
    }
}

class Divide implements Expression {
    private Expression numerator;
    private Expression denominator;

    public Divide(Expression numerator, Expression denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int evaluate() {
        int denomValue = denominator.evaluate();
        if (denomValue == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return numerator.evaluate() / denomValue;
    }
}

public class InterpreterPatternCorrected {
    public static void main(String[] args) {
        Stack<Expression> stack = new Stack<>();
        String postFix = "5 3 * 2 + 1 - 4 /"; // (5 * 3 + 2 - 1)/4

        String[] tokenList = postFix.split(" ");
        for (String s : tokenList) {
            if (isOperatorString(s)) {
                Expression rightOp = stack.pop();
                Expression leftOp = stack.pop();
                Expression operator = getOperatorHandler(s, leftOp, rightOp);
                stack.push(operator); // push operator expression itself
            } else {
                stack.push(new WholeNumber(s));
            }
        }

        System.out.println(stack.pop().evaluate());
    }

    public static boolean isOperatorString(String str) {
        return "+-*/".contains(str);
    }

    public static Expression getOperatorHandler(String str,
            Expression left, Expression right) {
        Expression obj = null;
        switch (str) {
            case "+":
                obj = new Addition(left, right);
                break;
            case "-":
                obj = new Subtraction(left, right);
                break;
            case "*":
                obj = new Multiply(left, right);
                break;
            case "/":
                obj = new Divide(left, right);
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + str);
        }
        return obj;
    }
}