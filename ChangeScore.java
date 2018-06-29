package cn.kgc;

import java.util.Scanner;

//修改成绩类
public class ChangeScore {

	// 遍历学生，如果有一个学生份数低于60，则其分数+2;

	public void upScore(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			if (students[i].score < 60) {
				students[i].score += 2;
			}
		}
	}

	// 显示所有学生分数
	public void showScore(Student[] students) {
		for (Student student : students) {
			student.showInfo();
		}
	}
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num;
		String name;
		int score;
		System.out.println("请定义学生人数：");
		num = input.nextInt();
		Student[] student = new Student[num];
		for (int i = 0; i < student.length; i++) {
			System.out.println("输入第" + (i + 1) + "位学生姓名：");
			name = input.next();
			System.out.println("输入第" + (i + 1) + "位学生分数：");
			score = input.nextInt();
			student[i] = new Student(name, score);
		}

		ChangeScore cs = new ChangeScore();
		System.out.println("----------------更改成绩前---------------");
		cs.showScore(student);
		System.out.println("\n----------------更改成绩后---------------");
		cs.upScore(student);
		cs.showScore(student);
	}
}
