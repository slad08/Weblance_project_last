package com.weblance_project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis on 02.12.2015.
 */
public class ExpendedActivity  extends Activity{

    // Названия групп()
    String[] groups_category=new String[]{"ВЫБЕРИТЕ КАТЕГОРИЮ ","ВВЕДИТЕ ОПИСАНИЕ","ВЫБЕРИТЕ СОСТОЯНИЕ","ВЫБЕРИТЕ МЕСТО"};

    //Названия элементов в группах
    String[] category=new String[]{"Фарфор","Золото","Бронза"};
    String[] description=new String[] {"Высота-20 см, диамерт-11см. \nСохранность хорошая.Без повреждений"};
    String[] condition=new String[]{"НОВОЕ","ХОРОШЕЕ","УДОВЛЕТВОРИТЕЛЬНОЕ","НЕ ПРИНЦИПИАЛЬНОЕ"};
    String[] location=new String[]{"Москва", "Санкт-Петербург","Милан","Минск"};

    //коллекция для групп
    ArrayList<Map<String ,String>> groupData;

    //коллекция для элементов одной группы
    ArrayList<Map<String,String>> childDataItem;

    //общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String,String >>>childData;

    //список аттрибутов группы или элемента
    Map<String,String> m;

    ExpandableListView elvMain;

    ImageButton imgBtn;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    ImageButton imgBtn=(ImageButton)findViewById(R.id.imgBtn);
    final ImageView imageView=(ImageView)findViewById(R.id.imgView);

        View.OnClickListener onclImgBtn=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            imageView.setImageDrawable(getDrawable(R.drawable.sss));
        }
       };
        imgBtn.setOnClickListener(onclImgBtn);

    // заполняем коллекцию групп из массива с названиями групп
    groupData = new ArrayList<Map<String, String>>();
    for (String group : groups_category) {
        m = new HashMap<String, String>();
        m.put("groupName", group);//Имя категории
        groupData.add(m);
    }
    // список аттрибутов групп для чтения
    String groupFrom[] = new String[]{"groupName"};
    // список ID view-элементов, в которые будет помещены аттрибуты групп
    int groupTo[] = new int[]{android.R.id.text1};

    // создаем коллекцию для коллекций элементов
    childData = new ArrayList<ArrayList<Map<String, String>>>();

    //создаем коллекцию элементов  для первой группы
    childDataItem = new ArrayList<Map<String, String>>();
    //заполняем список аттрибутов для каждого элемента
    for (String categor : category) {
        m = new HashMap<String, String>();
        m.put("categName", categor);//название категории
        childDataItem.add(m);
    }
    childData.add(childDataItem);

    //создаем коллекцию элементов  для второй группы
    childDataItem = new ArrayList<Map<String, String>>();
    //заполняем список аттрибутов для каждого элемента
    for (String categor : description) {
        m = new HashMap<String, String>();
        m.put("categName", categor);//название категории
        childDataItem.add(m);
    }
    childData.add(childDataItem);

    //создаем коллекцию элементов  для третьей группы
    childDataItem = new ArrayList<Map<String, String>>();
    //заполняем список аттрибутов для каждого элемента
    for (String categor : condition) {
        m = new HashMap<String, String>();
        m.put("categName", categor);//название категории
        childDataItem.add(m);
    }
    childData.add(childDataItem);

    //создаем коллекцию элементов  для третьей группы
    childDataItem = new ArrayList<Map<String, String>>();
    //заполняем список аттрибутов для каждого элемента
    for (String categor : location) {
        m = new HashMap<String, String>();
        m.put("categName", categor);//название категории

        childDataItem.add(m);
    }
    childData.add(childDataItem);


    // список аттрибутов элементов для чтения
    String childFrom[] = new String[] {"categName"};
    // список ID view-элементов, в которые будет помещены аттрибуты элементов
    int childTo[] = new int[] {android.R.id.text1};

    SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
            this,    groupData,android.R.layout.simple_expandable_list_item_1,groupFrom,groupTo,
            childData,android.R.layout.simple_list_item_1,childFrom,childTo);

    elvMain=(ExpandableListView)findViewById(R.id.elvMain);
    elvMain.setAdapter(adapter);
}

}
