package students;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {
	public static void saveGroupToCSV(Group gr) throws IOException {
		try (PrintWriter pw = new PrintWriter(new File(gr.getGroupName() + ".csv"))) {
			String groupCSV = "";
			CSVStringConverter csvStringConverter = new CSVStringConverter();
			Student[] students = gr.getStudents();
			for (int i = 0; i < students.length; i++) {
				if (students[i] != null) {
					groupCSV += csvStringConverter.toStringRepresentation(students[i]) + System.lineSeparator();					
				}
			}			
			pw.print(groupCSV);
		}
	}

	public static Group loadGroupFromCSV(File file) throws IOException {
		try (Scanner scanner = new Scanner(file)) {
			CSVStringConverter converter = new CSVStringConverter();
			Group group = new Group(file.getName().split("\\.")[0]);
			while (scanner.hasNextLine()) {
				try {
					group.addStudent(converter.fromStringRepresentation(scanner.nextLine()));
				} catch (GroupOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return group;
		}
	}

	public static File findFileByGroupName(String groupName, File workFolder) throws FileNotFoundException {
		if (!workFolder.isDirectory()) {
			throw new IllegalArgumentException("Work folder is not directory");
		}
		File[] files = workFolder.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().equals(groupName + ".csv")) {
				return files[i];
			}
		}
		throw new FileNotFoundException();
	}
}
