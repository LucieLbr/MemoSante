package fr.clalumo.memosante

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import fr.clalumo.memosante.adapter.RemindAdapter

class NewRemindPopup (
    private val adapter : RemindAdapter
) : Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_new_remind)
        setupCloseButton()
    }

    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.remind_new_close).setOnClickListener {
            // fermer la fenetre
            dismiss()
        }
    }
}