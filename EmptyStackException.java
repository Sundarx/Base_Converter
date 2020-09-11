//SUNDAR RAJ
public class EmptyStackException extends StackException1
{
	public EmptyStackException()
	{
		super("Error: Empty Stack");
	}

	public EmptyStackException(String message)
	{
		super(message);
	}
}