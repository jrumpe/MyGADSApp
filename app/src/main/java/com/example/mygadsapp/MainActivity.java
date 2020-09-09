package com.example.mygadsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mygadsapp.adapters.MyRecAdapter;
import com.example.mygadsapp.models.LearnerLeadersModel;
import com.example.mygadsapp.models.SubmitForm;
import com.example.mygadsapp.retrofit.MyAPI;
import com.example.mygadsapp.retrofit.MyClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        init();

    }

    private void mValidate() {
        String fname, lname, email, link;

        fname = edtFname.getText().toString().trim();
        lname = edtLname.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        link = edtLink.getText().toString().trim();

        if (fname.isEmpty()){
            edtFname.setError("Enter First Name");
            edtFname.setFocusable(true);
        }if (lname.isEmpty()){
            edtLname.setError("Last Name Required");
            edtLname.setFocusable(true);
        }if (email.isEmpty()){
            edtEmail.setError("Enter Email Address");
        }if (link.isEmpty()){
            edtLink.setError("Enter Link to Project");
            edtLink.setFocusable(true);
        }else{
            showConfirmAlert();
//            submitData();
        }
        }

    private void submitData() {
        Toast.makeText(this, "loading data", Toast.LENGTH_SHORT).show();
        Retrofit retrofit = MyClient.getRetrofitClient("https://docs.google.com/forms/d/e/");
        MyAPI myAPI = retrofit.create(MyAPI.class);
        Call<String> observable = myAPI.postUser("", "", "", "");
        observable.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                showSuccessAlert();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                showSubmissionFailed();

            }
        });

    }

    private void showSubmissionFailed() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_warning, null, false);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.show();
    }

    private void init() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValidate();
//                showConfirmAlert();
            }
        });
    }

    private void showConfirmAlert() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_confirm, null, false);
        TextView btnYes = (TextView) view.findViewById(R.id.btnYes);
        ImageView img_cancel = (ImageView) view.findViewById(R.id.img_cancel);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitData();
//                showSuccessAlert();

            }
        });
        builder.setView(view);
        builder.show();
    }

    private void showSuccessAlert() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_success, null, false);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.show();
    }


    private ImageView imgBack;
    private EditText edtFname;
    private EditText edtLname;
    private EditText edtEmail;
    private EditText edtLink;
    private Button btnSubmit;

    public void initViews() {
        imgBack = (ImageView) findViewById(R.id.img_back);
        edtFname = (EditText) findViewById(R.id.edt_fname);
        edtLname = (EditText) findViewById(R.id.edt_lname);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtLink = (EditText) findViewById(R.id.edt_link);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
    }

}