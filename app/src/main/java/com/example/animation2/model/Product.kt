package com.example.animation2.model

import com.example.animation2.R
import java.io.Serializable

class Product(val image:Int,val name:String,val weight:String,val price:String):Serializable {

    companion object{
        val product = mutableListOf(
            Product(R.drawable.sg,"Молоко сгущенное РОГАЧЕВЪ\nцельное с сахаром",
                "380г","129,99 ₽ / шт"),
            Product(R.drawable.mu,"Мука пшеничная MAKFA\nхлебопекарная высший сорт",
                "2кг","109,99 ₽ / шт"),
            Product(R.drawable.ras,"Разрыхлитель теста DR.BAKERS",
                "10г","11,99 ₽ / шт"),
            Product(R.drawable.sl,"Сливки ультрапастеризованные ПЕТМОЛ Для взбивания 33%",
                "500г","339,99 ₽ / шт"),
            Product(R.drawable.chs,"Сыр PRETTO Маскарпоне 80%",
                "250г","239,99 ₽ / шт"),
            Product(R.drawable.sm,"Сметана PRESIDENT 30%",
                "350г","189,99 ₽ / шт"),
            Product(R.drawable.kef,"Кефир ЭКОНИВА 3,2% бутылка",
                "1000г","99,99 ₽ / шт"),
            Product(R.drawable.sugar,"Сахар BONVIDA белый кристаллический",
                "500г","129,99 ₽ / шт"),
            Product(R.drawable.tea,"Чай черный GREENFIELD Golden Ceylon",
                "25пак","109,99 ₽ / шт"),
            Product(R.drawable.cof,"Кофе растворимый JACOBS Monarch",
                "190г","479,99 ₽ / шт")
        )
    }
}
