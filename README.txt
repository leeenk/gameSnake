=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: leenk
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D array

  2. Inheritance / Subtyping

  3. IO

  4. JUit Testing

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.

  1. Block
  - An abstract class that contains the fields and functionality for the block,
  that are the components for the game objects. It includes position, width and height,
  getter and setter methods for them, and bumped method for when each block collides.
  It also contains abstract method draw() for each subclass to implement. It serves
  as a building block of the components.
  2. AppleBlock
  - A subclass of Block. It inputs an apple image.
  3. SnakeBlock
  - A subclass of Block. It is an element for Snake body. It draws a circle for each
  body element.
  4. SquareBlock
  - A subclass of Block. It is a placeholder for the grid, game board.
  5. Snake
  - A class that represents snake body. Body is a linked list of SnakeBlock. All the
  functions that involve Snake movement is here, such as move(), snake bumping into own body,
  snake bumping into an apple, snake growing in length, etc.
  6. GameBoard
  - A class for a game board grid represented as 2d array. Each 2d array element is
  a Block, and it fills the board with the different block like SnakeBlock and AppleBlock.
  This is where game is played based on the Timer object.
  7. RunSnake
  - A class for linking the Snake functionality with the UI components like buttons.
  8. Direction
  - An enum class for direction.
  9. Game
  - A class for main method, running the game.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?

    - I kept having Null Pointer Error for the head of the Snake. It was because
    in Snake class Direction was not initialized and my move() function would just
    add the null new head as the newHead in the Snake body. After that, I added
    a helper function for fillGrid() to fill the grid according to the position changes.

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?

  - I think I would reduce the redundancy of declaring px and py constantly and
  find a way to simplify accessing them. I think the connection between 2D array and the
  game grid that animates the object (Graphics) was difficult, but I want to efficiently
  refactor.



========================
=: External Resources :=
========================

- Cite any external resources (images, tutorials, etc.) that you may have used 
  while implementing your game.

  1. Apple Icon image: https://www.iconpacks.net/free-icon/apple-2327.html

