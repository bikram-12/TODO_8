package gcit.edu.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText webidText,locaidText, shareidText;
    private Button webbutton1,locbutton2, sharebutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webidText = findViewById(R.id.openwebsite);
        locaidText = findViewById(R.id.openlocation);
        shareidText = findViewById(R.id.sharetext);


    }


    public void website(View view) {
        String msg = webidText.getText().toString();
        Uri uri = Uri.parse(msg);
        Intent intent = new Intent (Intent.ACTION_SEND,uri);
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
        else {
            Log.d("Implicit intent", "Error message");
        }
    }

    public void location(View view) {
        String msg = locaidText.getText().toString();
        Uri uri = Uri.parse("geo = 0, 0?q=" +msg);
        Intent intent = new Intent(Intent.ACTION_SEND, uri);
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
        else {
            Log.d("Implicit intent", "Error message");
        }
    }

    public void Share(View view) {
        String msg = shareidText.getText().toString();
        String mimeType = "text/plan";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with:")
                .setText(msg)
                .startChooser();



    }
}