package com.servinf.androidstack.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.servinf.androidstack.R
import com.servinf.androidstack.data.model.Dog

/**
 * Dogs adapter class
 * @author Jaime Trujillo
 */
class DogsAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    private var data = ArrayList<Dog>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_dog, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(data: ArrayList<Dog>) {
        this.data.clear()
        this.data = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtDogName = itemView.findViewById<TextView>(R.id.txtDogName)

        fun bind(dog: Dog) {
            txtDogName.text = dog.name
            itemView.setOnClickListener { onItemClickListener.onItemClick(dog) }
        }
    }

    class OnItemClickListener(private val clickListener: (dog: Dog) -> Unit) {
        fun onItemClick(dog: Dog) = clickListener(dog)
    }
}