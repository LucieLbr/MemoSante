package fr.clalumo.memosante

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import fr.clalumo.memosante.adapter.RemindAdapter

class RemindPopup(
    private val adapter : RemindAdapter
) : Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_remind_details)
    }

}