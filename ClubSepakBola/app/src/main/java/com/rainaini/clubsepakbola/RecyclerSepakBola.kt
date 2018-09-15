package com.rainaini.clubsepakbola

import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

//recyclerview pakai punya anko

class RecyclerSepakBola : AnkoComponent<ClubSepakBola>{
    companion object {
        val recyclersepakbola = 1
    }
    override fun createView(ui: AnkoContext<ClubSepakBola>): View = with(ui)  {
        relativeLayout {
            recyclerView {
                id = recyclersepakbola
            }.lparams(width = matchParent, height = matchParent)
        }
    }

}