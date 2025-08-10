package com.assessments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckShuffler {

    public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}

    public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    public record Card(Rank rank, Suit suit) {
        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

    public static void main(String[] args) {
        // 1. Create the deck
        // ArrayList preserves insertion order and does not sort by default.
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        System.out.println("--- Original, Natural Ordered Deck ---");
        System.out.println(deck.getFirst()); // ACE of CLUBS
        System.out.println(deck.get(51)); // KING of SPADES
        System.out.println("Deck size: " + deck.size());

        // 2. Shuffle the deck
        Collections.shuffle(deck);

        System.out.println("\n--- Shuffled Deck ---");
        System.out.println("Top card: " + deck.getFirst()); // A random card
        System.out.println("Bottom card: " + deck.get(51)); // Another random card
    }
}