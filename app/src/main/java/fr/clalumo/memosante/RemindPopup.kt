package fr.clalumo.memosante

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import fr.clalumo.memosante.adapter.RemindAdapter

class RemindPopup(
    private val adapter : RemindAdapter,
    private val currentRemind: RemindModel
) : Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_remind_details)
        setupComponents()
        setupCloseButton()
        setupDeleteButton()
    }

    private fun setupDeleteButton() {
        findViewById<ImageView>(R.id.remind_delete_button).setOnClickListener{
            // supprimer le rappel de la base de donné
        }
    }

    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.remind_close_button).setOnClickListener {
            // fermer la fenetre
            dismiss()
        }
    }

    private fun setupComponents() {
        // actualiser les informations du rappel
        findViewById<TextView>(R.id.remind_popup_name).text = currentRemind.name
        findViewById<TextView>(R.id.remind_when_date).text = currentRemind.date
        findViewById<TextView>(R.id.remind_when_hour).text = currentRemind.hour
        findViewById<TextView>(R.id.remind_when_min).text = currentRemind.min
        findViewById<TextView>(R.id.remind_where).text = currentRemind.where
        findViewById<TextView>(R.id.remind_medecin).text = currentRemind.medecin
    }

}