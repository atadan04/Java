package IOService;

import UserInterface.Task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteTasks {
    public void write(List<Task> tasks)
    {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\projectGitHub\\Java\\ToDoList\\src\\IOService\\tasks.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tasks);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
