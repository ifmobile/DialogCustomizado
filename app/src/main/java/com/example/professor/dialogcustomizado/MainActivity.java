package com.example.professor.dialogcustomizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoginDialog.OnLoginListener {

    private TextView txtLogin;
    private TextView txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDialog loginDialog = new LoginDialog();
                loginDialog.show(getSupportFragmentManager(), "loginDialog");
            }
        });

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtSenha = (TextView) findViewById(R.id.txtSenha);
    }

    @Override
    public void onLogin(String login, String senha) {
        txtLogin.setText("Login: " + login);
        txtSenha.setText("Senha: " + senha);
    }
}
