package lv5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String categoryName) {
        this.categoryName = categoryName;
    }

    // 메뉴에 아이템 추가 (Setter 역할)
    public void addMenuItem(MenuItem item) {
        this.menuItems.add(item);
    }

    // Getters
    public String getCategoryName() {
        return this.categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }
}