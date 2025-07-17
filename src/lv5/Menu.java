package lv5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //속
    private String categoryName;
    private List<MenuItem> menuItems = new ArrayList<>();

    //생
    public Menu(String categoryName) {
        this.categoryName = categoryName;
    }
    //기
    public void addMenuItem(MenuItem item) {
        this.menuItems.add(item);
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }
}