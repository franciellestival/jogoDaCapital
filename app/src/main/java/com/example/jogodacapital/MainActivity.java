package com.example.jogodacapital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    HashMap<String, String> capitalCities = new HashMap<>();
    String capital;
    int totalScore, questionCounter;

    public void populateCapitalCities() {

        capitalCities.put("Acre", "Rio Branco");
        capitalCities.put("Alagoas", "Maceió");
        capitalCities.put("Amapá", "Macapá");
        capitalCities.put("Amazonas", "Manaus");
        capitalCities.put("Bahia", "Salvador");
        capitalCities.put("Ceará", "Fortaleza");
        capitalCities.put("Espírito Santo", "Vitória");
        capitalCities.put("Goiás", "Goiânia");
        capitalCities.put("Maranhão", "São Luís");
        capitalCities.put("Mato Grosso", "Cuiabá");
        capitalCities.put("Mato Grosso do Sul", "Campo Grande");
        capitalCities.put("Minas Gerais", "Belo Horizonte");
        capitalCities.put("Pará", "Belém");
        capitalCities.put("Paraíba", "João Pessoa");
        capitalCities.put("Paraná", "Curitiba");
        capitalCities.put("Pernambuco", "Recife");
        capitalCities.put("Piauí", "Teresina");
        capitalCities.put("Rio de Janeiro", "Rio de Janeiro");
        capitalCities.put("Rio Grande do Norte", "Natal");
        capitalCities.put("Rio Grande do Sul", "Porto Alegre");
        capitalCities.put("Rondônia", "Porto Velho");
        capitalCities.put("Roraima", "Boa Vista");
        capitalCities.put("Santa Catarina", "Florianópolis");
        capitalCities.put("São Paulo", "São Paulo");
        capitalCities.put("Sergipe", "Aracajú");
        capitalCities.put("Tocantins", "Palmas");
        capitalCities.put("Distrito Federal", "Brasília");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Cria o hashmap com as capitais
        populateCapitalCities();
        //Sorteia um estado para iniciar o jogo
        String stateString = sortState();
        TextView state = findViewById(R.id.textViewEstado);
        state.setText(stateString);
        questionCounter = 0;
    }

    //Busca no hashmap de forma aleatória um estado, e salva sua capital para posterior verificação
    public String sortState() {
        Object[] arrayKeys = capitalCities.keySet().toArray();
        Object key = arrayKeys[new Random().nextInt(arrayKeys.length)];
        capital = capitalCities.get(key.toString());
        return key.toString();
    }

    //Verifica se a resposta informada pelo usuario esta correta
    public void checkAnswer(View view) {
        TextView checkAnswer = findViewById(R.id.textViewResposta);
        TextView score = findViewById(R.id.textViewPontuacao);
        EditText answer = findViewById(R.id.editTextResposta);
        Button answerButton = findViewById(R.id.buttonResponder);
        Button next = findViewById(R.id.buttonProxima);

        //Se a resposta nao foi preenchida, alerta o usuario
        if (answer.length() == 0) {
            Toast.makeText(this, "Digite sua resposta", Toast.LENGTH_SHORT).show();
            return;
        }

        //Verifica a resposta dada com a capital salva
        if (answer.getText().toString().trim().equalsIgnoreCase(capital)) {
            checkAnswer.setText("Você acertou!");
            totalScore += 10;
        } else {
            checkAnswer.setText("Você errou!");
        }

        //Desabilita o botao de resposta e exibe a pontuacao atual
        answerButton.setEnabled(false);
        questionCounter++;
        score.setText(String.valueOf(totalScore));

        //Caso ja foram respondidas 5 perguntas, fim de jogo
        // Muda o botao "proxima" para "reiniciar" e exibe a pontuacao final
        if (questionCounter >= 5) {
            questionCounter = 0;
            checkAnswer.setText("Game Over! Sua Pontuação: " + totalScore);
            next.setText("Reiniciar");
            answer.setText("");
            totalScore = 0;
        }
    }

    //Limpa os dados da tela e gera uma nova pergunta
    public void nextQuestion(View view) {
        TextView state = findViewById(R.id.textViewEstado);
        TextView checkAnswer = findViewById(R.id.textViewResposta);
        TextView score = findViewById(R.id.textViewPontuacao);
        EditText answer = findViewById(R.id.editTextResposta);
        Button answerButton = findViewById(R.id.buttonResponder);
        Button next = findViewById(R.id.buttonProxima);


        String stateString = sortState();
        state.setText(stateString);
        answer.setText("");
        checkAnswer.setText("");
        next.setText("Próxima");
        answerButton.setEnabled(true);
        score.setText(String.valueOf(totalScore));
    }
}