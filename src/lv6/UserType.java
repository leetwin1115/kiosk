package lv6;

public enum UserType {
    PATRIOT("국가유공자", 0.10),
    SOLDIER("군인", 0.05),
    STUDENT("학생", 0.03),
    GENERAL("일반", 0.0);

    private final String exp;
    private final double discountRate;

    UserType(String exp, double discountRate) {
        this.exp = exp;
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
    public String getExp() {
        return exp;
    }
}
