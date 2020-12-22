public class Mp4
{
	private static String finalHexDigits;

	public static boolean checkDuration()
	{
		if (FilesManager.getHexDigits().contains("6D766864"))
		{
			int index = FilesManager.getHexDigits().indexOf("6D766864") + 8 + 32;
			String duration = FilesManager.getHexDigits().substring(index, index + 8);
			if (Converter.tryParseInt(duration, 16))
			{
				String value = String.valueOf(Integer.parseInt(duration, 16)); // ERRORE
				if (value.length() > 3)
				{
					System.out.println("Duration is: " + value.substring(0, value.length() - 3) + " seconds");
					System.out.print("Enter the new duration: ");
					return true;
				} else
					System.out.print("video too short | retry(y/n)?");
			} else
				System.out.print("can't convert digits | retry(y/n)? ");
		} else
			System.out.print("can't manipulate video | retry(y/n)? ");
		return false;
	}

	public static boolean setNewDuration(String newDuration)
	{
		if (Converter.tryParseInt(newDuration + "000"))
		{
			if (Integer.parseInt(newDuration) > 0)
			{
				String duration = Integer.toHexString(Integer.parseInt(newDuration + "000")).toUpperCase();
				for (int i = duration.length(); i < 8; i++)
					duration = "0" + duration;
				finalHexDigits = FilesManager.getHexDigits().substring(0, (FilesManager.getHexDigits().indexOf("6D766864") + 8 + 32)) + duration
						+ FilesManager.getHexDigits().substring(FilesManager.getHexDigits().indexOf("6D766864") + 16 + 32);

			} else if (Integer.parseInt(newDuration) < 0)
			{
				String duration = Integer.toHexString(Integer.parseInt(newDuration)).toUpperCase();
				finalHexDigits = FilesManager.getHexDigits().substring(0, (FilesManager.getHexDigits().indexOf("6D766864") + 8 + 28)) + "0001" + duration
						+ FilesManager.getHexDigits().substring(FilesManager.getHexDigits().indexOf("6D766864") + 16 + 32);
			} else
			{
				System.out.println("don't type 0!");
				return false;
			}
			return true;
		} else
			System.out.print("Bad number, type again: ");
		return false;
	}

	public static String getFinalHexDigits()
	{
		return finalHexDigits;
	}
}
