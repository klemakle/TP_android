package sn.ept.git.dic2.hello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sn.ept.git.dic2.hello.Adapters.PersonneAdapter;
import sn.ept.git.dic2.hello.Models.Personne;
import sn.ept.git.dic2.hello.config.ApiEndpoint;

public class ListPersonActivity extends AppCompatActivity {
    private RecyclerView rv;
    private List<Personne> allPersonnes;
    private PersonneAdapter personneAdapter;
    private ImageButton add_btn, voir_btn;

    private static final int ADD_ELEVE_REQUEST = 1;
    private static final int ADD_PERSONNE_REQUEST = 2;
    private static final int EDIT_EDIT_REQUEST = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_person);

//        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Liste des Personnes");

        rv = findViewById(R.id.recycle_view);
        getPersonneListData();

        add_btn = findViewById(R.id.ajouter);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddActivity();
            }
        });

        voir_btn = findViewById(R.id.voir_btn);
        voir_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetail();
            }
        });

    }

    public void openAddActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openDetail(){
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    private void getPersonneListData() {

        (ApiEndpoint.getApiClient().getAllPersonnes("kalidou")).enqueue(new Callback<List<Personne>>() {
            @Override
            public void onResponse(Call<List<Personne>> call, Response<List<Personne>> response) {
                allPersonnes = response.body();
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<List<Personne>> call, Throwable t) {
                Toast.makeText(ListPersonActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListPersonActivity.this);
        rv.setLayoutManager(linearLayoutManager);
        personneAdapter = new PersonneAdapter(ListPersonActivity.this, allPersonnes);
        rv.setAdapter(personneAdapter); // set the Adapter to RecyclerView

    }

}
