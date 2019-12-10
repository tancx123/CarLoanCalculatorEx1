package com.example.carloancalculatorex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carloancalculatorex1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            val CarPrice = editTextCarPrice.text.toString()
            val DownPayment = editTextDownPayment.text.toString()
            val LoanPeriod = editTextLoanPeriod.text.toString()
            val InterestRate = editTextInterestRate.text.toString()

            val Loan:Double =  CarPrice.toDouble() - DownPayment.toDouble()
            val Interest:Double = Loan * (InterestRate.toDouble()/100) * LoanPeriod.toDouble()
            val MonthlyPayment:Double = (Loan + Interest) / LoanPeriod.toDouble() / 12

            textViewLoan.text = "Loan: " + "%.2f".format(Loan)
            textViewInterest.text = "Interest: " + "%.2f".format(Interest)
            textViewMonthlyRepayment.text = "Monthly Payment: " + "%.2f".format(MonthlyPayment)

        }

        buttonReset.setOnClickListener{
            editTextCarPrice.setText("")
            editTextDownPayment.setText("")
            editTextInterestRate.setText("")
            editTextLoanPeriod.setText("")
            textViewLoan.text = "Loan : "
            textViewInterest.text = "Interest :"
            textViewMonthlyRepayment.text = "Monthly Payment :"
        }
    }


}
