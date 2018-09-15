package com.rainaini.clubsepakbola

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class ClubSepakBola : AppCompatActivity() {

    //untuk list data nya
    var dataitem : MutableList<DataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //pertama kali load recyclerview UI nya di RecyclerSepakBola()

        val UIawal = RecyclerSepakBola()
        UIawal.setContentView(this)

        //inisialisasi data
        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            //ketika item di recyclerview di klik munculkan toast dan tampilkan activity detail club
            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = AdapterBola(dataitem) {
                    startActivity<DetailClubSepakBola>(DetailClubSepakBola.POSITIONEXTRA to it)
                    val toast = Toast.makeText(context, it.namaclub, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }

    }

    //init data
    private fun initData(){
        //get data dari array yang ada di file value.xml
        val namaclub = resources.getStringArray(R.array.namaclub)
        val gambar = resources.obtainTypedArray(R.array.gambar)
        val detail = resources.getStringArray(R.array.detail)


        dataitem.clear()

        for (i in namaclub.indices){
            dataitem.add(DataItem(namaclub[i], gambar.getResourceId(i,0), detail[i] ))
        }
        Log.e("info", dataitem.size.toString())

        gambar.recycle()

    }


}





