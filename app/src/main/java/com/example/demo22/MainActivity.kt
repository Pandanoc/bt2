package com.example.demo22

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val notes = mutableListOf<Note>()
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextContent = findViewById<EditText>(R.id.editTextContent)
        val buttonAddNote = findViewById<Button>(R.id.buttonAddNote)
        val listViewNotes = findViewById<ListView>(R.id.listViewNotes)

        adapter = NoteAdapter(this, notes)
        listViewNotes.adapter = adapter

        buttonAddNote.setOnClickListener {
            val title = editTextTitle.text.toString()
            val content = editTextContent.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                notes.add(Note(title, content))
                adapter.notifyDataSetChanged()
                editTextTitle.text.clear()
                editTextContent.text.clear()
            }
        }
    }
}