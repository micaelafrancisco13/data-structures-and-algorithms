package com.assessments.deckshuffler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckShuffler {
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

        // 3. Give each player a card
        List<Player> players = new ArrayList<>(3);
        for (int count = 1; count <= 5; ++count) {
            var player = new Player();
            player.setId(count);
            players.add(player);
        }

        System.out.println("\n--- Player Cards ---");
        var round = 1;
        while (players.size() <= deck.size()) {
            System.out.println("Round " + (round) + ":");
            players.forEach(player -> {
                var card = deck.removeFirst();
                player.getCards().add(card);
                System.out.println("Player " + player.getId() + " got " + card);
            });
            ++round;
            System.out.println(' ');
        }
        System.out.println("Remaining cards: " + deck.size());

        System.out.println("\n--- Cards of Each Player ---");
        players.forEach(player -> {
            var cards = player.getCards();
            System.out.println("Player " + player.getId() + ":");
            cards.forEach(System.out::println);
            System.out.println(' ');
        });

        System.out.println("--- End of Game ---");
    }
}
