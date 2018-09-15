package com.rainaini.clubsepakbola

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.*


class DetailClubSepakBola : AppCompatActivity() {

    companion object {
        val gambar = 1
        val namaclub = 2
        val detail = 3
        val POSITIONEXTRA = "position_extra"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //kirim parcel data -> intent
        val intent = intent
        val dataitem = intent.getParcelableExtra<DataItem>(POSITIONEXTRA)

        DetailClubSepakBolaUI(dataitem).setContentView(this)

    }

    //UI digabung sini biar keliatan di preview (?) klo dipisah kenapa g muncul... hmm..hmm..
    internal class DetailClubSepakBolaUI(var list: DataItem) : AnkoComponent<DetailClubSepakBola> {

        //UI detail nya. hasil convert xml -> anko.. well. not bad.. wkwkwkwkwk

        override fun createView(ui: AnkoContext<DetailClubSepakBola>) = with(ui){
            relativeLayout {
                imageView {
                    id = gambar
                    Glide.with(this).load(list.gambar).into(this)
                  //  setImageResource(R.drawable.img_barca)
                }.lparams(width = dip(150), height = dip(150)){
                    topMargin = dip(15)
                    alignParentTop()
                    centerHorizontally()
                }
                textView {
                    id = namaclub
                    text = list.namaclub
                    textSize = 18f
                    textColor = Color.BLACK
                }.lparams(width = wrapContent, height = wrapContent) {
                    topMargin = dip(165)
                    alignParentTop()
                    centerHorizontally()
                }
                textView {
                    id = detail
                    text = list.detail
                }.lparams(width = wrapContent, height = wrapContent) {
                    alignParentTop()
                    centerHorizontally()
                    topMargin = dip(195)
                    leftMargin = dip(15)
                    rightMargin = dip(10)

                }
            }
        }
    }

}

