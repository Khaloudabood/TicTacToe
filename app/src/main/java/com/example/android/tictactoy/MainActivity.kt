package com.example.android.tictactoy

import android.icu.lang.UProperty
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }//end onCreate()

    fun buSelect(view:View){
        val buChoice = view as Button
        var cellID = 0
        when(buChoice.id)
        {
            R.id.btn1-> cellID =1
            R.id.btn2-> cellID =2
            R.id.btn3-> cellID =3
            R.id.btn4-> cellID =4
            R.id.btn5-> cellID =5
            R.id.btn6-> cellID =6
            R.id.btn7-> cellID =7
            R.id.btn8-> cellID =8
            R.id.btn9-> cellID =9
        }//end when
        Log.d("cellID ", cellID.toString())
        playGame(cellID, buChoice)
        checkWinner()


    }//end buSelect()

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(cellID:Int, buChoice:Button){
        if(activePlayer == 1)
        {
            buChoice.text = "X"
            buChoice.setBackgroundResource(R.color.purple_200)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        }
        else{
            buChoice.text = "O"
            buChoice.setBackgroundResource(R.color.teal_200)
            player2.add(cellID)
            activePlayer = 1
        }
        buChoice.isEnabled = false

    }//end playGame()

    fun checkWinner(){
        var winner = -1
        for (n in 1..2){
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
        {winner = 1
            break}
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
        {winner = 2
            break}

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
        {winner = 1
            break}
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
        {winner = 2
            break}

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
        {winner = 1
            break}
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
        {winner = 2
            break}

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {winner = 1
            break }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {winner = 2
            break}

        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {winner = 1
            break}
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {winner = 2
            break}

        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
        {winner = 1
            break}
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
        {winner = 2
            break}}

        if (winner != -1){

            if (winner == 1){
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            }
        }
       /*for (n in 1..2){
           if (winner == 1){
               Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
               break
           }
           if (winner == 2)
               Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
               break
        }*/
    }//end checkWinner()

    fun autoPlay(){
        //scan empty cells

        var emptyCells = ArrayList<Int>()
        for(cellID in 1..9){

            if (!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)

            }
        }//end for

        //select rand index
        val r = Random
        val randIndex = r.nextInt(emptyCells.size-0) + 0
        val cellID = randIndex

        //index to button
        var buSelect:Button?
        when(cellID){

            1-> buSelect = btn1
            2-> buSelect = btn2
            3-> buSelect = btn3
            4-> buSelect = btn4
            5-> buSelect = btn5
            6-> buSelect = btn6
            7-> buSelect = btn7
            8-> buSelect = btn8
            9-> buSelect = btn9
        else ->{
            buSelect = btn1
        }}
        playGame(cellID, buSelect)
    }//end autoPlay()
}//end class