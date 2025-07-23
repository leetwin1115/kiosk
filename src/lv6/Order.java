package lv6;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> cart = new ArrayList<>();

    public void addToCart(MenuItem item) {
        cart.add(item);
        System.out.println("\n" + item.getName() + " 이(가) 장바구니에 추가되었습니다.");
    }
    public List<MenuItem> getCartItems(){
        return cart;
    }
    public double calculateTotalPrice() {
        return cart.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }
    public void clearCart(){
        cart.clear();
    }
    public boolean isEmpty() {
        return (cart.isEmpty());
    }
}
