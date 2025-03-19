/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Old Gold
 * Project Author: Jayden Neale
 * GitHub Repo:    https://github.com/waimea-jmneale/level-2-programming-assessment
 * ---------------------------------------------------------------------
 * Notes:
 * Old Gold is a two-player game, played on a one-dimensional grid with coins, where the aim is to win by being the player who **removes the gold coin**.
 * =====================================================================
 */



const val GAMESQUARES = 20      // The total number of squares
const val NCOIN = "1"     // Represents a normal coin
const val GCOIN = "5"     // Represents the gold coin
const val EMPTY = ""     // Represents an empty square

fun main() {



    println("-------------------------------------------------------------")
    println("Welcome to the Old Gold Game!")
    println("-------------------------------------------------------------")
    println()


    println("Hello there player 1, please enter your name!")
    val player1 = readln()
    println("$player1, you are player 1")
    println()

    println("Hello there player 2, please enter your name!")
    val player2 = readln()
    println("$player2, you are player 2")
    println()

}

fun setupSquare() {
    val coins = setupSquare()
}

fun setupCages(): MutableList<String> {
    val gameBoard = mutableListOf<String>()
    for (i in 1..GAMESQUARES) gameBoard.add(EMPTY)
    return gameBoard
}



fun theGameBoard(gameBoard: List<String>) {

    println("+--------+--------+--------+--------+--------+--------+--------+--------+")
    for (i in 0..gameBoard.size - 1) {
        print("| Cage ${i + 1} ".padEnd(9))
    }
    println("|")
    println("+--------+--------+--------+--------+--------+--------+--------+--------+")
    for (i in 0..gameBoard.size - 1) {
        print("| ${gameBoard[i]} ".padEnd(9))
    }
    println("|")
    println("+--------+--------+--------+--------+--------+--------+--------+--------+")
}







fun showMonkeyCages(cageList: List<String>) {

    println("+--------+--------+--------+--------+--------+--------+--------+--------+")
    for (i in 0..cageList.size - 1) {
        print("| Cage ${i + 1} ".padEnd(9))
    }
    println("|")
    println("+--------+--------+--------+--------+--------+--------+--------+--------+")
    for (i in 0..cageList.size - 1) {
        print("| ${cageList[i]} ".padEnd(9))
    }
    println("|")
    println("+--------+--------+--------+--------+--------+--------+--------+--------+")
}