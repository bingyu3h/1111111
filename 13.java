import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int taskId = 1;

        while (true) {
            System.out.println("\n欢迎使用待办事项应用");
            System.out.println("1. 查看所有任务");
            System.out.println("2. 添加任务");
            System.out.println("3. 删除任务");
            System.out.println("4. 标记任务为完成");
            System.out.println("5. 退出");
            System.out.print("请输入选项：");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 清空输入缓冲区

            if (choice == 1) {
                // 查看所有任务
                System.out.println("所有任务：");
                for (Task task : taskManager.getAllTasks()) {
                    System.out.println("ID: " + task.getId() + " | 描述: " + task.getDescription() + " | 状态: " + (task.isStatus() ? "完成" : "待办"));
                }
            } else if (choice == 2) {
                // 添加任务
                System.out.print("请输入任务描述：");
                String description = scanner.nextLine();
                Task task = new Task(taskId++, description);
                taskManager.addTask(task);
                System.out.println("任务已添加！");
            } else if (choice == 3) {
                // 删除任务
                System.out.print("请输入任务ID：");
                int id = scanner.nextInt();
                taskManager.removeTask(id);
                System.out.println("任务已删除！");
            } else if (choice == 4) {
                // 标记任务为完成
                System.out.print("请输入任务ID：");
                int id = scanner.nextInt();
                Task task = taskManager.getTaskById(id);
                if (task != null) {
                    task.markAsCompleted();
                    System.out.println("任务已标记为完成！");
                } else {
                    System.out.println("任务未找到！");
                }
            } else if (choice == 5) {
                // 退出
                break;
            } else {
                System.out.println("无效选项，请重新输入！");
            }
        }

        scanner.close();
    }
}
