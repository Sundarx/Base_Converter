//SUNDAR RAJ
import java.util.Scanner;

public class BaseConverter
{
	private BaseNumber[] baseNum;

	public BaseConverter()
	{
		baseNum = new BaseNumber[3];
		inputPrompt();
	}

	public void inputPrompt()
	{
		Scanner keyboard = new Scanner(System.in);

		for (int i = 0; i < baseNum.length; i++)
		{
			System.out.print((i + 1) + ") Enter a positive integer of base 10: ");
			long number = keyboard.nextLong();

			System.out.print("Enter a base from 2 to 9 to convert the number to: ");
			long base = keyboard.nextLong();

			if(base < 2 || base > 9)
			{
				System.out.println("Error: base must be between 2 and 9");
				System.out.println("Restart the program.");
				System.exit(0);
			}

			baseNum[i] = new BaseNumber(number, base);
		}
	}

	public String convert(BaseNumber num)
	{
		long number = num.getNumber();
		long base = num.getBase();

		ListStackDataStrucClass<Long> stack = new ListStackDataStrucClass<Long>();

		while (number != 0)
		{
			stack.push(number % base);
			number /= base;
		}

		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty())
		{
			result.append(stack.peek());
			stack.pop();
		}
		return result.toString();

	}

	private String convertAll()
	{
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < baseNum.length; i++)
		{
			str.append((i+1) + ") "
					+ baseNum[i].getNumber()+ " (Base 10) = "
					+ convert(baseNum[i]) + " (Base "
					+ baseNum[i].getBase() + ")\n");
		}

		return str.toString();
	}

	public String toString()
	{
		return convertAll();
	}

	public void processAndPrint()
	{
		System.out.println(this);
	}

	//Inner class
	public class BaseNumber
	{
		private long number;
		private long base;

		public BaseNumber()
		{
			this(0, 10);
		}

		public BaseNumber(long number, long base)
		{
			this.number = number;
			this.base = base;
		}

		public long getNumber()
		{
			return number;
		}

		public long getBase()
		{
			return base;
		}

		public void setNumber(long number)
		{
			this.number = number;
		}

		public void setBase(long base)
		{
			this.base = base;
		}
	}
}