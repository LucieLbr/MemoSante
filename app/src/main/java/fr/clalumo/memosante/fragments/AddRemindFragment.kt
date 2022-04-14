package fr.clalumo.memosante.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import fr.clalumo.memosante.*
import java.util.*

class AddRemindFragment (private val context: MainActivity): Fragment(){
    private var file: Uri? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_remind, container, false)
        val confirmButton = view.findViewById<Button>(R.id.confirm_button)
        confirmButton.setOnClickListener{sendForm(view)}

        return view
    }

    private fun sendForm(view: View) {
        val repo= RemindRepository()
        val remindName=view.findViewById<EditText>(R.id.name_remind_input).text.toString()
        val remindDate=view.findViewById<EditText>(R.id.remind_when_date).text.toString()
        val remindHour=view.findViewById<Spinner>(R.id.remind_when_hour).selectedItem.toString()
        val remindMin=view.findViewById<Spinner>(R.id.remind_when_min).selectedItem.toString()
        val remindWhere=view.findViewById<EditText>(R.id.remind_where).text.toString()
        val remindMedecin=view.findViewById<EditText>(R.id.remind_medecin).text.toString()

        // creer un nouveau rappel model
        val remind= RemindModel(
            UUID.randomUUID().toString(),
            remindName,
            remindDate,
            remindHour,
            remindMin,
            remindWhere,
            remindMedecin,
        )

        repo.insertRemind(remind)
        //}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==47 && resultCode== Activity.RESULT_OK){
            if(data==null || data.data==null) return
            file=data.data
        }
    }
}