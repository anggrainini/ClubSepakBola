package com.rainaini.clubsepakbola


import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*;


class ClubSepakBolaUI : AnkoComponent<ViewGroup> {
    companion object {
        val gambar = 1
        val namaclub = 2
    }

    //UI ListSepakBola nya tampilkan gambar sama namaclub
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {

        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView {
                id = gambar
            }.lparams(width = dip(50), height = dip(50))
            textView {
                id = namaclub
            }.lparams(width = wrapContent, height = wrapContent) {
                margin = dip(10)

            }
        }
    }


}
