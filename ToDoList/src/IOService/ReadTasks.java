package IOService;

import UserInterface.Task;

import java.io.*;
import java.util.List;

public class ReadTasks {
    public List<Task> read()
    {
        List<Task> tasks = null;

        try {
            FileInputStream fis  = new FileInputStream("D:\\Java projects\\ToDoList\\src\\IOService\\tasks.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            tasks = (List<Task>)ois.readObject();

        }
        catch (EOFException e)
        {
            System.out.println("В данном файле пока что нет тасков...");
            System.out.println("Заведите новый таск...");

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tasks;

    }
}
