package edu.dlg.classapps.beerselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class BeerColorSelectionScreen extends AppCompatActivity {

    private BeerBrandExpert selector;
    private BeerFeedback beerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_color_selection_screen);

        this.setFeedbackVisibility(false);

        this.selector = new BeerBrandExpert();
        Spinner typeSelector = (Spinner) findViewById(R.id.bs_spinner);


        typeSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setFeedbackVisibility(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    public void onClickFindBeer(View view) {
        Spinner typeSelector = (Spinner) findViewById(R.id.bs_spinner);
        TextView resultText = (TextView) findViewById(R.id.bs_result);
        RatingBar beerRating = (RatingBar) findViewById(R.id.bs_rating);
        EditText beerComment = (EditText) findViewById(R.id.bs_comment);
        String typeSelected = String.valueOf(typeSelector.getSelectedItem());

        this.beerResult = this.selector.getBrand(typeSelected);
        this.setFeedbackVisibility(true);
        resultText.setText(beerResult.getName());
        beerRating.setRating(beerResult.getRating());
        beerComment.setText(beerResult.getComment());


        Log.d("RATING RECEIVED", beerResult.getName() + " " + beerResult.getComment() + " " + beerResult.getRating());
    }

    public void onClickRateBeer(View view) {
        RatingBar beerRating = (RatingBar) findViewById(R.id.bs_rating);
        EditText beerComment = (EditText) findViewById(R.id.bs_comment);

        this.beerResult.setRating(beerComment.getText().toString(), (int) beerRating.getRating());
        Log.d("RATING SENT", beerResult.getName() + " " + beerComment.getText().toString() + " " + beerRating.getRating());
    }

    private void setFeedbackVisibility(Boolean visibility) {
        int newVisibility;
        if (visibility) {
            newVisibility = View.VISIBLE;
        }
        else {
            newVisibility = View.INVISIBLE;
        }
        TextView resultText = (TextView) findViewById(R.id.bs_result);
        RatingBar beerRating = (RatingBar) findViewById(R.id.bs_rating);
        EditText beerComment = (EditText) findViewById(R.id.bs_comment);
        Button rateButton = (Button) findViewById(R.id.bs_button_rate);

        resultText.setVisibility(newVisibility);
        beerRating.setVisibility(newVisibility);
        beerComment.setVisibility(newVisibility);
        rateButton.setVisibility(newVisibility);
    }

}
