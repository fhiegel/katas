# Game Of Life
> Difficulty - Medium 
### Problem Description

This Kata is about calculating the next generation of Conway’s game of life,
given any starting position.

Your task is to write a program to calculate the next generation of Conway's game of life, 
given any starting position. 
You start with a two dimensional grid of cells, where each cell is either alive or dead.
The grid is finite, and no life can exist off the edges.

When calculating the next generation of the grid, follow these four rules:

1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
2. Any live cell with more than three live neighbours dies, as if by overcrowding.
3. Any live cell with two or three live neighbours lives on to the next generation.
4. Any dead cell with exactly three live neighbours becomes a live cell.

### Clues

The input starting position could be a text file that looks like this:

```
Generation 1:
4 8
........
....*...
...**...
........
```

And the output could look like this:

```
Generation 2:
4 8
........
...**...
...**...
........
```
The input format is similar to that in Kata `Minesweeper` , and is easily parsed in most 
languages.