package UserInterface;

import TasksExceptions.DateTaskException;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task implements Serializable {


    private static final long serialVersionUID = -5190845017605120819L;
    private String taskName;
    private String taskDate;
    private String releaseDate;
    private static int count;
    private int id;
    public void setReleaseDate(String releaseDate) throws DateTaskException {
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher matcher = pattern.matcher(releaseDate);
        if (matcher.matches())
        {
            this.releaseDate = releaseDate;
        }
        else
        {
            throw new DateTaskException("Invalid date format");
        }


    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Task.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task(String taskName, String taskDate, String releaseDate) throws DateTaskException {


        setReleaseDate(releaseDate);
        this.taskName = taskName;
        this.id = ++count;
        this.taskDate = taskDate;

    }
    public void print()
    {
        System.out.printf("Task#%3d Task name - %-20s   |   Task date - %s   |    Release date - %s ",id,taskName,taskDate,releaseDate);
    }




}
