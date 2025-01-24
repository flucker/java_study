package hw03;

public class Student extends Human {
	private int id;
	private String groupName;
	
	public Student(String name, String lastName, Gender gender, int id) {
		super(name, lastName, gender);
		this.id = id;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String lastName, Gender gender) {
		super(name, lastName, gender);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", groupName=" + groupName + ", name=" + this.getName() + ", lastName=" + this.getLastName() + "]";
	}
}
