package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포에티오 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (true) {
            System.out.println("[ SHAKESHAKE MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.printf("%d. %-15s | W %.1f | %s\n", i + 1, item.name, item.price, item.exp);
            }
            System.out.println("0. 종료          | 프로그램 종료");

            System.out.println("\n메뉴를 입력해주세요.");
            int commend = scanner.nextInt();

            if (commend == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (commend > 0 && commend <= menuItems.size()){
                MenuItem selectedItem = menuItems.get(commend -1);
                System.out.printf("선택한 메뉴: %s | W %.1f | %s\n", selectedItem.name, selectedItem.price, selectedItem.exp);
            } else {
                System.out.println("잘못된 번호를 입력했습니다. 다시 시도해주세요.");
            }
        }
        scanner.close();
    }
}
