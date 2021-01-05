package UserInterface;

import IOService.ReadTasks;
import IOService.WriteTasks;
import TasksExceptions.DateTaskException;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>() ;
while(true)
{


        ReadTasks rt = new ReadTasks();
        if (rt.read()!=null)
        {
            tasks =  rt.read();
            for (Task task:tasks) {
                task.print();
                System.out.println();
            }
            System.out.println();
        }




//
    System.out.println("Введите название задачи/Введите 0, если хотите выйти: ");
    Scanner scanner = new Scanner(System.in);

    String taskName = scanner.nextLine();
    if (taskName.equals("0"))
    {
        System.out.println("Программы завершена...");
        break;

    }
    System.out.println("Введите дату выполнения задачи(формат - dd/mm/yyyy): ");
    String releaseDate = scanner.nextLine();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    String taskDate = dateFormat.format(date);
    Task task = null;
    try {
        task = new Task(taskName,taskDate,releaseDate);
    } catch (DateTaskException e) {
        System.out.println(e.getMessage());
        System.out.println("Попробуйте заново...");
        continue;
    }
    tasks.add(task);

    WriteTasks wt = new WriteTasks();
    wt.write(tasks);
}













    }
}
