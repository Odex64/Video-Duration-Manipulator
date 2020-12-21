import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class FilesManager
{
	private static String hexDigits;
	private static String fileDir;

	public static boolean setFile(String dir) throws IOException
	{
		File file = new File(dir);
		if ((dir.endsWith(".mp4") || dir.endsWith(".webm")) && file.isFile() && file.exists())
		{
			fileDir = dir;
			hexDigits = Converter.bytesToHex(Files.readAllBytes(file.toPath()));
			return true;
		} else
			System.out.print("file doesn't exist / wrong extension \nType again: ");
		return false;
	}

	public static void createFile(String finalHexDigits) throws IOException
	{
		FileOutputStream bytesFile = new FileOutputStream(fileDir.substring(0, fileDir.lastIndexOf(".")) + " - EDIT.mp4");
		bytesFile.write(Converter.hexToBytes(finalHexDigits));
		bytesFile.flush();
		bytesFile.close();
	}

	public static String getHexDigits()
	{
		return hexDigits;
	}

	public static String getFileDirectory()
	{
		return fileDir;
	}
}
