import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Poker {
    private List<String> hands;

    Poker(List<String> hands) {
        this.hands = hands;
    }

    List<String> getBestHands() {
        List<String> bestHands = new ArrayList<>();
        Category bestCategory = null;
        for (String hand : hands) {
            Category category = new Category(hand);
            int cmp = (bestCategory == null) ? -1 : category.compareTo(bestCategory);
            if (cmp == 0) {
                bestHands.add(hand);
            } else if (cmp < 0) {
                bestHands.clear();
                bestHands.add(hand);
                bestCategory = category;
            }
        }
        return bestHands;
    }
}


class Category implements Comparable<Category> {
    private List<Card> cards;
    private int rank;
    private List<Integer> candidates;

    Category(String hand) {
        cards = Arrays.stream(hand.split(" "))
                      .map(Card::new)
                      .collect(Collectors.toList());
        cards.sort(Comparator.comparingInt(Card::getValue)
                             .reversed());

        if (isStraightFlush()) {
            rank = 1;

            if (isAceToFive()) {
                candidates = Collections.singletonList(5);
            } else {
                candidates = Collections.singletonList(cards.get(0).value);
            }
        } else if (isSquare()) {
            rank = 2;

            if (cards.get(0).value == cards.get(3).value) {
                candidates = Arrays.asList(cards.get(0).value, cards.get(4).value);
            } else {
                candidates = Arrays.asList(cards.get(4).value, cards.get(0).value);
            }
        } else if (isFull()) {
            rank = 3;

            if (cards.get(0).value == cards.get(2).value && cards.get(3).value == cards.get(4).value) {
                candidates = Arrays.asList(cards.get(0).value, cards.get(3).value);
            } else {
                candidates = Arrays.asList(cards.get(2).value, cards.get(0).value);
            }
        } else if (isFlush()) {
            rank = 4;

            candidates = Arrays.asList(cards.get(0).value, cards.get(1).value, cards.get(2).value, cards.get(3).value, cards.get(4).value);
        } else if (isStraight()) {
            rank = 5;

            if (isAceToFive()) {
                candidates = Collections.singletonList(5);
            } else {
                candidates = Collections.singletonList(cards.get(0).value);
            }
        } else if (isThree()) {
            rank = 6;

            if (cards.get(0).value == cards.get(2).value) {
                candidates = Arrays.asList(cards.get(0).value, cards.get(3).value, cards.get(4).value);
            } else if (cards.get(1).value == cards.get(3).value) {
                candidates = Arrays.asList(cards.get(1).value, cards.get(0).value, cards.get(4).value);
            } else {
                candidates = Arrays.asList(cards.get(2).value, cards.get(0).value, cards.get(1).value);
            }
        } else if (isDoublePair()) {
            rank = 7;

            if (cards.get(0).value == cards.get(1).value && cards.get(2).value == cards.get(3).value) {
                candidates = Arrays.asList(cards.get(0).value, cards.get(2).value, cards.get(4).value);
            } else if (cards.get(0).value == cards.get(1).value && cards.get(3).value == cards.get(4).value) {
                candidates = Arrays.asList(cards.get(0).value, cards.get(3).value, cards.get(2).value);
            } else {
                candidates = Arrays.asList(cards.get(1).value, cards.get(3).value, cards.get(0).value);
            }
        } else if (isOnePair()) {
            rank = 8;

            if (cards.get(0).value == cards.get(1).value) {
                candidates = Arrays.asList(cards.get(0).value, cards.get(2).value, cards.get(3).value, cards.get(4).value);
            } else if (cards.get(1).value == cards.get(2).value) {
                candidates = Arrays.asList(cards.get(1).value, cards.get(0).value, cards.get(3).value, cards.get(4).value);
            } else if (cards.get(2).value == cards.get(3).value) {
                candidates = Arrays.asList(cards.get(2).value, cards.get(0).value, cards.get(1).value, cards.get(4).value);
            } else {
                candidates = Arrays.asList(cards.get(3).value, cards.get(0).value, cards.get(1).value, cards.get(2).value);
            }
        } else {
            rank = 9;

            candidates = Arrays.asList(cards.get(0).value, cards.get(1).value, cards.get(2).value, cards.get(3).value, cards.get(4).value);
        }
    }

    private boolean isFull() {
        return (cards.get(0).value == cards.get(2).value && cards.get(3).value == cards.get(4).value) || (
                cards.get(0).value == cards.get(1).value && cards.get(2).value == cards.get(4).value);
    }

    private boolean isThree() {
        return cards.get(0).value == cards.get(2).value || cards.get(1).value == cards.get(3).value || cards.get(2).value == cards.get(
                4).value;
    }

    private boolean isAceToFive() {
        return cards.get(0).value == 14 && cards.get(1).value == 5 && cards.get(2).value == 4 && cards.get(3).value == 3
                && cards.get(4).value == 2;
    }

    private boolean isStraight() {
        return IntStream.rangeClosed(0, 3)
                        .allMatch(i -> cards.get(i).value - cards.get(i + 1).value == 1) || isAceToFive();
    }

    private boolean isSquare() {
        return cards.get(0).value == cards.get(3).value || cards.get(1).value == cards.get(4).value;
    }

    private boolean isFlush() {
        return cards.stream()
                    .map(card -> card.suit)
                    .collect(Collectors.toSet())
                    .size() == 1;
    }

    private boolean isStraightFlush() {
        return isStraight() && isFlush();
    }

    private boolean isOnePair() {
        return IntStream.rangeClosed(0, 3)
                        .anyMatch(i -> cards.get(i).value == cards.get(i + 1).value);
    }

    private boolean isDoublePair() {
        return (cards.get(0).value == cards.get(1).value && cards.get(2).value == cards.get(3).value) || (
                cards.get(0).value == cards.get(1).value && cards.get(3).value == cards.get(4).value) || (
                cards.get(1).value == cards.get(2).value && cards.get(3).value == cards.get(4).value);
    }

    @Override
    public int compareTo(Category other) {
        if (rank != other.rank) {
            return rank - other.rank;
        } else {
            for (int i = 0; i < candidates.size(); i++) {
                int diff = other.candidates.get(i) - candidates.get(i);
                if (diff != 0) {
                    return diff;
                }
            }
            return 0;
        }
    }
}


class Card {
    char suit;
    int value;

    Card(String s) {
        suit = s.charAt(s.length() - 1);

        char ch = s.charAt(s.length() - 2);
        if (ch >= '2' && ch <= '9') {
            value = ch - '0';
        } else if (ch == '0') {
            value = 10;
        } else if (ch == 'J') {
            value = 11;
        } else if (ch == 'Q') {
            value = 12;
        } else if (ch == 'K') {
            value = 13;
        } else if (ch == 'A') {
            value = 14;
        }
    }

    int getValue() {
        return value;
    }
}