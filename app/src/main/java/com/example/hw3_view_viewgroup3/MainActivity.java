package com.example.hw3_view_viewgroup3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String, String> ruEnMap = new HashMap<String, String>();
    Map<String, String> enRuMap = new HashMap<String, String>();

    Map<String, String> enRuMap2 = new HashMap<String, String>();
    Map<String, String> enRuMap4 = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ruEnMap.put("а", "a");
        ruEnMap.put("б", "b");
        ruEnMap.put("в", "v");
        ruEnMap.put("г", "g");
        ruEnMap.put("д", "d");
        ruEnMap.put("е", "e");
        ruEnMap.put("ё", "e");
        ruEnMap.put("ж", "zh");
        ruEnMap.put("з", "z");
        ruEnMap.put("и", "i");
        ruEnMap.put("й", "i");
        ruEnMap.put("к", "k");
        ruEnMap.put("л", "l");
        ruEnMap.put("м", "m");
        ruEnMap.put("н", "n");
        ruEnMap.put("о", "o");
        ruEnMap.put("п", "p");
        ruEnMap.put("р", "r");
        ruEnMap.put("с", "s");
        ruEnMap.put("т", "t");
        ruEnMap.put("у", "u");
        ruEnMap.put("ф", "f");
        ruEnMap.put("х", "kh");
        ruEnMap.put("ц", "ts");
        ruEnMap.put("ч", "ch");
        ruEnMap.put("ш", "sh");
        ruEnMap.put("щ", "shch");
        ruEnMap.put("ы", "y");
        ruEnMap.put("ь", "");
        ruEnMap.put("ъ", "ie");
        ruEnMap.put("э", "e");
        ruEnMap.put("ю", "iu");
        ruEnMap.put("я", "ia");

        enRuMap4.put("shch", "щ");

        enRuMap2.put("zh", "ж");
        enRuMap2.put("kh", "х");
        enRuMap2.put("ts", "ц");
        enRuMap2.put("ch", "ч");
        enRuMap2.put("sh", "ш");
        enRuMap2.put("ie", "ъ");
        enRuMap2.put("iu", "ю");
        enRuMap2.put("ia", "я");

        enRuMap.put("a", "а");
        enRuMap.put("b", "б");
        enRuMap.put("c", "с");
        enRuMap.put("d", "д");
        enRuMap.put("e", "е");
        enRuMap.put("f", "ф");
        enRuMap.put("g", "г");
        enRuMap.put("h", "х");
        enRuMap.put("i", "и");
        enRuMap.put("j", "ж");
        enRuMap.put("k", "к");
        enRuMap.put("l", "л");
        enRuMap.put("m", "м");
        enRuMap.put("n", "н");
        enRuMap.put("o", "о");
        enRuMap.put("p", "п");
        enRuMap.put("q", "к");
        enRuMap.put("r", "р");
        enRuMap.put("s", "с");
        enRuMap.put("t", "т");
        enRuMap.put("u", "у");
        enRuMap.put("v", "в");
        enRuMap.put("w", "в");
        enRuMap.put("x", "кс");
        enRuMap.put("y", "ы");
        enRuMap.put("z", "з");
    }

    public void translateRuEn(View v)
    {
        EditText editTextRu = (EditText)findViewById(R.id.editTextRu);
        String editTextRuValue = editTextRu.getText().toString();


        StringBuilder enString = new StringBuilder("");

        for (int i = 0; i < editTextRuValue.length(); i++) {
            String cRu = String.valueOf(editTextRuValue.charAt(i));
            enString.append(ruEnMap.get(cRu));
        }

        EditText editTextEn = (EditText)findViewById(R.id.editTextEn);
        editTextEn.setText(enString);
    }

    public void translateEnRu(View v)
    {
        EditText editTextEn = (EditText)findViewById(R.id.editTextEn);
        String editTextEnValue = editTextEn.getText().toString();


        StringBuilder ruString = new StringBuilder("");


        for (int i = 0; i < editTextEnValue.length(); i++) {
            String cEn = String.valueOf(editTextEnValue.charAt(i));
            if (i < editTextEnValue.length() - 3) {
                String cEn4 = editTextEnValue.substring(i, i + 4);
                if (enRuMap4.containsKey(cEn4)) {
                    ruString.append(enRuMap4.get(cEn4));
                    i += 3;
                    continue;
                }
            }

            if (i < editTextEnValue.length() - 1) {
                String cEn2 = editTextEnValue.substring(i, i + 2);
                if (enRuMap2.containsKey(cEn2)) {
                    ruString.append(enRuMap2.get(cEn2));
                    i += 1;
                    continue;
                }
            }

            ruString.append(enRuMap.get(cEn));
        }

        EditText editTextRu = (EditText)findViewById(R.id.editTextRu);
        editTextRu.setText(ruString);
    }
}