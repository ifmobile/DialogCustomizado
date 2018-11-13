package com.example.professor.dialogcustomizado;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialog extends AppCompatDialogFragment
    implements DialogInterface.OnClickListener {

    private EditText edtLogin;
    private EditText edtSenha;
    private OnLoginListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.titleDialog);


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_login, null);

        builder.setView(layout);

        edtLogin = layout.findViewById(R.id.edtLogin);
        edtSenha = layout.findViewById(R.id.edtSenha);

        builder.setPositiveButton(R.string.positive, this);
        builder.setNegativeButton(R.string.negative, this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if(which == DialogInterface.BUTTON_POSITIVE){
            String login = edtLogin.getText().toString();
            String senha = edtSenha.getText().toString();

            if (login.equals("login") && senha.equals("123456")){
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);

            }
            else
                Toast.makeText(getActivity(), R.string.loginFail,
                        Toast.LENGTH_SHORT).show();
                if(listener != null)
                    listener.onLogin(login,senha);
        }
        else if (which == DialogInterface.BUTTON_NEGATIVE){
            Toast.makeText(getActivity(), R.string.loginCancel,
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof OnLoginListener)) {
            throw new IllegalArgumentException("A activity deve implementar LoginDialog.OnLoginListener");
        }
        this.listener = (OnLoginListener) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnLoginListener{
        public void onLogin(String login, String senha);
    }


}
