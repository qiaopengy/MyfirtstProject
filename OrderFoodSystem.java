import java.util.Scanner;

public class OrderFoodSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// ��Ʒ���۸񡢵�����
		String[] dishNames = { "���մ���", "������˿", "���Ӽ���", "ʱ������", "���Ŷ���" };
		double[] prices = { 38.0, 20.0, 35.0, 10.00, 21.0 };
		int[] praiseNums = new int[5];
		// ��ʼ���������ڴ洢������Ϣ,��һ������ɾ���á�
		String[] names = new String[4];// ���涩��������
		String[] dishMegs = new String[4];// ������ѡ��Ʒ��
		int[] dishNums = new int[4];// ������ѡ��Ʒ����
		int[] times = new int[4];// �����Ͳ�ʱ��
		String[] addresses = new String[4];// �����Ͳ͵�ַ
		int[] states = new int[5];// ���涩��״̬��0��ʾ��Ԥ����1��ʾ�����
		double[] sumPrices = new double[4];// ���涩�����ܽ��

		// ��ʼ��2��������Ϣ

		names[0] = "����";
		dishMegs[0] = "���Ӽ���";
		dishNums[0] = 2;
		times[0] = 12;
		addresses[0] = "�ϴ��117��";
		states[0] = 0;
		sumPrices[0] = 70.0;

		names[1] = "��ͷǿ";
		dishMegs[1] = "���Ŷ���";
		dishNums[1] = 1;
		times[1] = 19;
		addresses[1] = "���·2��";
		states[1] = 1;
		sumPrices[1] = 25.0;

		/* ʵ�ֲ˵��л� */
		System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
		int num = 1;// �û�����0�������˵������˳�ϵͳ
		boolean isQuit = false;// ����û��Ƿ��˳�ϵͳ��trueΪ�˳�
		try {
			do {
				System.out.println("************************");
				System.out.println("1����Ҫ����");
				System.out.println("2���鿴����");
				System.out.println("3��ǩ�ն���");
				System.out.println("4��ɾ������");
				System.out.println("5����Ҫ����");
				System.out.println("6���˳�ϵͳ");
				System.out.println("************************");
				System.out.print("��ѡ��");
				num = input.nextInt();
				switch (num) {
				case 1:
					System.out.println("***��Ҫ����***");
					boolean isAdd = false;// ��������Ƿ�������
					for (int i = 0; i < names.length; i++) {
						if (names[i] == null) {
							isAdd = false;
							System.out.println("���" + "\t" + "����" + "\t" + "����" + "\t" + "������");
							for (int j = 0; j < dishNames.length; j++) {
								System.out.println(
										(j + 1) + "\t" + dishNames[j] + "\t" + prices[j] + "Ԫ" + "\t" + praiseNums[j]);
							}
							System.out.print("��ѡ��Ҫ��Ĳ�Ʒ��ţ�");
							int chooseDish = input.nextInt();
							String dishMeg = dishNames[chooseDish - 1];
							System.out.print("��ѡ����Ҫ�ķ�����");
							int number = input.nextInt();
							System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10����20��������Ͳͣ���");
							int time = input.nextInt();
							while (time < 10 || time > 20) {
								System.out.print("��������������10-20�������");
								time = input.nextInt();
							}
							System.out.print("�����붩����������");
							String name = input.next();
							System.out.print("�������Ͳ͵�ַ��");
							String address = input.next();

							System.out.println("���ͳɹ���");
							System.out.println("�������ǣ�" + dishNames[chooseDish - 1] + number + "��");
							System.out.println("�Ͳ�ʱ�䣺" + time + "��");
							double sumPrice = prices[chooseDish - 1] * number;// ����ͷ�
							double sendMoney = (sumPrice >= 50) ? 0 : 5;// ��Ԫ������ж��Ͳͷ�0��5
							System.out.println("�ͷѣ�" + sumPrice + "Ԫ��" + "�Ͳͷ�" + sendMoney + "Ԫ��" + "�ܼƣ�"
									+ (sumPrice + sendMoney) + "Ԫ��");
							names[i] = name;
							dishMegs[i] = dishMeg;
							times[i] = time;
							dishNums[i] = number;
							addresses[i] = address;
							sumPrices[i] = sumPrice + sendMoney;
							break;
						}
						if (isAdd) {
							System.out.println("�ʹ�������");
						}
					}
					break;
				case 2:
					System.out.println("***�鿴�ʹ�***");
					System.out.println("���\t������\t��Ʒ����\t��Ʒ����\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
					for (int i = 0; i < names.length; i++) {
						if (names[i] != null) {
							String state = (states[i] == 0) ? "��Ԥ��" : "�����";
							System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + dishNums[i] + "��"
									+ "\t" + times[i] + "\t" + addresses[i] + "\t" + sumPrices[i] + "Ԫ" + "\t" + state);
						}
					}
					break;
				case 3:
					System.out.println("***ǩ�ն���***");
					boolean isSignFind = false;
					System.out.println("���\t������\t��Ʒ����\t��Ʒ����\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
					for (int i = 0; i < names.length; i++) {
						if (names[i] != null) {
							String state = (states[i] == 0) ? "��Ԥ��" : "�����";
							System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + dishNums[i] + "��"
									+ "\t" + times[i] + "\t" + addresses[i] + "\t" + sumPrices[i] + "Ԫ" + "\t" + state);
						}
					}
					System.out.print("��ѡ��Ҫǩ�յĶ�����ţ�");
					int sign = input.nextInt();
					for (int i = 0; i < names.length; i++) {
						if (names[i] != null && states[i] == 0 && sign == i + 1) {
							states[i] = 1;
							System.out.println("����ǩ�ճɹ���");
							isSignFind = true;// ������ҵ��Ķ���
						} else if (names[i] != null && states[i] == 1 && sign == i + 1) {
							System.out.println("��ѡ��Ķ��������ǩ�գ������ٴ�ǩ�գ�");
							isSignFind = true;// ������ҵ��Ķ���
						}
					}
					if (!isSignFind) {
						System.out.println("��ѡ��Ķ��������ڣ�");
					}
					break;
				case 4:
					System.out.println("***ɾ������***");
					boolean isDelFind = false;
					System.out.println("���\t������\t��Ʒ����\t��Ʒ����\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
					for (int i = 0; i < names.length; i++) {
						if (names[i] != null) {
							String state = (states[i] == 0) ? "��Ԥ��" : "�����";
							System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + dishNums[i] + "��"
									+ "\t" + times[i] + "\t" + addresses[i] + "\t" + sumPrices[i] + "Ԫ" + "\t" + state);
						}
					}
					System.out.print("������Ҫɾ���Ķ�����ţ�");
					int delID = input.nextInt();
					for (int i = 0; i < names.length; i++) {
						// ����״ֵ̬�ж��ܲ���ɾ����ֻ������ɵĲ���ɾ��
						if (names[i] != null && states[i] == 1 && delID == i + 1) {
							isDelFind = true;
							for (int j = delID - 1; j < names.length - 1; j++) {
								names[j] = names[j + 1];
								dishMegs[j] = dishMegs[j + 1];
								dishNums[j] = dishNums[j + 1];
								times[j] = times[j + 1];
								addresses[j] = addresses[j + 1];
								states[j] = states[j + 1];
								sumPrices[j] = sumPrices[j + 1];
							}
							// �����һλ���
							names[names.length - 1] = null;
							dishMegs[names.length - 1] = null;
							dishNums[names.length - 1] = 0;
							times[names.length - 1] = 0;
							addresses[names.length - 1] = null;
							states[names.length - 1] = 0;
							sumPrices[names.length - 1] = 0;
							System.out.println("ɾ�������ɹ���");
							break;
						} else if (names[i] != null && states[i] == 0 && delID == i + 1) {
							isDelFind = true;
							System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
							break;
						}
					} // δ�ҵ��Ķ�������ɾ��
					if (!isDelFind) {
						System.out.println("��Ҫɾ���Ķ��������ڣ�");
					}
					break;
				case 5:
					System.out.println("***��Ҫ����***");
					// ��ʾ��Ʒ��Ϣ
					System.out.println("���\t����\t����");
					for (int i = 0; i < dishNames.length; i++) {
						String priaiseNum = (praiseNums[i] > 0) ? praiseNums[i] + "��" : "";
						System.out.println((i + 1) + "\t" + dishNames[i] + "\t" + prices[i] + "Ԫ" + priaiseNum);
					}
					System.out.print("��ѡ����Ҫ���޵Ĳ�Ʒ��ţ�");
					int number = input.nextInt();
					praiseNums[number - 1]++;
					System.out.println("���޳ɹ�");
					break;
				case 6:// �˳�ϵͳ
					isQuit = true;
					break;
				default:// �˳�ϵͳ
					System.out.println("�Ƿ�������");
					isQuit = true;
					break;
				}

				// ����������
				if (!isQuit) {
					System.out.print("����0�����ϲ㣬�����������ֽ���ʹ��:");
					num = input.nextInt();
				} else {
					break;
				}
			} while (num == 0);
			try {
				System.out.println("3����˳�ϵͳ");
				Thread.sleep(1000);
				System.out.println("2����˳�ϵͳ");
				Thread.sleep(1000);
				System.out.println("1����˳�ϵͳ");
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ϵͳ���˳���ллʹ�ã��ټ���");
			input.close();
		} catch (Exception e) {
			System.out.println("�Ƿ�������ϵͳ����");
			main(args);
		}
	}

}