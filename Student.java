package cn.kgc;

//ѧ����
public class Student {
	String name;
	int score;


	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public void showInfo() {
		System.out.println(name + "�ĳɼ���:" + score);
	}
}
