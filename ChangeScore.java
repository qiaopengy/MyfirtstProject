package cn.kgc;

import java.util.Scanner;

//�޸ĳɼ���
public class ChangeScore {

	// ����ѧ���������һ��ѧ����������60���������+2;

	public void upScore(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			if (students[i].score < 60) {
				students[i].score += 2;
			}
		}
	}

	// ��ʾ����ѧ������
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
		System.out.println("�붨��ѧ��������");
		num = input.nextInt();
		Student[] student = new Student[num];
		for (int i = 0; i < student.length; i++) {
			System.out.println("�����" + (i + 1) + "λѧ��������");
			name = input.next();
			System.out.println("�����" + (i + 1) + "λѧ��������");
			score = input.nextInt();
			student[i] = new Student(name, score);
		}

		ChangeScore cs = new ChangeScore();
		System.out.println("----------------���ĳɼ�ǰ---------------");
		cs.showScore(student);
		System.out.println("\n----------------���ĳɼ���---------------");
		cs.upScore(student);
		cs.showScore(student);
	}
}
