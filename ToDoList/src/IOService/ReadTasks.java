package IOService;

import UserInterface.Task;

import java.io.*;
import java.util.List;

public class ReadTasks {
    public List<Task> read()
    {
        List<Task> tasks = null;

        try {
            FileInputStream fis  = new FileInputStream("D:\\projectGitHub\\Java\\ToDoList\\src\\IOService\\tasks.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            tasks = (List<Task>)ois.readObject();

        }
        catch (EOFException e)
        {
            System.out.println("This file empty...");
            System.out.println("Create new task...");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tasks;

    }
}
