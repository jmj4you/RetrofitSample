package in.easy2rent.jmj;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;


public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        /* Button click*/
        final Button button = (Button) findViewById(R.id.my_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                try {
                    myRetro();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void myRetro() throws IOException {
        Log.i("*****>>>", " MyRetro callingg");
        // Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);

        // Fetch and print a list of the contributors to this library.
//        Call<List<Contributor>> call =
//                client.contributors("ggg","android-boilerplate");
//        List<Contributor> contributors = call.execute().body();
//        Log.e("resul->",contributors+"");

        Call<ApiResults> call = client.GetAgent();
        ApiResults rst = call.execute().body();
        Log.e("result->", rst.getStatus() + "");
        Log.e("agent->", rst.getData() + "");
        List<Agent> agents = rst.getData();
        for (int i = 0; i < agents.size(); i++) {

            Log.i(agents.get(i).getId() + "", agents.get(i).getName() + "");
        }

      /*  try {
            contributors =
        } catch (IOException e) {
            // handle errors
        }*/

        //    Contributor[] contributors = new Contributor[0];
//        for (Contributor contributor : contributors) {
//            System.out.println(
//                    contributor.login + " (" + contributor.contributions + ")");
//        }
    }
}
