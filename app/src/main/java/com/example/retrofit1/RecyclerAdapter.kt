package com.example.retrofit1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(val context: Context, val data: List<UserModel.Data>):
        RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {
    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view){
        val id:TextView
        val name:TextView
        val surname:TextView
        val email:TextView
        val avatar:ImageView
        init{
            id = view.findViewById(R.id.id)
            name = view.findViewById(R.id.name)
            surname = view.findViewById(R.id.surname)
            email = view.findViewById(R.id.email)
            avatar = view.findViewById(R.id.avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.id.text = data[position].id.toString()
        holder.name.text = data[position].first_name
        holder.surname.text = data[position].last_name
        holder.email.text = data[position].email
        Picasso.get()
            .load(data[position].avatar)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.avatar)
    }
}