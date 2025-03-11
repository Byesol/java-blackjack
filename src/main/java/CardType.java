public enum CardType {
    ONE("1", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final String cardType;
    private final int cardPoint;

    CardType(String cardType, int cardPoint) {
        this.cardType = cardType;
        this.cardPoint = cardPoint;
    }

    public String getCardType() {
        return cardType;
    }

    public int getCardPoint() {
        return cardPoint;
    }
}
