package students;

public class CSVStringConverter implements StringConverter {

	@Override
	public String toStringRepresentation(Student student) {
		return student.getName() + "," + student.getLastName() + "," + student.getGender() + "," + student.getId();
	}

	@Override
	public Student fromStringRepresentation(String str) {
		String[] studentArray = str.split(",");
		return new Student(studentArray[0], studentArray[1], Gender.valueOf(studentArray[2]), Integer.valueOf(studentArray[3]));
	}

}
