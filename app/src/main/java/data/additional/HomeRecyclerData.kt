package data.additional

import Adapters.MainMenuRecycler.MainMenuRecyclerItem
import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import com.locaspes.riperi.R

class HomeRecyclerData() {

    fun getArrayList(context: Context): ArrayList<MainMenuRecyclerItem>{


        val rvMainArrayList = ArrayList<MainMenuRecyclerItem>()

        rvMainArrayList.add(
            MainMenuRecyclerItem(
                context.getString(R.string.original_parts),
                "Official catalogs from the manufacturer",
                AppCompatResources.getDrawable(context, R.drawable.img_main_menu_car)!!
            )
        )
        rvMainArrayList.add(
            MainMenuRecyclerItem(
                context.getString(R.string.oil_and_liquids),
                "Отбор по параметрам",
                AppCompatResources.getDrawable(context, R.drawable.img_main_menu_oil)!!
            )
        )
        rvMainArrayList.add(
            MainMenuRecyclerItem(
                "Запчасти для ТО",
                "Расходники и модули",
                AppCompatResources.getDrawable(context, R.drawable.img_main_menu_toparts)!!
            )
        )
        rvMainArrayList.add(
            MainMenuRecyclerItem(
                "Шины и диски",
                "Поиск по модели",
                AppCompatResources.getDrawable(context, R.drawable.img_main_menu_wheel)!!
            )
        )
        rvMainArrayList.add(
            MainMenuRecyclerItem(
                "Модельные аксессуары",
                "Для вашего автомобиля",
                AppCompatResources.getDrawable(context, R.drawable.img_main_menu_dashboard)!!
            )
        )
        rvMainArrayList.add(
            MainMenuRecyclerItem(
                "Автохимия и косметика",
                "Уход за авто",
                AppCompatResources.getDrawable(context, R.drawable.img_main_menu_chemical)!!
            )
        )

        rvMainArrayList.add(
            MainMenuRecyclerItem(
                "Инструменты",
                "Различное оборудование",
                AppCompatResources.getDrawable(context, R.drawable.img_main_menu_tools)!!
            )
        )

        return rvMainArrayList

    }

}