package hackerrank.preparationKit.Day3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TowerBreakers {

    public static void main(String[] args) {
        System.out.println(towerBreakers(2,6));
    }
    public static int towerBreakers(int n, int m) {

        int numOfTowers = n;
        int heightOfTower = m;

        if(heightOfTower == 1) {
            return 2;
        } else if(numOfTowers % 2 == 0) {
            return 2;
        } else if(numOfTowers % 2 == 1) {
            return 1;
        }

        int playerOne = 1;
        int playerTwo = 2;
        int winner = 0;

        //choose optimally ? -> which move do i choose?
        //why 4 not an option on first example?

        Map<Integer, List<Integer>> players = new HashMap<>();
        players.put(playerOne, new ArrayList<>(Arrays.asList(numOfTowers, heightOfTower)));
        players.put(playerTwo, new ArrayList<>(Arrays.asList(numOfTowers, heightOfTower)));

        int currentPlayer;
        currentPlayer = playerOne;
        while(true){

            List<Integer> currentPlayerTowersAndHeights = players.get(currentPlayer);

            int currentPlayerTowerHeight = currentPlayerTowersAndHeights.get(1);
            List<Integer> currentPlayerValidMoves = getValidMovesForPlayer(currentPlayerTowerHeight);
            if(currentPlayerValidMoves.isEmpty()){
                winner = currentPlayer == playerOne ? playerTwo : playerOne;
                break;
            }

            int currentPlayerNewTowerHeight = reduceTowerOfCurrentPlayer(currentPlayerTowerHeight, currentPlayerValidMoves);
            players.get(currentPlayer).set(1, currentPlayerNewTowerHeight);

            if(currentPlayer == playerOne) {
                currentPlayer = playerTwo;
            } else if(currentPlayer == playerTwo) {
                currentPlayer = playerOne;
            }
        }
        return winner;
    }

    static int reduceTowerOfCurrentPlayer(int towerHeight, List<Integer> moves){
        //choose optimally?
        List<Integer> newPossibleTowerHeights =
                moves.stream()
                        .map(m -> towerHeight - m)
                        .sorted()
                        .toList();
        return newPossibleTowerHeights.get(0);
    }

    static List<Integer> getValidMovesForPlayer(int currentHeight){
        List<Integer> evenDivisorsOfHeight = getEvenNums(currentHeight);
        return evenDivisorsOfHeight
                .stream()
                .map(divisor -> currentHeight - divisor)
                .filter(val -> val != 4) //for first exa3mple
                .collect(Collectors.toList());
    }

    static List<Integer> getEvenNums(int towerHeight){
        return IntStream.range(1, towerHeight) // arr.add(1) do i remove
                .filter(n -> towerHeight % n == 0)
                .boxed()
                .toList();
    }
}