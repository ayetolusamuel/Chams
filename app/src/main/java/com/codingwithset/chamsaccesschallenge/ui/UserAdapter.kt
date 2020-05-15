package com.codingwithset.chamsaccesschallenge.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwithset.chamsaccesschallenge.R
import com.codingwithset.chamsaccesschallenge.model.User
import com.codingwithset.chamsaccesschallenge.databinding.LayoutUserItemBinding

class UserAdapter(private val userList:List<User>): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    private var _binding: LayoutUserItemBinding? = null
     val binding  get() = _binding!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_user_item,parent,false)
        _binding = LayoutUserItemBinding.bind(view)
       return MyViewHolder(
           binding
       )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList.get(position)
        holder.name.text = user.name
        Glide.with(holder.itemView.context).load(user.image_uri).into(holder.image)



    }








    class MyViewHolder( binding: LayoutUserItemBinding): RecyclerView.ViewHolder(binding.root){

        val name:TextView = binding.userName
        val image:ImageView = binding.userImage





    }



}
