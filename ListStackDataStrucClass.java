//SUNDAR RAJ
public class ListStackDataStrucClass<T> implements ListStackADT<T>
{
	private StackNode<T> top;

	public ListStackDataStrucClass()
	{
		top = null;
	}

	public ListStackDataStrucClass(StackNode<T> stackTop)
	{
		top = stackTop;
	}

	public ListStackDataStrucClass(ListStackDataStrucClass<T> copyStack)
	{
		top = copyStack.top;

		if (!copyStack.isEmpty())
		{
			while (!copyStack.isEmpty())
			{
				this.push((T)copyStack.peek());
				copyStack.pop();
			}
		}
		else
		{
			throw new EmptyStackException();
		}
	}

	public void setTop(StackNode<T> stackTop)
	{
		top = stackTop;
	}

	public StackNode<T> getTop()
	{
		return top;
	}

    //Returns true if empty stack, false if not empty
	public boolean isEmpty()
	{
		return (top == null);
	}

	//If stack is empty, throw EmptyStackException
	public void ifEmpty() throws EmptyStackException
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}
	}

    //Add T item to the stack
	public void push(T value)
	{
		if(this.isEmpty())
		{
		    setTop(new StackNode<T>(value, null));
		}
		else
		{
			setTop(new StackNode<T>(value, getTop()));
		}
	}

    //If stack is not empty, retrieve item T at the top of stack
    //If stack is empty, throw EmptyStackException
	public T peek() throws EmptyStackException
	{
		ifEmpty();
		return getTop().getValue();
	}

    //If stack is not empty, remove item T from the top of stack
    //If stack is empty, throw EmptyStackException
	public void pop() throws EmptyStackException
	{
		ifEmpty();
		setTop(getTop().getNext());
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder();

        if (!isEmpty())
        {
        	StackNode<T> current = top;
        	while (current != null)
        	{
        		str.append(current.getValue() + " ");
        		current = current.getNext();
            }
        }

        return str.toString();
	}

	//Inner Class
	public class StackNode<T>
	{
        private T value;
        private StackNode<T> next;

        public StackNode()
        {
        	value = null;
        	next = null;
        }

        public StackNode(T value, StackNode<T> next)
        {
              this.value = value;
              this.next = next;
        }

        public StackNode(StackNode<T> node)
        {
        	value = node.value;
			next = node.next;
        }

        public T getValue()
        {
              return value;
        }

        public StackNode<T> getNext()
        {
              return next;
        }

        public void setValue(T value)
        {
              this.value = value;
        }

        public void setNext(StackNode<T> next)
        {
              this.next = next;
        }
	}
}