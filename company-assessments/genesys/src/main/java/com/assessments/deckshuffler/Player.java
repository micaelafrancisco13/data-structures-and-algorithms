package com.assessments.deckshuffler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    private int id;
    private List<Card> cards = new ArrayList<>();
}
