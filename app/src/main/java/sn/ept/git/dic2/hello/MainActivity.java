package sn.ept.git.dic2.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sn.ept.git.dic2.hello.Models.Personne;
import sn.ept.git.dic2.hello.config.ApiEndpoint;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "name";
    private EditText prenomEditText;
    private EditText nomEditText;
    private EditText mailEditText;
    private EditText birthdayText;
    private TextView errorEditText;
    private ImageButton saveButton, listPersonButton;
    private static final String TAG = "DIC_MainActivity";

    Personne editPersonne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_personne);
        Log.v(TAG, "Démarrage de l'application");

        getSupportActionBar().setTitle("Ajouter");


        prenomEditText = findViewById(R.id.firstname);
        nomEditText = findViewById(R.id.lastname);
        mailEditText = findViewById(R.id.email);
        birthdayText = findViewById(R.id.birthday);
        errorEditText = findViewById(R.id.errorText);

        listPersonButton = findViewById(R.id.btn_list_person);
        listPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBienvenue();
            }
        });


        saveButton = findViewById(R.id.signup);
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                errorEditText.setText("");
                String prenom = ""+prenomEditText.getText();
                String nom = ""+ nomEditText.getText();
                String mail = ""+ mailEditText.getText();
                String birthday = ""+ birthdayText.getText();

                Log.i(TAG, "Enregistrement réussi de "+ prenom+ " "+ nom);

                if(prenom.isEmpty() || nom.isEmpty() || mail.isEmpty() || birthday.isEmpty()){
                    errorEditText.setText("Veuillez remplir tous les champs");
                }else{
                    savePersonne();
                    openBienvenue();
                }

            }
        });
    }

    public void openBienvenue() {
        Intent intent = new Intent(this, ListPersonActivity.class);
//        intent.putExtra(EXTRA_NAME,name);
        startActivity(intent);
    }



    private void savePersonne() {
        String prenom = prenomEditText.getText().toString();
        String nom  = nomEditText.getText().toString();
        String mail = mailEditText.getText().toString();
        String birthday = birthdayText.getText().toString();

        Personne newPersonne =  new Personne(mail, "kalidou", prenom, nom);
        createPersonne(newPersonne);
    }


    private void createPersonne(Personne p) {
        // set message
//        progressDialog.show();
        (ApiEndpoint.getApiClient().addPersonne("kalidou", p)).enqueue(new Callback<Personne>() {

            @Override
            public void onResponse(Call<Personne> call, Response<Personne> response) {
                if (response.body() != null) {
                    Personne p = response.body();
//                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Personne: " + p.getPrenom() + " " + p.getNom() + " crée avec succès!!", Toast.LENGTH_LONG).show();
                } else {
//                    showMessage("Une erreur est survenue");
                    Toast.makeText(MainActivity.this, "Une erreur est survenue", Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Personne> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.d("ERROR-GET-DIC", t.toString());

            }
        });

    }

}
