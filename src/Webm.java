public class Webm
{
	private static int index;

	public static boolean checkFile()
	{
		if (FilesManager.getHexDigits().contains("2AD7B1"))
		{
			index = FilesManager.getHexDigits().indexOf("2AD7B1") + 6;
			index = FilesManager.getHexDigits().indexOf("4489", index) + 4;
			System.out.print("1: increasing video \n2: stuck video: ");
			return true;
		} else
			System.out.println("can't manipulate video!");
		return false;
	}

	public static void changeMetadata(int num)
	{
		if (num == 1)
			FilesManager.setHexDigits(FilesManager.getHexDigits().substring(0, index + 4) + "0001" + FilesManager.getHexDigits().substring(index + 8));
		else if (num == 2)
			FilesManager.setHexDigits(FilesManager.getHexDigits().substring(0, index) + "0000" + FilesManager.getHexDigits().substring(index + 4));
	}

	public static boolean manipulationMode(String value)
	{
		if (Converter.tryParseInt(value))
		{
			int num = Integer.parseInt(value);
			if (num > 0 && num <= 2)
			{
				changeMetadata(num);
				return true;
			}
		}
		System.out.print("wrong value ");
		return false;
	}
}
