package com.example.jogodacapital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    HashMap<String, String> capitalCities = new HashMap<>();


    public void populateCapitalCities() {

        capitalCities.put("Acre","Rio Branco");
        capitalCities.put("Alagoas","Maceió");
        capitalCities.put("Amapá","Macapá");
        capitalCities.put("Amazonas","Manaus");
        capitalCities.put("Bahia","Salvador");
        capitalCities.put("Ceará","Fortaleza");
        capitalCities.put("Espírito Santo","Vitória");
        capitalCities.put("Goiás","Goiânia");
        capitalCities.put("Maranhão","São Luís");
        capitalCities.put("Mato Grosso","Cuiabá");
        capitalCities.put("Mato Grosso do Sul","Campo Grande");
        capitalCities.put("Minas Gerais","Belo Horizonte");
        capitalCities.put("Pará","Belém");
        capitalCities.put("Paraíba","João Pessoa");
        capitalCities.put("Paraná","Curitiba");
        capitalCities.put("Pernambuco","Recife");
        capitalCities.put("Piauí","Teresina");
        capitalCities.put("Rio de Janeiro","Rio de Janeiro");
        capitalCities.put("Rio Grande do Norte","Natal");
        capitalCities.put("Rio Grande do Sul","Porto Alegre");
        capitalCities.put("Rondônia","Porto Velho");
        capitalCities.put("Roraima","Boa Vista");
        capitalCities.put("Santa Catarina","Florianópolis");
        capitalCities.put("São Paulo","São Paulo");
        capitalCities.put("Sergipe","Aracajú");
        capitalCities.put("Tocantins","Palmas");
        capitalCities.put("Distrito Federal","Brasília");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateCapitalCities();
        Object[] arrayKeys = capitalCities.keySet().toArray();
        Object key = arrayKeys[new Random().nextInt(arrayKeys.length)];
//        String teste = capitalCities.get(r.nextInt(capitalCities.size()));
        String teste = capitalCities.get(key.toString());

        System.out.println(key + " --> " + teste);
    }
}