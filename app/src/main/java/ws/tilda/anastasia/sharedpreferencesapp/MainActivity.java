package ws.tilda.anastasia.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_FILE = "ws.tilda.anastasia.sharedpreferencesapp.preferences";
    private static final String KEY_EDITTEXT = "KEY_EDITTEXT" ;
    private SharedPreferences.Editor mEditor;
    private EditText mEditText;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        // Resuming the stored data (in onPause method)
        String editText = mSharedPreferences.getString(KEY_EDITTEXT,"");
        mEditText.setText(editText);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mEditor.putString(KEY_EDITTEXT, mEditText.getText().toString());
        mEditor.apply();
    }
}
