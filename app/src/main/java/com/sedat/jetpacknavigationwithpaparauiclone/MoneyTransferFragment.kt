package com.sedat.jetpacknavigationwithpaparauiclone

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.sedat.jetpacknavigationwithpaparauiclone.util.setDarkTransparentBackground
import com.sedat.jetpacknavigationwithpaparauiclone.util.setFullScreenSize

class MoneyTransferFragment : DialogFragment() {

    override fun onStart() {
        super.onStart()
        setFullScreenSize()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setDarkTransparentBackground()
        return inflater.inflate(R.layout.fragment_money_transfer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnCancel).setOnClickListener {
            this.dismiss()
        }

        view.findViewById<LinearLayout>(R.id.rootLayout).setOnClickListener {
            this.dismiss()
        }
    }


}