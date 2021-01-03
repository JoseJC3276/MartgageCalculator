package com.example.madfinalb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText purchasePrice;
    private EditText downPayment;
    private EditText interestRate;
    private TextView loanAmount;
    private TextView seekBarAmount;
    private SeekBar seekbar;
    private Button  calculateLoanButton;
    private Button tenYearButton;
    private Button twentyYearButton;
    private Button thirtyYearButton;
    private Button clear;
    private double purchaseValue;
    private double downPaymentValue;
    private double interestRateValue;
    private double loanValue;
    private  double monthlyInterestPercent;
    private int seekBarValue;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            switch(view.getId())
            {
                case R.id.LoanAmountButton:
                    loanCalculator();
                    break;
                case R.id.tenYearsButton:
                    monthlyPaymentsForTenYears();
                    break;
                case R.id.twentyYearsButton:
                    monthlyPaymentsForTwentyYears();
                    break;
                case R.id.thirtyYearsButton:
                    monthlyPaymentsForThirtyYears();
                    break;
                case R.id.clearButton:
                    clear();
                    break;
            }


        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // the following assigns then to their equivalent from the design
        purchasePrice = (EditText) findViewById(R.id.PurchasePriceValueET);
        downPayment = (EditText) findViewById(R.id.DownPaymentValueET);
        interestRate = (EditText) findViewById(R.id.InterestRateValueET);
        loanAmount = (TextView) findViewById(R.id.LoanLabelTV);

        calculateLoanButton = (Button) findViewById(R.id.LoanAmountButton);
        calculateLoanButton.setOnClickListener(clickListener);

        tenYearButton = (Button) findViewById(R.id.tenYearsButton);
        tenYearButton.setOnClickListener(clickListener);

        twentyYearButton= (Button) findViewById(R.id.twentyYearsButton);
        twentyYearButton.setOnClickListener(clickListener);

        thirtyYearButton = (Button) findViewById(R.id.thirtyYearsButton);
        thirtyYearButton.setOnClickListener(clickListener);

        clear = (Button) findViewById(R.id.clearButton);
        clear.setOnClickListener(clickListener);

        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekBarAmount = (TextView) findViewById(R.id.seekBarNumberTV);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double payments = loanValue * (monthlyInterestPercent * Math.pow((1+monthlyInterestPercent), (progress*12))) / (Math.pow((1+monthlyInterestPercent), (progress * 12)) -1);;

                seekBarAmount.setText("You Chose " + String.valueOf(progress) + " Amount of  Years" + " and paying " + payments + " Dollars Monthly" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void clear()
    {
        purchaseValue = 0;
        downPaymentValue = 0;
        interestRateValue = 0;
        loanAmount.setText(" 0 ");
        seekBarAmount.setText(" 0 ");
        purchasePrice.setText("0");
        downPayment.setText("0");
        interestRate.setText("0");


    }
    private void loanCalculator()
    {
       purchaseValue =  Integer.valueOf(purchasePrice.getText().toString());
       downPaymentValue = Integer.valueOf(downPayment.getText().toString());
       interestRateValue =Integer.valueOf(interestRate.getText().toString());
       loanValue = purchaseValue - downPaymentValue;

        loanAmount.setText("Your Recommended loan is: "+ loanValue + " ");
    }

    private void monthlyPaymentsForTenYears()
    {
        double payments;
        purchaseValue =  Integer.valueOf(purchasePrice.getText().toString());
        downPaymentValue = Integer.valueOf(downPayment.getText().toString());
        interestRateValue =Integer.valueOf(interestRate.getText().toString());
        loanValue = purchaseValue - downPaymentValue;


        monthlyInterestPercent = (interestRateValue /100) / 12;

        payments = loanValue * (monthlyInterestPercent * Math.pow((1+monthlyInterestPercent), 120)) / (Math.pow((1+monthlyInterestPercent), 120) -1);

        loanAmount.setText("Monthly payments for 10 year loan: "+ payments + " ");


    }

    private void monthlyPaymentsForTwentyYears()
    {
        double payments;
        purchaseValue =  Integer.valueOf(purchasePrice.getText().toString());
        downPaymentValue = Integer.valueOf(downPayment.getText().toString());
        interestRateValue =Integer.valueOf(interestRate.getText().toString());
        loanValue = purchaseValue - downPaymentValue;

        monthlyInterestPercent = (interestRateValue /100) / 12;

        payments = loanValue * (monthlyInterestPercent * Math.pow((1+monthlyInterestPercent), 240)) / (Math.pow((1+monthlyInterestPercent), 240) -1);
        loanAmount.setText("Monthly payments for 20 year loan: "+ payments + " ");

    }

    private void monthlyPaymentsForThirtyYears()
    {
        double payments;
        purchaseValue =  Integer.valueOf(purchasePrice.getText().toString());
        downPaymentValue = Integer.valueOf(downPayment.getText().toString());
        interestRateValue =Integer.valueOf(interestRate.getText().toString());
        loanValue = purchaseValue - downPaymentValue;

        monthlyInterestPercent = (interestRateValue /100) / 12;

        payments = loanValue * (monthlyInterestPercent * Math.pow((1+monthlyInterestPercent), 360)) / (Math.pow((1+monthlyInterestPercent), 360) -1);
        loanAmount.setText("Monthly payments for 30 year loan: "+ payments + " ");


    }

}