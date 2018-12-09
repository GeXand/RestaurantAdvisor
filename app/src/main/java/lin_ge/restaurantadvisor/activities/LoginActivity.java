package lin_ge.restaurantadvisor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import lin_ge.restaurantadvisor.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    public static String USER_EMAIL = "USER_EMAIL";
    private EditText email;
    private EditText password;
    private Button login;
    private boolean canceled;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        canceled = false;

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                attemptLogin(email.getText().toString(), password.getText().toString());
                if(!canceled)
                {
                    if(!MainActivity.login.isThereUser(email.getText().toString()))
                        MainActivity.login.addUser(email.getText().toString(),password.getText().toString());
                    Intent intent = new Intent(LoginActivity.this, SearchActivity.class);
                    USER_EMAIL = email.getText().toString();
                    startActivity(intent);
                }

                else {
                    email.setText("");
                    password.setText("");
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Email/Password", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    private void attemptLogin(String email, String password)
    {
        if(email.isEmpty() || password.isEmpty())
            canceled = true;
        if(!email.contains("@"))
            canceled = true;
        if(password.length() < 4)
            canceled = true;
        if(MainActivity.login.isThereUser(email) && !MainActivity.login.findUser(email).equals(password))
            canceled = true;
    }
}

