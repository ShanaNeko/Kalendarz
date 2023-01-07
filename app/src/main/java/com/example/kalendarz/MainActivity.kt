package com.example.kalendarz


//Aplikacja do planowania wyjazdu (CalnedarView)
//
//1. Ustawienie daty wyjazdu i powrotu
//2. Obliczenie długości wyjazdu (dni)
//3. Blokada wyjazdu "przeszłego" (data rozpoczęcia nie może być w przeszłości)
//4. Ograniczenie terminu do najbliższych 2 lat
//5. Zazaczenie zakresu dni wyjazdu na kalendarzu
//6. Ilość commit'ów

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*


@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = findViewById<CalendarView>(R.id.calendarView)
        val wyjazd = findViewById<Button>(R.id.start)
        val powrot = findViewById<Button>(R.id.stop)
        val text1 = findViewById<TextView>(R.id.a1)
        val text2 = findViewById<TextView>(R.id.a2)
        val liczenie = findViewById<Button>(R.id.maths)
        val math = findViewById<TextView>(R.id.c1)

        data.minDate = Date().time
        data.maxDate = Date().time + 63072000000

            wyjazd.setOnClickListener {
                data.setOnDateChangeListener { _, year, month, dayOfMonth ->
                    text1.text = "" + dayOfMonth + "/" + (month + 1) + "/" + year
                }
            }

            powrot.setOnClickListener {
                data.setOnDateChangeListener { _, year, month, dayOfMonth ->
                    text2.text = "" + dayOfMonth + "/" + (month + 1) + "/" + year
                }
            }

            liczenie.setOnClickListener{
                val days = "Nie, nie wiem jak to zrobić. Próbowałam, przysięgam."
                math.text = "$days"
            }
        }
    }
