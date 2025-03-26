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

const val EMPTY = " "     // Represents an empty square
const val NUMSQUARE = 20 // Number of squares

fun main() {



    println("-------------------------------------------------------------")
    println("Welcome to the Old Gold Game!")
    println("-------------------------------------------------------------")
    println("Old Gold is a two-player game, played on a one-dimensional grid with coins,")
    println("where the aim is to win by being the player who removes the gold coin.")
    println("-------------------------------------------------------------")
    println()

    println("Player 1, please enter your name!")
    val player1 = readln()
    println("$player1, you are player 1")
    println()

    println("Player 2, please enter your name!")
    val player2 = readln()
    println("$player2, you are player 2")
    println()

    val square = setupBoard()
    val coin = mutableListOf<String>()

    //-------------------------------------------------

    coin.add("C")
    coin.add("C")
    coin.add("C")
    coin.add("C")
    coin.add("C")
    coin.add("G")

    showCoins(coin)
    println((coin))

    printGameBox(square)
    println()

}
//
fun setupBoard(): MutableList<String> {
    val squareList = mutableListOf<String>()
    for (i in 1..NUMSQUARE) squareList.add(EMPTY)
    return squareList
}
//Show the players the coins they're playing with
fun showCoins(coinList: List<String>) {
    println("List of the coins | 5 Normal and 1 gold")
    println("------------------------------------")
}


    fun printGameBox(cageList: List<String>) {

        println("-----".repeat(20) + "+")
        for (i in 0..cageList.size - 1) {
            print("| ${i + 1} ".padEnd(5))
        }
        println("|")
        println("+----".repeat(20) + "+")
        for (i in 0..cageList.size - 1) {
            print("| ${cageList[i]} ".padEnd(5))
        }
        println("|")
        println("-----".repeat(20) + "+")
    }




