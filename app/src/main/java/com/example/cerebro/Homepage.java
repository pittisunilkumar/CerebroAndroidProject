package com.example.cerebro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Homepage extends AppCompatActivity {
    FirebaseUser currentUser;
    FirebaseAuth auth;

    RecyclerView re;
    ApiInterface apiInterface;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        apiInterface = Retrofitinstance.getRetrofit().create(ApiInterface.class);
        re = findViewById(R.id.recy);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();

        if(currentUser==null){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }

        apiInterface.getposts().enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {

                if(response.isSuccessful()){
                    adapter = new Adapter(response.body().getData().getRegional(),Homepage.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Homepage.this);
                    re.setLayoutManager(linearLayoutManager);
                    re.setAdapter(adapter);
                    re.addItemDecoration(new DividerItemDecoration(Homepage.this,DividerItemDecoration.VERTICAL));
                    Toast.makeText(Homepage.this, "success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(Homepage.this, "" +
                        t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.men,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        MenuItem sigout = menu.findItem(R.id.signout);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        sigout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                auth.signOut();
                Toast.makeText(Homepage.this, "Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Homepage.this,MainActivity.class));
                finish();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}