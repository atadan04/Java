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
    System.out.println("Enter task name/Enter 0, if you want to leave ");
    System.out.println("Or enter \"delete\" to remove task: ");
    Scanner scanner = new Scanner(System.in);

    String taskName = scanner.nextLine();
    if (taskName.equals("0"))
    {
        System.out.println("Program completed...");
        break;

    }
    if(taskName.equals("delete"))
    {
        try{
            System.out.println("Enter number of task to remove it: ");
            int response = scanner.nextInt();
            deleteTask(tasks,response-1);
            System.out.println("Task deleted...");


            Task.setCount(Task.getCount()-1);
            Task temp = tasks.get(response-1);
            temp.setId(temp.getId()-1);

        }
        catch (IndexOutOfBoundsException e)
        {

        }
        finally {
            WriteTasks wt = new WriteTasks();
            wt.write(tasks);
        }

        continue;


    }
    System.out.println("Enter date of completion task (format - dd/mm/yyyy): ");

    String releaseDate = scanner.nextLine();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    String taskDate = dateFormat.format(date);
    Task task = null;
    try {
        task = new Task(taskName,taskDate,releaseDate);
    } catch (DateTaskException e) {
        System.out.println(e.getMessage());
        System.out.println("Try again...");
        continue;
    }
    tasks.add(task);

    WriteTasks wt = new WriteTasks();
    wt.write(tasks);
}

    }
    public static void deleteTask(List<Task> tasks,int index)
    {
        tasks.remove(index);
    }

}
