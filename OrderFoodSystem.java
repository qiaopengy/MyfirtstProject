import java.util.Scanner;

public class OrderFoodSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 菜品、价格、点赞数
		String[] dishNames = { "红烧带鱼", "鱼香肉丝", "辣子鸡丁", "时令鲜蔬", "麻婆豆腐" };
		double[] prices = { 38.0, 20.0, 35.0, 10.00, 21.0 };
		int[] praiseNums = new int[5];
		// 初始化数组用于存储订单信息,多一个用于删除用。
		String[] names = new String[4];// 保存订餐人姓名
		String[] dishMegs = new String[4];// 保存所选菜品名
		int[] dishNums = new int[4];// 保存所选菜品份数
		int[] times = new int[4];// 保存送餐时间
		String[] addresses = new String[4];// 保存送餐地址
		int[] states = new int[5];// 保存订单状态：0表示已预订，1表示已完成
		double[] sumPrices = new double[4];// 保存订单的总金额

		// 初始化2个订单信息

		names[0] = "王大锤";
		dishMegs[0] = "辣子鸡丁";
		dishNums[0] = 2;
		times[0] = 12;
		addresses[0] = "南大街117号";
		states[0] = 0;
		sumPrices[0] = 70.0;

		names[1] = "光头强";
		dishMegs[1] = "麻婆豆腐";
		dishNums[1] = 1;
		times[1] = 19;
		addresses[1] = "解放路2号";
		states[1] = 1;
		sumPrices[1] = 25.0;

		/* 实现菜单切换 */
		System.out.println("欢迎使用“吃货联盟订餐系统”");
		int num = 1;// 用户输入0返回主菜单否则退出系统
		boolean isQuit = false;// 标记用户是否退出系统，true为退出
		try {
			do {
				System.out.println("************************");
				System.out.println("1、我要订餐");
				System.out.println("2、查看订单");
				System.out.println("3、签收订单");
				System.out.println("4、删除订单");
				System.out.println("5、我要点赞");
				System.out.println("6、退出系统");
				System.out.println("************************");
				System.out.print("请选择：");
				num = input.nextInt();
				switch (num) {
				case 1:
					System.out.println("***我要订餐***");
					boolean isAdd = false;// 检查数组是否已满。
					for (int i = 0; i < names.length; i++) {
						if (names[i] == null) {
							isAdd = false;
							System.out.println("序号" + "\t" + "菜名" + "\t" + "单价" + "\t" + "点赞数");
							for (int j = 0; j < dishNames.length; j++) {
								System.out.println(
										(j + 1) + "\t" + dishNames[j] + "\t" + prices[j] + "元" + "\t" + praiseNums[j]);
							}
							System.out.print("请选择要点的菜品编号：");
							int chooseDish = input.nextInt();
							String dishMeg = dishNames[chooseDish - 1];
							System.out.print("请选择需要的份数：");
							int number = input.nextInt();
							System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）：");
							int time = input.nextInt();
							while (time < 10 || time > 20) {
								System.out.print("输入有误，请输入10-20间的整数");
								time = input.nextInt();
							}
							System.out.print("请输入订餐人姓名：");
							String name = input.next();
							System.out.print("请输入送餐地址：");
							String address = input.next();

							System.out.println("订餐成功！");
							System.out.println("您定的是：" + dishNames[chooseDish - 1] + number + "份");
							System.out.println("送餐时间：" + time + "点");
							double sumPrice = prices[chooseDish - 1] * number;// 计算餐费
							double sendMoney = (sumPrice >= 50) ? 0 : 5;// 三元运算符判断送餐费0或5
							System.out.println("餐费：" + sumPrice + "元，" + "送餐费" + sendMoney + "元，" + "总计："
									+ (sumPrice + sendMoney) + "元。");
							names[i] = name;
							dishMegs[i] = dishMeg;
							times[i] = time;
							dishNums[i] = number;
							addresses[i] = address;
							sumPrices[i] = sumPrice + sendMoney;
							break;
						}
						if (isAdd) {
							System.out.println("餐袋已满！");
						}
					}
					break;
				case 2:
					System.out.println("***查看餐袋***");
					System.out.println("序号\t订餐人\t餐品名称\t餐品数量\t送餐时间\t送餐地址\t总金额\t订单状态");
					for (int i = 0; i < names.length; i++) {
						if (names[i] != null) {
							String state = (states[i] == 0) ? "已预订" : "已完成";
							System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + dishNums[i] + "份"
									+ "\t" + times[i] + "\t" + addresses[i] + "\t" + sumPrices[i] + "元" + "\t" + state);
						}
					}
					break;
				case 3:
					System.out.println("***签收订单***");
					boolean isSignFind = false;
					System.out.println("序号\t订餐人\t餐品名称\t餐品数量\t送餐时间\t送餐地址\t总金额\t订单状态");
					for (int i = 0; i < names.length; i++) {
						if (names[i] != null) {
							String state = (states[i] == 0) ? "已预订" : "已完成";
							System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + dishNums[i] + "份"
									+ "\t" + times[i] + "\t" + addresses[i] + "\t" + sumPrices[i] + "元" + "\t" + state);
						}
					}
					System.out.print("请选择要签收的订单序号：");
					int sign = input.nextInt();
					for (int i = 0; i < names.length; i++) {
						if (names[i] != null && states[i] == 0 && sign == i + 1) {
							states[i] = 1;
							System.out.println("订单签收成功！");
							isSignFind = true;// 标记已找到的订单
						} else if (names[i] != null && states[i] == 1 && sign == i + 1) {
							System.out.println("您选择的订单已完成签收，不能再次签收！");
							isSignFind = true;// 标记已找到的订单
						}
					}
					if (!isSignFind) {
						System.out.println("您选择的订单不存在！");
					}
					break;
				case 4:
					System.out.println("***删除订单***");
					boolean isDelFind = false;
					System.out.println("序号\t订餐人\t餐品名称\t餐品数量\t送餐时间\t送餐地址\t总金额\t订单状态");
					for (int i = 0; i < names.length; i++) {
						if (names[i] != null) {
							String state = (states[i] == 0) ? "已预订" : "已完成";
							System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + dishNums[i] + "份"
									+ "\t" + times[i] + "\t" + addresses[i] + "\t" + sumPrices[i] + "元" + "\t" + state);
						}
					}
					System.out.print("请输入要删除的订单序号：");
					int delID = input.nextInt();
					for (int i = 0; i < names.length; i++) {
						// 根据状态值判断能不能删除，只有已完成的才能删除
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
							// 将最后一位清空
							names[names.length - 1] = null;
							dishMegs[names.length - 1] = null;
							dishNums[names.length - 1] = 0;
							times[names.length - 1] = 0;
							addresses[names.length - 1] = null;
							states[names.length - 1] = 0;
							sumPrices[names.length - 1] = 0;
							System.out.println("删除订单成功！");
							break;
						} else if (names[i] != null && states[i] == 0 && delID == i + 1) {
							isDelFind = true;
							System.out.println("您选择的订单未签收，不能删除！");
							break;
						}
					} // 未找到的订单不能删除
					if (!isDelFind) {
						System.out.println("您要删除的订单不存在！");
					}
					break;
				case 5:
					System.out.println("***我要点赞***");
					// 显示菜品信息
					System.out.println("序号\t菜名\t单价");
					for (int i = 0; i < dishNames.length; i++) {
						String priaiseNum = (praiseNums[i] > 0) ? praiseNums[i] + "赞" : "";
						System.out.println((i + 1) + "\t" + dishNames[i] + "\t" + prices[i] + "元" + priaiseNum);
					}
					System.out.print("请选择您要点赞的菜品序号：");
					int number = input.nextInt();
					praiseNums[number - 1]++;
					System.out.println("点赞成功");
					break;
				case 6:// 退出系统
					isQuit = true;
					break;
				default:// 退出系统
					System.out.println("非法操作！");
					isQuit = true;
					break;
				}

				// 返回主界面
				if (!isQuit) {
					System.out.print("输入0返回上层，输入其他数字结束使用:");
					num = input.nextInt();
				} else {
					break;
				}
			} while (num == 0);
			try {
				System.out.println("3秒后退出系统");
				Thread.sleep(1000);
				System.out.println("2秒后退出系统");
				Thread.sleep(1000);
				System.out.println("1秒后退出系统");
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("系统已退出，谢谢使用，再见！");
			input.close();
		} catch (Exception e) {
			System.out.println("非法操作！系统重启");
			main(args);
		}
	}

}