public class Mp4
{
	private static String finalHexDigits;

	public static boolean checkDuration()
	{
		if (FilesManager.getHexDigits().contains("6D766864"))
		{
			int index = FilesManager.getHexDigits().indexOf("6D766864") + 8 + 32;
			String duration = FilesManager.getHexDigits().substring(index, index + 8);
			String value = String.valueOf(Integer.parseInt(duration, 16));
			if (value.length() > 3)
			{
				System.out.println("Duration is: " + value.substring(0, value.length() - 3) + " seconds");
				System.out.print("Enter the new duration: ");
				return true;
			} else
				System.out.println("video too short!");
		} else
			System.out.println("can't manipulate video!");
		return false;
	}

	public static boolean setNewDuration(String newDuration)
	{
		if (Converter.tryParseInt(newDuration + "000") && Integer.parseInt(newDuration) > 0)
		{
			String duration = Integer.toHexString(Integer.parseInt(newDuration + "000")).toUpperCase();
			for (int i = duration.length(); i < 8; i++)
				duration = "0" + duration;
			finalHexDigits = FilesManager.getHexDigits().substring(0, (FilesManager.getHexDigits().indexOf("6D766864") + 8 + 32)) + duration
					+ FilesManager.getHexDigits().substring(FilesManager.getHexDigits().indexOf("6D766864") + 16 + 32);
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
