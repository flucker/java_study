package hw05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOperationService {
	public static void fileCopy(File fileIn, File fileOut) throws IOException {
		try (InputStream is = new FileInputStream(fileIn); OutputStream os = new FileOutputStream(fileOut)) {
			is.transferTo(os);
		}
	}

	public static long folderCopy(File folderIn, File folderOut, String extension) throws IOException {
		if (!folderIn.isDirectory() || !folderOut.isDirectory()) {
			throw new IllegalArgumentException("Only folders can be used");
		}
		long filesCount = 0;
		File[] files = folderIn.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().endsWith(extension)) {
				fileCopy(files[i], new File(folderOut, files[i].getName()));
				filesCount++;
			}
		}
		return filesCount;
	}
}
