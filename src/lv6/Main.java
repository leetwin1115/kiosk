package lv6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItem(new MenuItem("Coke", 2.5, "코카콜라"));
        drinksMenu.addMenuItem(new MenuItem("Sprite", 2.5, "스프라이트"));

        Menu dessertsMenu = new Menu("Desserts");
        dessertsMenu.addMenuItem(new MenuItem("Ice Cream", 3.0, "바닐라 아이스크림"));

        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(burgerMenu);
        mainMenus.add(drinksMenu);
        mainMenus.add(dessertsMenu);

        Kiosk kiosk = new Kiosk(mainMenus);
        kiosk.start();
    }
}