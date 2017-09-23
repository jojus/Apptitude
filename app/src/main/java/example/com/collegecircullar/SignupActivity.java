package example.com.collegecircullar;

/**
 * Created by Justin Joy (jojus) on 04-08-2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = SignupActivity.class.getSimpleName();
    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public SignupActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        btnSignIn = (Button) findViewById(R.id.already_member);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);

        progressDialog = new ProgressDialog(SignupActivity.this);


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    Toast.makeText(SignupActivity.this,
                            "Successfully signed in with: " + user.getEmail(),
                            Toast.LENGTH_LONG).show();
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    Toast.makeText(SignupActivity.this, "Successfully signed out.",
                            Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            auth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void userRegister() {
        // getting user entered email and password
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            // email is empty
            Toast.makeText(getApplicationContext(), "Enter email address!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            // password is empty
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            // password length is minimum 6 chars
            Toast.makeText(getApplicationContext(),
                    "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            // authentication failed
                            Toast.makeText(SignupActivity.this, "Authentication failed",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // Successfully register then move to login activity
                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == btnSignUp) {
            // Register
            Log.i(TAG,"button signup");
            userRegister();
        }
        if (v == btnSignIn) {
            //  move to login activity
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
        }
    }


}