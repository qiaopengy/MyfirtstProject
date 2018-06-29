package cn.kgc;

//学生类
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
		System.out.println(name + "的成绩是:" + score);
	}
}
