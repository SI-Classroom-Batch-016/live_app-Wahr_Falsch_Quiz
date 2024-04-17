package com.example.wahrfalschquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val frageListe = listOf<Frage>(
        Frage("Grass ist gruen", true),
        Frage("Wasser ist nass", true),
        Frage("Wasser ist trocken", false),
        Frage
    ("„Ki kann Kunst Kreieren“",false),
        Frage(
            "Blitze werden gesehen, bevor sie gehört werden, weil sich Licht schneller ausbreitet als Schall",
            true
        ),
        Frage("“Luigi ist Bruder von Mario”", true),
        Frage("Ist der Himmel blau?", true),
        Frage("Ist Eis kalt?", true),
        Frage("Sind Katzen Haustiere?", true),
        Frage("Ist Luft unsichtbar?", true),
        Frage("Sind Bäume Pflanzen?", true),
        Frage("Ist Milch weiß?", true),
        Frage("Sind Fische im Wasser?", true),
        Frage("Ist der Mond rund?", true),
        Frage("Sind Computer elektronische Geräte?", true),
        Frage("Ist Sand am Strand?", true),
        Frage("Sind Menschen Säugetiere?", true),
        Frage("Ist Feuer kalt?", false),
        Frage("Ist der Himmel grün?", false),
        Frage("Sind Fische flugfähig?", false),
        Frage("Sind Autos lebendig?", false),
        Frage("Ist Schnee heiß?", false),
        Frage("Ist Milch gelb?", false),
        Frage("Können Steine schwimmen?", false),
        Frage("Ist der Mond aus Käse?", false),
        Frage("Sind Wolken fest?", false),
        Frage("Können Vögel unter Wasser atmen?", false),
    )

    //Spielvariablen
    var aktuelleFrageIndex = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frageStellungTV = findViewById<TextView>(R.id.frageStellungTV)
        val wahrBTN = findViewById<Button>(R.id.wahrBTN)
        val falschBTN = findViewById<Button>(R.id.falschBTN)
        val scoreTV = findViewById<TextView>(R.id.scoreTV)

        //Erste Frage laden
        frageStellungTV.text = frageListe[aktuelleFrageIndex].fragestellung

        //Listener für User Klick -> Antwort auswerten und mit Antwort der Frage vergleichen
        wahrBTN.setOnClickListener {
            //User hat "wahr" angeklickt, gucken ob das mit der Frage übereinstimmt
            val aktuelleFrage = frageListe[aktuelleFrageIndex]
            if (aktuelleFrage.wahr == true) {

                score++
                scoreTV.text = "$score"

            }

            //Zur nächsten Frage weitergehen
            aktuelleFrageIndex++

            if (aktuelleFrageIndex >= frageListe.size) {
                //Wenn die Fragen leer sind, Spiel beenden
                spielBeenden()
            } else {
                frageStellungTV.text = frageListe[aktuelleFrageIndex].fragestellung
            }
        }

        falschBTN.setOnClickListener {
            //User hat "falsch" angeklickt, gucken ob das mit der Frage übereinstimmt
            val aktuelleFrage = frageListe[aktuelleFrageIndex]
            if (aktuelleFrage.wahr == false) {

                score++
                scoreTV.text = "$score"

            }

            //Zur nächsten Frage weitergehen
            aktuelleFrageIndex++

            if (aktuelleFrageIndex >= frageListe.size) {
                //Wenn die Fragen leer sind, Spiel beenden
                spielBeenden()
            } else {
                frageStellungTV.text = frageListe[aktuelleFrageIndex].fragestellung
            }
        }


    }

    fun spielBeenden() {

        val wahrBTN = findViewById<Button>(R.id.wahrBTN)
        val falschBTN = findViewById<Button>(R.id.falschBTN)

        //Überschreibe die vorherigen onClickListener
        wahrBTN.setOnClickListener { }
        falschBTN.setOnClickListener { }

        val frageStellungTV = findViewById<TextView>(R.id.frageStellungTV)

        frageStellungTV.text = "Spiel abgeschlossen!"


    }
}