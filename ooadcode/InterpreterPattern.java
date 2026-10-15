// Expression interface used to check the interpreter.
interface Expression
{
	boolean interpreter(String con);
}

// TerminalExpression class implementing the above interface. This interpreter
// just checks if the data is same as the interpreter data.
class TerminalExpression implements Expression
{
	String data;

	public TerminalExpression(String data)
	{
		this.data = data;
	}

	public boolean interpreter(String con)
	{
		if(con.contains(data))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
// OrExpression class implementing the above interface. This interpreter
// just returns the or condition if the data is same as the interpreter data.
class OrExpression implements Expression
{
	Expression expr1;
	Expression expr2;

	public OrExpression(Expression expr1, Expression expr2)
	{
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	public boolean interpreter(String con)
	{		
		return expr1.interpreter(con) || expr2.interpreter(con);
	}
}

// AndExpression class implementing the above interface. This interpreter
// just returns the And condition of the data is same as the interpreter data.
class AndExpression implements Expression
{
	Expression expr1;
	Expression expr2;

	public AndExpression(Expression expr1, Expression expr2)
	{
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	public boolean interpreter(String con)
	{		
		return expr1.interpreter(con) && expr2.interpreter(con);
	}
}

// Client code
public class InterpreterPattern
{

	public static void main(String[] args)
	{
		Expression person1 = new TerminalExpression("Anand");
		Expression person2 = new TerminalExpression("Ramesh");
		Expression isSingle = new OrExpression(person1, person2);
		
		Expression vikram = new TerminalExpression("Vikram");
		Expression committed = new TerminalExpression("Committed");
		Expression isCommitted = new AndExpression(vikram, committed);	

		System.out.println(isSingle.interpreter("Anand"));
		System.out.println(isSingle.interpreter("Ramesh"));
		System.out.println(isSingle.interpreter("Achint"));
		
		System.out.println(isCommitted.interpreter("Committed, Vikram"));
		System.out.println(isCommitted.interpreter("Single, Vikram"));

	}
}

