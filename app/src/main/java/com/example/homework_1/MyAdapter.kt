package com.example.homework_1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycle_view_item.view.*


class MyAdapter(private var weekends: List<Weekend>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    var onItemClickFunction: ((v: View, position: Int) -> Unit)? = null

    //Прописали вручную сеттер
    fun setOnItemListener(ll: OnItemClickListener) {
        onItemClickListener = ll
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_item, parent, false))
    }

    override fun getItemCount(): Int {
        return weekends.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.itemView.photo.setImageURI(weekends[position].photo.toUri())

        holder.itemView.header_text.text = weekends[position].header
        holder.itemView.count_users.text = weekends[position].userCount.toString() + " участников"


    }

    //inner чтобы мог видеть реализованные интерфейсы
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Способ 2, как назначить действие
//        init {
//            itemView.setOnClickListener {
//                //
//                itemView.context.apply {
//                    startActivity(Intent(this, MainActivity::class.java))
//                }
//            }

        //Способ 3



        //способ 4
        init {
            itemView.setOnClickListener {
                //cпособ 3
                onItemClickListener?.onClick(it, adapterPosition)
                //способ 4
                onItemClickFunction?.invoke(it, adapterPosition)
            }
        }

    }//ViewHolder

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }


}