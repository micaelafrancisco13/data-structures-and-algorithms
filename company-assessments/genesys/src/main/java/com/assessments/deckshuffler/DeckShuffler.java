package com.assessments.deckshuffler;

import java.util.ArrayList;
import java.util.List;

public class DeckShuffler {
    private static final List<Card> deck = new ArrayList<>();
    private static final List<Suit> suits = List.of(Suit.values());
    private static final List<Rank> ranks = List.of(Rank.values());

    public static void main(String[] args) {
        // 1. Create the deck
        for (Suit suit : suits)
            for (Rank rank : ranks)
                deck.add(new Card(rank, suit));

        // 2. Shuffle the deck of cards
        shuffle(deck);

        // 3. Give each player a card
        List<Player> players = new ArrayList<>();
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

    private static <T> void shuffle(List<T> list) {
        for (int i = 0; i < list.size(); ++i) {
            int randomIndex = i + (int) (Math.random() * (list.size() - i));
            T current = list.get(i);
            T toSwap = list.get(randomIndex);
            list.set(randomIndex, current);
            list.set(i, toSwap);
        }
    }
}
