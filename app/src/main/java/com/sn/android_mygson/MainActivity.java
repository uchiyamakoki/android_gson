package com.sn.android_mygson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sn.android_mygson.domain.Person;
import com.sn.android_mygson.gson.GsonTools;
import com.sn.android_mygson.http.HttpUtils;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button person, persons, liststring, listmap;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person = (Button) this.findViewById(R.id.person);
        persons = (Button) this.findViewById(R.id.persons);
        liststring = (Button) this.findViewById(R.id.liststring);
        listmap = (Button) this.findViewById(R.id.listmap);
        person.setOnClickListener(this);
        persons.setOnClickListener(this);
        liststring.setOnClickListener(this);
        listmap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.person:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String path = "http://192.168.43.7:8080/jsonProject/servlet/JsonAction?action_flag=person";
                        String jsonString = HttpUtils.getJsonContent(path);
                        Person person = GsonTools.getPerson(jsonString, Person.class);//这里json和gson不同
                        Log.i(TAG, person.toString());
                    }
                }).start();
                break;
            case R.id.persons:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String path2 = "http://192.168.43.7:8080/jsonProject/servlet/JsonAction?action_flag=persons";
                        String jsonString2 = HttpUtils.getJsonContent(path2);
                        List<Person> list2 = GsonTools.getPersons(jsonString2, Person.class);
                        Log.i(TAG, list2.toString());
                    }
                }).start();

                break;
            case R.id.liststring:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String path3 = "http://192.168.43.7:8080/jsonProject/servlet/JsonAction?action_flag=liststring";
                        String jsonString3 = HttpUtils.getJsonContent(path3);
                        List<String> list3 = GsonTools.getList( jsonString3);
                        Log.i(TAG, list3.toString());
                    }
                }).start();

                break;
            case R.id.listmap:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String path4 = "http://192.168.43.7:8080/jsonProject/servlet/JsonAction?action_flag=listmap";
                        String jsonString4 = HttpUtils.getJsonContent(path4);
                        List<Map<String, Object>> list4 = GsonTools.getListKeyMaps(
                                jsonString4);
                        Log.i(TAG, list4.toString());
                    }
                }).start();

                break;
        }
    }
}
