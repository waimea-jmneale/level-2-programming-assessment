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

const val EMPTY = " ---"     // Represents an empty square
const val NUMSQUARE = 20 // Number of squares

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

    val square = setupBoard()
    val coin = mutableListOf<String>()

    //-------------------------------------------------
    printSquare(square)
    println()

    showCoins(coin)
    println(monkeyCounter(coin))

    coin.add("Coin")
    coin.add("Coin")
    coin.add("Coin")
    coin.add("Coin")
    coin.add("Coin")
    coin.add("Gold")

}


fun setupBoard(): MutableList<String> {
    val squareList = mutableListOf<String>()
    for (i in 1..NUMSQUARE) squareList.add(EMPTY)
    return squareList
}

fun showCoins(monkeyList: List<String>) {
    println("Monkey List")
    println("-------------------")

    fun placeCoinInSquare(cageList: MutableList<String>, cageSquare: Int, coin: String) {
        println("Putting $coin into cage $cageSquare")
        cageList[cageSquare - 1] = coin
    }

    fun listAllMonkeysAndCages(cageList: List<String>) {
        println("MONKEYS & CAGES")
        for (i in 0..cageList.size - 1) {
            if (cageList[i] != EMPTY) {
                println(cageList[i].padEnd(0))
                println("Cage ${i + 1}")
            }

        }
    }


    fun printSquare(cageList: List<String>) {

        println("+--------+--------+--------+--------+--------+--------+--------+--------+")
        for (i in 0..cageList.size - 1) {
            print("| ${i + 1} ".padEnd(9))
        }
        println("|")
        println("+--------+--------+--------+--------+--------+--------+--------+--------+")
        for (i in 0..cageList.size - 1) {
            print("| ${cageList[i]} ".padEnd(9))
        }
    }
}


