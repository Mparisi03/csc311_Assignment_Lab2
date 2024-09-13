package org.example.csc311_assignment_lab2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class HelloController {


    @FXML
    private TextField AIRTEXT;

    @FXML
    private Label AIRlabel;

    @FXML
    private Button CAL;

    @FXML
    private TextField LATEXT;

    @FXML
    private Label LAlabel;

    @FXML
    private TextField MPTEXT;

    @FXML
    private Label MPlebel;

    @FXML
    private TextField NOYTEXT;

    @FXML
    private Label NOYlabel;

    @FXML
    private TextField TPTEXT;

    @FXML
    private Label TPlebel;

    @FXML
    void CalculateTotal(ActionEvent event) {
        try {
            //uses parse for the input of the textfields
            double Loan = Double.parseDouble(LATEXT.getText());
            double Interest = Double.parseDouble(AIRTEXT.getText()) / 100;
            int years = Integer.parseInt(NOYTEXT.getText());

            //calculate monthly interest rate

            double monthlyRate = Interest / 12;

            //calculate the number of payments in months

            int payments = years * 12;

            //calculate the monthly payments

            double monthlyPayments = Loan * monthlyRate * Math.pow(1 + monthlyRate, payments)
                    / (Math.pow(1 + monthlyRate, payments) - 1);

            //Calculate the total payments

            double totalPayments = monthlyPayments * payments;


            //set totalPayments
            TPTEXT.setText(String.format("%.2f", totalPayments));
        } catch (NumberFormatException e) {

            //if the user puts an invalid answer in any of the text fields. The statement below will print

            System.out.println("There a invalid answer somewhere, please try again!");

        }





    }

}