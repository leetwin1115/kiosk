package lv3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    //속
    private final List<MenuItem> menuItems;
    private final Scanner scanner = new Scanner(System.in);

    //생
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    //기
    public void start(){
        while (true){
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
}