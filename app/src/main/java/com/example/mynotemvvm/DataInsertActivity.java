package com.example.mynotemvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mynotemvvm.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {

    ActivityDataInsertBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String type = getIntent().getStringExtra("type");
        if (type.equals("update")) {
                setTitle("Update");
                binding.titleRv.setText(getIntent().getStringExtra("title"));
                binding.disp.setText(getIntent().getStringExtra("Disp"));
               int id = getIntent().getIntExtra("Id",0 );
               binding.add.setText("update note");
               binding.add.setOnClickListener(new View.OnClickListener() {

                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent();
                       intent.putExtra("title", binding.titleRv.getText().toString());
                       intent.putExtra("disp", binding.disp.getText().toString());
                       intent.putExtra("Id", id);
                       setResult(RESULT_OK, intent);
                       finish();
                   }
               });
        } else {

            setTitle("Add Data");
            binding.add.setOnClickListener((View.OnClickListener) view -> {

                Intent intent = new Intent();
                intent.putExtra("title", binding.titleRv.getText().toString());
                intent.putExtra("disp", binding.disp.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            });
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this, MainActivity.class));
    }
}