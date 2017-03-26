# DeckOfCards
Practice problem to create a set of classes which represent a Deck of Cards, as in a game of poker.

### Design Concerns
- `Deck()` constructor
  - Best case time to create the `Deck` is O(n).
  - Candidate structures include: `Stack`, `Array`, `LinkedList`
- `dealOneCard()`
  - `dealOneCard()` aligns well with a data structure that has direct access to the `top` or `front` of itself.
  - Best case time O(1)
  - Candidate structures that provide this include: `Stack`, `Array`, `LinkedList`
    - `Array` only provides this if we additionally keep track of a `top` or `front` field.
- `shuffle()`
  - This method can run for an arbitrarily long amount of time, but we will limit its operations to the size of the Deck (52).
  - A very easy, efficient method for this is to iterate over the size of the Deck, randomly swapping two cards.
  - This results in O(n) runtime, where n is the size of the `Deck`.

- Decision
  - I opted to use an `Array` and keep an additional field called `top` to enable the `dealOneCard()` method.
  - `Array` future-proofs our application if we wish to enable accessAtIndex functionality.
  - It also meets the space-time criteria outlined above.

### JUnit Tests
- JUnit tests should work out of the box, as I've included the necessary .jar files in my code.
- Tests exist for the `Deck()` constructor, `dealOneCard()`, an auxiliary function `swapCards()`, and a mediocre test for `shuffle()`.
- Shuffle is difficult to test, since it involves random swaps. A deck could technically have been "shuffled" but still be in the same order as it was before the call to `shuffle()`.
