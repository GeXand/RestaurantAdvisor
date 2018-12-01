package lin_ge.restaurantadvisor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    public static final String USER_EMAIL = "USER_EMAIL";
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
                    Intent i = new Intent(LoginActivity.this, SearchActivity.class);
                    i.putExtra(LoginActivity.USER_EMAIL, email.getText());
                    startActivity(i);
                }

                else {
                    if(!(MainActivity.login.isThereUser(email.toString()) && MainActivity.login.findUser(email.toString()).equals((password))))
                        MainActivity.login.addUser(email.toString(),password.toString());
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

