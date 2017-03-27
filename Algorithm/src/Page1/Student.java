package Page1;

public class Student implements Comparable<Student>{
	
	String name;
	
	int score;
	
	boolean operator(Student other){
		return score<other.score;
	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}


	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return score-o.score;
	}

	
	
	
}
