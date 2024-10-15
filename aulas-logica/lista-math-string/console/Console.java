package console;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Console
{

	private SimpleDateFormat dateFormatter;

	public Console()
	{
		dateFormatter = new SimpleDateFormat();
	}

	public void printMessage(String message)
	{
		if (!message.equals(""))
		{
			System.out.println(message.trim() + " ");
			System.out.flush();
		}
	}

	public void printDate(Date date)
	{
		if (date != null)
		{
			System.out.println(dateFormatter.format(date));
			System.out.flush();
		}
	}
	
	public void printDate(Date date, String format)
	{
		if (date != null)
		{
			dateFormatter.applyPattern(format);
			System.out.println(dateFormatter.format(date));
			System.out.flush();
		}
	}

	public String readLine()
	{
		int tCh;
		String tResult = "";
		boolean tDone = false;

		while (!tDone)
		{
			try
			{
				tCh = System.in.read();
				if (tCh < 0 || (char) tCh == '\n')
					tDone = true;
				else if ((char) tCh != '\r') // weird--it used to do \r\n
					// translation
					tResult = tResult + (char) tCh;
			}
			catch (java.io.IOException tExcept)
			{
				tDone = true;
			}
		}
		return tResult;
	}
	
	public BigDecimal readBigDecimal(String message)
	{
		printMessage(message);
		return this.readBigDecimal();
	}
	
	public BigDecimal readBigDecimal()
	{
		String valor = this.readString();
		BigDecimal bd = new BigDecimal(valor);
		return bd;
	}

	public String readLine(String message)
	{
		printMessage(message);
		return readLine();
	}

	public String readString(String message)
	{
		return readLine(message);
	}

	public String readString()
	{
		return readLine();
	}

	public char readChar()
	{
		char tResult = '\0';
		int tCh;
		boolean tDone = false;
		boolean tRead = false;

		while (!tDone)
		{
			try
			{
				tCh = System.in.read();
				if (tCh < 0 || (char) tCh == '\n')
					tDone = true;
				else if (!tRead && (char) tCh != '\r')
				{
					tResult = (char) tCh;
					tRead = true;
				}
			}
			catch (java.io.IOException tExcept)
			{
				tDone = true;
			}
		}
		return tResult;
	}

	public char readChar(String message)
	{
		printMessage(message);
		return readChar();
	}

	public double readDouble()
	{
		return readDouble("");
	}

	public double readDouble(String message)
	{
		String tLinha;

		while (true)
		{
			try
			{
				printMessage(message);
				tLinha = readLine().trim();
				if (tLinha.equals(""))
					return 0.0;
				return Double.parseDouble(tLinha);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not an double. Please try again!");
			}
		}
	}

	public float readFloat()
	{
		return readFloat("");
	}

	public float readFloat(String message)
	{
		String tLinha;

		while (true)
		{
			try
			{
				printMessage(message);
				tLinha = readLine().trim();
				if (tLinha.equals(""))
					return 0.0f;
				return Float.parseFloat(tLinha);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not an float. Please try again!");
			}
		}
	}

	public long readLong()
	{
		return readLong("");
	}

	public long readLong(String message)
	{
		String tLinha;

		while (true)
		{
			try
			{
				printMessage(message);
				tLinha = readLine().trim();
				if (tLinha.equals(""))
					return 0L;
				return Long.parseLong(tLinha);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not an long. Please try again!");
			}
		}
	}

	public int readInt()
	{
		return readInt("");
	}

	public int readInt(String message)
	{
		String tLinha;

		while (true)
		{
			try
			{
				printMessage(message);
				tLinha = readLine().trim();
				if (tLinha.equals(""))
					return 0;
				return Integer.parseInt(tLinha);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not an int. Please try again!");
			}
		}
	}

	public short readShort()
	{
		return readShort("");
	}

	public short readShort(String message)
	{
		String tLinha;

		while (true)
		{
			try
			{
				printMessage(message);
				tLinha = readLine().trim();
				if (tLinha.equals(""))
					return (short) 0;
				return Short.parseShort(tLinha);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not an short. Please try again!");
			}
		}
	}

	public byte readByte()
	{
		return readByte("");
	}

	public byte readByte(String message)
	{
		String tLinha;

		while (true)
		{
			try
			{
				printMessage(message);
				tLinha = readLine().trim();
				if (tLinha.equals(""))
					return (byte) 0;
				return Byte.parseByte(tLinha);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Not an byte. Please try again!");
			}
		}
	}

	public Date readDate()
	{
		return this.readDate("", "dd/MM/yyyy");
	}

	public Date readDate(String message)
	{
		return this.readDate(message, "dd/MM/yyyy");
	}

	public Date readDate(String message, String format)
	{
		dateFormatter.applyPattern(format);
		String tLinha;

		while (true)
		{
			try
			{
				printMessage(message);
				tLinha = readLine().trim();
				return dateFormatter.parse(tLinha);
			}
			catch (ParseException e)
			{
				System.out.println("Data invalida. Tente novamente!");
			}
		}
	}
	
	public boolean readBoolean()
	{
		return Boolean.parseBoolean(this.readString());
	}
	
	public boolean readBoolean(String message)
	{
		return Boolean.parseBoolean(this.readString(message));
	}
	
	/**
	 * Lê uma data no formato dd/MM/yyyy e retorna objeto LocalDate
	 * @param mensagem
	 * @return
	 */
	public LocalDate readLocalDate(String mensagem)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String tLinha = "";
		while (true)
		{
			try
			{
				printMessage(mensagem);
				tLinha = readLine().trim();
				return LocalDate.parse(tLinha, dtf);
			}
			catch (DateTimeParseException e)
			{
				System.out.println("Data invalida. Tente novamente!");
			}
		}
	}

}