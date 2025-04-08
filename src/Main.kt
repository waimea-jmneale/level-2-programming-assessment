import com.sun.tools.javac.jvm.ByteCodes.swap as swap1

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


    //-------------------------------------------------

    val coins = setupBoard()

    coins.add("C1")
    coins.add("C2")
    coins.add("C3")
    coins.add("C4")
    coins.add("C5")
    coins.add("G")

    showCoins(coins)

    //----------------------------------------

    listAllCoins(coins)
    coins.shuffle()

    //----------------------------------------

    printGameBox(coins)
    println()

    //----------------------------------------

    moveCoins(coins)
    println()


    //----------------------------------------


}



}


//
fun setupBoard(): MutableList<String> {
    val squareList = mutableListOf<String>()
    for (i in 1..NUMSQUARE - 6) squareList.add(EMPTY)
    return squareList
}
//Show the players the coins they're playing with
fun showCoins(coinList: List<String>) {
    println("List of the coins | 5 Normal and 1 gold")
    println("------------------------------------")
}

//add coins in boxes
fun listAllCoins(coinList: List<String>) {
    for (i in 0..coinList.size -1 ) {
        if (coinList[i] != EMPTY) {
            println(coinList[i].padEnd(0))
        }
    }
}


fun printGameBox(coinList: List<String>) {

    println("-----".repeat(20) + "+")
    for (i in 0..coinList.size - 1) {
        print("| ${i + 1} ".padEnd(5))
    }
    println("|")
    println("+----".repeat(20) + "+")
    for (i in 0..coinList.size - 1) {
        print("| ${coinList[i]} ".padEnd(5))
    }
    println("|")
    println("-----".repeat(20) + "+")

}

fun moveCoins(cageList: MutableList<String>, cageNum1: Int, cageNum2: Int) {

    println("Enter the name of Player 1:")
    val player1 = readLine() ?: "Player 1" // Ensure this line is present
    println("Enter the name of Player 2:")
    val player2 = readLine() ?: "Player 2"

    // Alternate turns between players
    var currentPlayer = player1
    var turn = 1

    while (true) {
        // Get user input for cage numbers
        println("$currentPlayer's turn. Enter the number of the first cage to swap:")
        val input1 = readLine()
        println("$currentPlayer's turn. Enter the number of the second cage to swap:")
        val input2 = readLine()

        // Convert input to integers and handle possible null values
        val cageNum1 = input1?.toIntOrNull()
        val cageNum2 = input2?.toIntOrNull()

        // Check if the input is valid
        if (cageNum1 != null && cageNum2 != null && cageNum1 in 1..cageList.size && cageNum2 in 1..cageList.size) {
            moveCoins(cageList, cageNum1, cageNum2)
            println("Updated cages: $cageList")
        } else {
            println("Invalid input. Please enter valid cage numbers.")
            continue // Skip to the next iteration if input is invalid
        }

        // Switch players
        currentPlayer = if (currentPlayer == player1) player2 else player1
        turn++
    }
}


//removing last coin
//fun deleteLastMonkey(monkeyList: MutableList<String>) {
//    // Remove the last one from the list
//    monkeyList.removeAt(4)
//    // Show some feedback
//    println("Removing monkey: $monkeyList ")
//}

//part 2
//fun clearCage(cageList: MutableList<String>, cageNum: Int) {
//    println("--- Clearing cage $cageNum")
//
//    cageList[cageNum - 1] = EMPTY
//}











