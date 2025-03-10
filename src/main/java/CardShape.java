public enum CardShape {
    CLOVER("clover"),
    SPADE("spade"),
    HEART("heart"),
    DIAMOND("diamond");

    private final String cardShape;

    CardShape(String cardShape) {
        this.cardShape = cardShape;
    }

    public String getCardShape() {
        return cardShape;
    }
}
