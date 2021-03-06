import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.print("Type input file: ");
			while (!FilesManager.setFile(input.readLine()));
			if (FilesManager.getFileDirectory().endsWith(".mp4"))
			{
				if (Mp4.checkDuration())
				{
					while (!Mp4.setNewDuration(input.readLine()));
					FilesManager.createFile();
				}
			} else if (FilesManager.getFileDirectory().endsWith(".webm"))
				if (Webm.checkFile())
				{
					while (!Webm.manipulationMode(input.readLine()));
					FilesManager.createFile();
				}

		} while (input.readLine().equals("y"));
		input.close();
	}
}
