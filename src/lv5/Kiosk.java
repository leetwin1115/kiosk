package lv5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속
    private final List<Menu> mainMenus;
    private final Scanner scanner = new Scanner(System.in);
    //생
    public Kiosk(List<Menu> mainMenus) {
        this.mainMenus = mainMenus;
    }
    //기
    public void start() {
        while (true) {
            displayMainMenu();
            int categoryChoice = scanner.nextInt();

            if (categoryChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (categoryChoice > 0 && categoryChoice <= mainMenus.size()) {
                Menu selectedMenu = mainMenus.get(categoryChoice - 1);
                displayProductMenu(selectedMenu);
            } else {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < mainMenus.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, mainMenus.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 프로그램 종료");
        System.out.print("\n카테고리를 선택해주세요: ");
    }

    private void displayProductMenu(Menu menu) {
        System.out.printf("\n[ %S MENU ]\n", menu.getCategoryName());
        List<MenuItem> items = menu.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.printf("%d. %-15s | W %.1f | %s\n", i + 1, item.getName(), item.getPrice(), item.getDescription());
        }
        System.out.println("0. 뒤로가기");
        System.out.print("\n상품을 선택해주세요: ");

        int productChoice = scanner.nextInt();
        if (productChoice > 0 && productChoice <= items.size()) {
            MenuItem selectedItem = items.get(productChoice - 1);
            System.out.printf("선택한 메뉴: %s | W %.1f | %s\n", selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());
        }
    }
}