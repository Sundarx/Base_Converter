//SUNDAR RAJ
public interface ListStackADT<T>
{
    //Returns true if empty stack, false if not empty
	public abstract boolean isEmpty();

	//If stack is empty, throw EmptyStackException
	public abstract void ifEmpty() throws EmptyStackException;

    //Add item T to the stack
	public abstract void push(T value);

    //If stack is not empty, retrieve item T at the top of stack
    //If stack is empty, throw EmptyStackException
	public abstract T peek() throws EmptyStackException;

    //If stack is not empty, remove item T from the top of stack
    //If stack is empty, throw EmptyStackException
	public abstract void pop() throws EmptyStackException;
}