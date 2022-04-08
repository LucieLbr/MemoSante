package fr.clalumo.memosante.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.clalumo.memosante.DocsModel
import fr.clalumo.memosante.MainActivity
import fr.clalumo.memosante.R

class DocsAdapter (
    private val context: MainActivity,
    private val docslist: List<DocsModel>,
    private val layoutId: Int
    ) : RecyclerView.Adapter<DocsAdapter.ViewHolder>(){

    //boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val docName:TextView? = view.findViewById(R.id.doc_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_storage_docs,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentdoc=docslist[position]

        // mettre à jour le nom de l'article
        holder.docName?.text = currentdoc.name
    }

    override fun getItemCount(): Int = docslist.size
}