package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_weekends.*

class WeekendsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekends)

        rec_view.layoutManager = LinearLayoutManager(this)

        val adapter = MyAdapter(
            listOf(
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, ""),
                Weekend("ДР у Лехи", "4.01.1994", 9, "")
            )
        )


        //четвертый способ, без использования интерфейса
        adapter.onItemClickFunction={ _, pos ->
            startActivity(Intent(this@WeekendsActivity, MainActivity::class.java).putExtra("pos", pos))

        }
        //Можно сделать как анонимную функцию, как написано ниже, то же самое
        //можно передать параметр позиции или элемент с позицией
        adapter.onItemClickFunction= fun(_, pos){
            startActivity(Intent(this@WeekendsActivity, MainActivity::class.java).putExtra("pos", pos))
        }



        //тот же третий способ, с интерфейсом
        adapter.setOnItemListener(object : MyAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                //второй параметр - куда переходим (создать новую активити)
                //где @-вычисление this, какой именно нам нужен, переход выше
                startActivity(Intent(this@WeekendsActivity, MainActivity::class.java))
            }
        })
    }
}
