import java.util.Objects;
enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
final class PlayingCard {
    private final String rank;
    private final Suit suit;
    PlayingCard(String rank, Suit suit) { this.rank = rank; this.suit = suit; }
    public boolean equals(Object other) {
        if (!(other instanceof PlayingCard card)) return false;
        return rank.equals(card.rank) && suit == card.suit;
    }
    public int hashCode() { return Objects.hash(rank, suit); }
    public String toString() { return rank + " of " + suit; }
}
public class CardDemo {
    public static void main(String[] args) {
        PlayingCard ace = new PlayingCard("Ace", Suit.SPADES);
        PlayingCard sameAce = new PlayingCard("Ace", Suit.SPADES);
        System.out.println(ace);
        System.out.println("Same card value: " + ace.equals(sameAce));
    }
}
