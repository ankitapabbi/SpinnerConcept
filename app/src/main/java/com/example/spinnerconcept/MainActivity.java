package com.example.spinnerconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String []countryList = {"India", "Canada", "Brazil", "Russia", "China", "USA", "UK", "India", "Canada", "Brazil", "Russia", "China", "USA", "UK"};
    private Spinner spinnerCountry,spinnerAnimal;
    private AutoCompleteTextView autoCompleteTextView;
    private Button btnShowContextMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCountry = (Spinner)findViewById(R.id.spCountry);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        btnShowContextMenu = (Button) findViewById(R.id.btnShowContextMenu);
        spinnerAnimal = (Spinner)findViewById(R.id.spAnimal);

       ArrayAdapter<String> sStringAdapter =
       new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,countryList);

       spinnerCountry.setAdapter(sStringAdapter);

       spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(MainActivity.this, countryList[i], Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

       ArrayAdapter<String> stringArrayAdapterForAutoCompleteTextView =
       new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,countryList);

       autoCompleteTextView.setThreshold(1);
       autoCompleteTextView.setAdapter(stringArrayAdapterForAutoCompleteTextView);
        setSpinnerWithTextAndImage();

    }

    private void setSpinnerWithTextAndImage(){
        final ArrayList<Animal> mAnimalArrayList = new ArrayList<>();
        mAnimalArrayList.add(new Animal(1,"Camel",R.drawable.camel));
        mAnimalArrayList.add(new Animal(2,"Dog",R.drawable.dog));
        mAnimalArrayList.add(new Animal(3,"Elephant",R.drawable.elephant));
        mAnimalArrayList.add(new Animal(4,"Owl",R.drawable.owl));
        mAnimalArrayList.add(new Animal(5,"Pig",R.drawable.pig));
        mAnimalArrayList.add(new Animal(6,"Zebra",R.drawable.zebra));

        AnimalSpinnerAdapter animalSpinnerAdapter = new AnimalSpinnerAdapter(MainActivity.this,mAnimalArrayList);
        spinnerAnimal.setAdapter(animalSpinnerAdapter);

        spinnerAnimal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Animal mAnimal = mAnimalArrayList.get(i);

                //Custome Toast
                Toast mToast = new Toast(MainActivity.this);
                View mView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_spinner, null);
                ImageView mImageView = mView.findViewById(R.id.imageView);
                TextView mTextView = mView.findViewById(R.id.textName);
                mImageView.setImageResource(mAnimal.getImageId());
                mTextView.setText(mAnimal.getAnimalName());
                mToast.setView(mView);
                mToast.setDuration(Toast.LENGTH_LONG);
                mToast.show();
                //Toast.makeText(MainActivity.this, mAnimal.getAnimalName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

    }
}
