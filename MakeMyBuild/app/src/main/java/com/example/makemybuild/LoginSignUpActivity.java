package com.example.makemybuild;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.makemybuild.utils.PrefManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginSignUpActivity extends AppCompatActivity {

    private LinearLayout google_button;
    GoogleSignInClient mGoogleSignInClient;
    private Dialog loadingDialog;
    private static int RC_SIGN_IN=100;
    private Button signin,signup;
    private FirebaseAuth auth;
    private EditText et_email,et_password;
    PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        prefManager=new PrefManager(this);
        loadingDialog = new Dialog(this);
        loadingDialog.setContentView(R.layout.loading);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Objects.requireNonNull(loadingDialog.getWindow()).setBackgroundDrawable(getDrawable(R.drawable.rounded_corners));
        }
        Objects.requireNonNull(loadingDialog.getWindow()).setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        loadingDialog.setCancelable(false);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        google_button=findViewById(R.id.google_button);
        google_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog.show();
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
                loadingDialog.dismiss();
            }
        });
        auth = FirebaseAuth.getInstance();
        et_email=findViewById(R.id.editTextTextEmailAddress);
        et_password=findViewById(R.id.editTextTextPassword);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog.show();
                String email = et_email.getText().toString().trim();
                prefManager.saveEmail(email);
                String password = et_password.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    loadingDialog.dismiss();
                    et_email.setError("Field is empty!");
                    //Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    loadingDialog.dismiss();
                    et_email.setError("Field is empty!");
                    //Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    loadingDialog.dismiss();
                    et_password.setError("Password too short, enter minimum 6 characters!");
                    //Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginSignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    loadingDialog.dismiss();
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(LoginSignUpActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(LoginSignUpActivity.this,BudgetActivity.class);
                                    startActivity(intent);
                                } else {
                                    loadingDialog.dismiss();
                                    // If sign in fails, display a message to the user.
                                    //Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginSignUpActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();


                                }
                            }
                        });
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog.show();
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    loadingDialog.dismiss();
                    et_email.setError("Field is empty!");
                    //Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    loadingDialog.dismiss();
                    et_email.setError("Field is empty!");
                    //Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    loadingDialog.dismiss();
                    et_password.setError("Password too short, enter minimum 6 characters!");
                    //Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginSignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Toast.makeText(EmailActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                if (!task.isSuccessful()) {
                                    loadingDialog.dismiss();
                                    Toast.makeText(LoginSignUpActivity.this, "Sorry, this Email is already in use.", Toast.LENGTH_SHORT).show();
                                } else {
                                    loadingDialog.dismiss();
                                    startActivity(new Intent(LoginSignUpActivity.this, BudgetActivity.class));
                                    Toast.makeText(LoginSignUpActivity.this, "Account Created Successfully.", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        });
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // callbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        loadingDialog.show();
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Toast.makeText(this, "Login Successful ", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(LoginSignUpActivity.this,BudgetActivity.class);
            startActivity(intent);
            loadingDialog.dismiss();

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
            loadingDialog.dismiss();
        }
    }
}