package lin_ge.restaurantadvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static Login_System login;//login system that holds all emails and passwords

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
       login = Login_System.deserializeOBJ();

        Button loginButton = (Button) findViewById(R.id.login);
        Button guestButton = (Button) findViewById(R.id.guest);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        guestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

    }
}
