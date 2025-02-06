package hw05;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fileIn = new File("E:\\images\\TSS_storeJet.jpg");
		File fileOut = new File(fileIn.getName());
		try {
			FileOperationService.fileCopy(fileIn, fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File folderIn = new File("E:\\images\\");
		File folderOut = new File("test");
		folderOut.mkdirs();
		try {
			FileOperationService.folderCopy(folderIn, folderOut, "jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
