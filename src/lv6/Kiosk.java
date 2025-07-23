package lv6;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.InputMismatchException;

public class Kiosk {
    //속
    private final List<Menu> mainMenus;
    private final Scanner scanner = new Scanner(System.in);
    private final Order order = new Order();

    //생
    public Kiosk(List<Menu> mainMenus) {
        this.mainMenus = mainMenus;
    }
    //기
    public void start() {
        while (true) {
            displayMainMenu();
            int choice = getUserInput();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (0 < choice && choice <= mainMenus.size()){
                handleProductMenu(mainMenus.get(choice-1));
            }else if (!order.isEmpty() && choice == mainMenus.size()+1){
                handleOrder();
            }else if (!order.isEmpty() && choice == mainMenus.size()+2){
                handleCancel();
            } else {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("\n아래 메뉴판을 보시고 메뉴를 골라 입력해주세요");
        System.out.println("[ MAIN MENU ]");
        AtomicInteger counter = new AtomicInteger(1);
        mainMenus.forEach(menu -> System.out.printf("%d. %s\n", counter.getAndIncrement(), menu.getCategoryName()));

        System.out.println("0. 종료      | 프로그램 종료");

        if (!order.isEmpty()){
            System.out.println("\n[ ORDER MENU ]");
            System.out.printf("%d. Orders      | 장바구니를 확인 후 주문합니다.\n", mainMenus.size()+1);
            System.out.printf("%d. Cancel      | 진행중인 주문을 취소합니다.\n", mainMenus.size()+2);
        }
        System.out.println("\n메뉴를 선택해주세요: ");
    }

    private void handleProductMenu(Menu menu){
        System.out.printf("\n[ %S MENU ]\n", menu.getCategoryName());

        AtomicInteger counter = new AtomicInteger(1);
        menu.getMenuItems().forEach(item ->
                System.out.printf("%d. %-15s | W %.1f | %s\n",
                        counter.getAndIncrement(), item.getName(), item.getPrice(), item.getExp())
        );
        System.out.println("0. 뒤로가기");
        System.out.print("\n상품을 선택해주세요:");

        int choice = getUserInput();
        if (choice > 0 && choice <= menu.getMenuItems().size()){
            MenuItem selectedItem = menu.getMenuItems().get(choice-1);
            confirmAddToCart(selectedItem);
        }
    }
    private void confirmAddToCart(MenuItem item){
        System.out.printf("\n\"%s | W %.1f | %s\"\n", item.getName(), item.getPrice(), item.getExp());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인          2.취소");

        int choice = getUserInput();
        if (choice == 1){
            order.addToCart(item);
        }
    }
    private void handleOrder(){
        System.out.println("\n아래와 같이 주문하시겠습니까?");
        System.out.println("[ Orders ]");

        order.getCartItems().forEach(item->
                System.out.printf("%-15s | W %.1f | %s\n", item.getName(), item.getPrice(), item.getExp())
        );

        double totalPrice = order.calculateTotalPrice();
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f\n", totalPrice);

        System.out.println("\n1. 주문       2. 메뉴판");
        int choice = getUserInput();
        if (choice == 1){
            checkDiscount(totalPrice);
        }
    }
    private void checkDiscount(double originalPrice) {
        System.out.println("\n할인적용 대상자입니까?");
        System.out.println("1. 예        2. 아니오");

        int choice = getUserInput();
        if (choice == 1) {
            handlePayment(originalPrice);
        } else {
            completeOrder(originalPrice);
        }
    }
    private void handlePayment(double originalPrice){
        System.out.println("\n할인 정보를 입력해주세요.");
        UserType[] userTypes = UserType.values();
        for (int i=0; i<userTypes.length; i++){
            System.out.printf("%d. %s : %.0f%%\n", i + 1, userTypes[i].getExp(), userTypes[i].getDiscountRate() * 100);
        }
        int choice = getUserInput();
        UserType selectedUserType = UserType.GENERAL;
        if (0 < choice && choice <= userTypes.length){
            selectedUserType = userTypes[choice -1];
        } else {
            System.out.println("잘못된 선택입니다. 일반 고객으로 처리합니다.");
        }
        double discoutRate = selectedUserType.getDiscountRate();
        double finalPrice = originalPrice * (1-discoutRate);

        completeOrder(finalPrice);
    }
    private void completeOrder(double finalPrice) {
        System.out.printf("\n주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", finalPrice);
        order.clearCart();
    }
    private void handleCancel(){
        System.out.println("\n진행중인 주문을 취소하겠습니까?");
        System.out.println("1. 확인         2. 취소");

        int choice = getUserInput();
        if (choice == 1){
            order.clearCart();
            System.out.println("진행중인 주문이 취소되었습니다.");
        }
    }
    private int getUserInput(){
        try{
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException e){
            scanner.nextLine();
            return -1;
        }
    }
}