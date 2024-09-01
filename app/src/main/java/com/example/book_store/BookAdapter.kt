package com.example.book_store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(val books: List<Book>): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    class BookViewHolder(val row :View): RecyclerView.ViewHolder(row) {
        val imag = row.findViewById<ImageView>(R.id.img)
        val txtV1 = row.findViewById<TextView>(R.id.txt1)
        val txtV2 = row.findViewById<TextView>(R.id.txt2)
        val rt = row.findViewById<RatingBar>(R.id.rt_bar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return BookViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books.get(position)
        holder.imag.setImageDrawable(holder.imag.context.getDrawable(holder.imag.context.resources.getIdentifier(book.image, "drawable", holder.imag.context.packageName)))
        holder.txtV1.text = book.title
        holder.txtV2.text = book.author
        holder.rt.rating = book.rating.toFloat()
    }

}