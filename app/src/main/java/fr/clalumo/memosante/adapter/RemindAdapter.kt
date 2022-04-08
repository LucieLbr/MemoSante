package fr.clalumo.memosante.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.clalumo.memosante.DocsModel
import fr.clalumo.memosante.MainActivity
import fr.clalumo.memosante.R
import fr.clalumo.memosante.RemindModel

class RemindAdapter (
    private val context: MainActivity,
    private val remindlist: List<RemindModel>,
    private val layoutId: Int
    ) : RecyclerView.Adapter<RemindAdapter.ViewHolder>(){

        //boite pour ranger tous les composants à controler
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val remindName: TextView? = view.findViewById(R.id.remind_name)
            //val remindDate: TextView? = view.findViewById(R.id.remind_date)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_remind,parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentName=remindlist[position]
            //val currentDate=remindlist[position]

            // mettre à jour le nom de l'article
            holder.remindName?.text = currentName.name
            //holder.remindDate?.text = currentDate.date
        }

        override fun getItemCount(): Int = remindlist.size
    }