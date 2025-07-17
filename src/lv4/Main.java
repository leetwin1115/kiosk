package lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu burgurMenu = new Menu("Burgur");
        burgurMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgurMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgurMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포에티오 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgurMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu dringksMenu = new Menu("Dringks");
        dringksMenu.addMenuItem(new MenuItem("Coke", 2.5, "코카콜라"));
        dringksMenu.addMenuItem(new MenuItem("Sprite", 2.5, "스프라이트"));
        dringksMenu.addMenuItem(new MenuItem("Milk shake", 3.9, "밀크셰이크"));

        Menu dessertMenu = new Menu("Dessert");
        dessertMenu.addMenuItem(new MenuItem("Ice cream", 3.0, "아이스크림"));

        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(burgurMenu);
        mainMenus.add(dringksMenu);
        mainMenus.add(dessertMenu);

        Scanner scanner = new Scanner(System.in);
        Kiosk kiosk = new Kiosk(mainMenus);
        kiosk.start();
    }
}