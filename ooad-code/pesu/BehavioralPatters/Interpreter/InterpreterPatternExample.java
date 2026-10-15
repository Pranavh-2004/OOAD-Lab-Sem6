import java.util.Stack;
interface Expression 
{
    public int evaluate();//overriden by terminal and non terminal node
}


 class WholeNumber implements Expression {
    private int number;
 
    public WholeNumber(int number) {
        this.number = number;
    }
 
    public WholeNumber(String str) {
        this.number = Integer.parseInt(str);
    }
 
    public int evaluate() {
        return number;
    }
}

class Addition implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;
  
    public Addition(Expression leftOp, Expression rightOp){
        this.leftOperand = leftOp;
        this.rightOperand = rightOp;
    }
  
      public int evaluate(){
        return leftOperand.evaluate() + rightOperand.evaluate();
    }
}

class Subtraction implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;
  
    public Subtraction(Expression leftOp, Expression rightOp){
        this.leftOperand = leftOp;
        this.rightOperand = rightOp;
    }
  
     public int evaluate(){
        return leftOperand.evaluate() - rightOperand.evaluate();
    }
}


class Multiply implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;
  
    public Multiply(Expression leftOp, Expression rightOp){
        this.leftOperand = leftOp;
        this.rightOperand = rightOp;
    }
  
  
    public int evaluate(){
        return leftOperand.evaluate() * rightOperand.evaluate();
    }
}

class Divide implements Expression {
    private Expression numerator;
    private Expression denominator;
  
    public Divide(Expression numerator, Expression denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
  
        public int evaluate(){
        try {
            return numerator.evaluate() / denominator.evaluate();
        } catch (ArithmeticException e) {
            System.out.println("Division by Zero Exception");
            throw e;
        }
    }
}

 class InterpreterPatternExample
 {
    public static void main(String args[]) {
 Stack stack = new Stack();
 String postFix = "5 3 * 2 + 1 - 4 /"; // (5 * 3 + 2 - 1)/4
 
 String[] tokenList = postFix.split(" ");

 for (String s : tokenList) {

     if (isOperatorString(s)) {
  Expression rightOp = (Expression)stack.pop();
  Expression leftOp = (Expression)stack.pop();
  Expression operator = getOperatorHandler(s, leftOp,rightOp);
  int result = operator.evaluate();
  stack.push(new WholeNumber(result));
     } 
else 
{
  Expression num = new WholeNumber(s);
  stack.push(num);
     }
 }
 
System.out.println("Result = "+((Expression)stack.pop()).evaluate());
    }
 
   
 public static boolean isOperatorString(String str) {
 if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
     return true;
 else
            return false;
    }
 

    public static Expression getOperatorHandler(String s, Expression left,
     Expression right) {
 switch (s) {
     case "+":
  		return new Addition(left, right);
     case "-":
  		return new Subtraction(left, right);
     case "*":
 		return new Multiply(left, right);
     case "/":
		return new Divide(left, right);

     default:   return null;
 }
    }
}