package com.example.spinnerconcept;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimalSpinnerAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<Animal> animalArrayList;

    public AnimalSpinnerAdapter(Context context, ArrayList<Animal> animalArrayList) {
       this.context = context;
       this.animalArrayList = animalArrayList;
    }

    @Override
    public int getCount() {
        return animalArrayList.size();
    }

    @Override
    public Animal getItem(int i) {
        return animalArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_spinner,null);
        ImageView icon = (ImageView)view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textName);

        Animal mAnimal = getItem(i);

       // icon.setImageResource(mAnimal.getImageId());
        //icon.setImageResource(context.getResources().getIdentifier(mAnimal.getAnimalName(),"drawable",context.getPackageName()));
        icon.setImageResource(context.getResources().getIdentifier(mAnimal.getAnimalName().toLowerCase(),"drawable", context.getPackageName()));
        names.setText(mAnimal.getAnimalName());
        return view;
    }
}
