package Inventory;

import java.util.LinkedList;
import java.util.List;

public class Backpack {
    private List<Item> listOfItems = new LinkedList<Item>();
    public void showBackpack()
    {
        for (Item it : listOfItems)
        {
            System.out.println(it);
        }

    }
    public void AddItem(Item item)
    {
        listOfItems.add(item);
    }
}
