package fr.clalumo.memosante.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.clalumo.memosante.DocsModel
import fr.clalumo.memosante.DocsPopup
import fr.clalumo.memosante.MainActivity
import fr.clalumo.memosante.R

class DocsAdapter (
    val context: MainActivity,
    private val docslist: List<DocsModel>,
    private val layoutId: Int,
) : RecyclerView.Adapter<DocsAdapter.ViewHolder>(){

    //boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val docName:TextView? = view.findViewById(R.id.doc_name)
        val docImg = view.findViewById<ImageView>(R.id.image_popup_doc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_storage_docs,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentdoc=docslist[position]

        // mettre à jour le nom de l'article
        holder.docName?.text = currentdoc.name

        // interaction lors d'un click sur un doc
        holder.itemView.setOnClickListener {
            // afficher la popup
            DocsPopup(this, currentdoc).show()
        }
    }

    override fun getItemCount(): Int = docslist.size
}