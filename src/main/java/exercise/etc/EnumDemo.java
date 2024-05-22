package exercise.etc;

public enum EnumDemo {
    AMERICANO(0, "Americano"),
    LATTE(1, "Latte"),
    STRAWBERRY_ADE(2, "Strawberry Ade"),
    ESPRESSO(3, "Espresso");

    private final int menuNum;
    private final String menuName;

    EnumDemo(int menuNum, String menuName){
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public void selectMenu(){
        System.out.println(menuNum + ". " + menuName);
    }

    @Override
    public String toString() {
        return "EnumDemo{" +
                "menuNum=" + menuNum +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
