package com.example.demo22

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NoteAdapter(context: Context, private val notes: List<Note>) :
    ArrayAdapter<Note>(context, 0, notes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val note = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)

        val titleTextView = view.findViewById<TextView>(android.R.id.text1)
        val contentTextView = view.findViewById<TextView>(android.R.id.text2)

        titleTextView.text = note?.title
        contentTextView.text = note?.content

        return view
    }
}