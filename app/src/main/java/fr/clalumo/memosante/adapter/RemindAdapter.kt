package fr.clalumo.memosante.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.clalumo.memosante.*

class RemindAdapter (
    val context: MainActivity,
    private val remindlist: List<RemindModel>,
    private val layoutId: Int
    ) : RecyclerView.Adapter<RemindAdapter.ViewHolder>(){

        //boite pour ranger tous les composants à controler
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val remindName: TextView? = view.findViewById(R.id.remind_name)
            val remindDate: TextView? = view.findViewById(R.id.remind_date)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_remind,parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentRemind=remindlist[position]

            // mettre à jour le nom de l'article
            holder.remindName?.text = currentRemind.name
            holder.remindDate?.text = currentRemind.date

            // interaction lors du click sur un rappel
            holder.itemView.setOnClickListener {
                // afficher la popup
                RemindPopup(this, currentRemind).show()
            }
        }
        override fun getItemCount(): Int = remindlist.size
    }