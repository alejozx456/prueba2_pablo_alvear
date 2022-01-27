package example.com.prueba2_pablo_alvear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Usuario_Login_PAAV extends AppCompatActivity {

    private EditText usuario;
    private EditText password;

    String user1="alejozx456";
    String passusser1="aaa";

    String user2="pablozx456";
    String passusser2="bbb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_login_paav);




        usuario=findViewById(R.id.IdUsuarioPAAV);
        password=findViewById(R.id.IdPasswordPAAV);

    }
    public void IngresarPAAV(View view){
        Intent i = new Intent(this,MainActivity_PAAV.class);
        if(usuario.equals("alejozx456") && password.equals("aaa")){
            startActivity(i);
        }else {
            Toast.makeText(this,"Error en las credenciales",Toast.LENGTH_LONG).show();
        }


    }
}