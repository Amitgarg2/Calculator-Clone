package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9
                  ,btnAC,btnDELETE,btnDIVIDE,btnMULTI,btnSUB,btnADD,btnEQUALS,btnDOT;

    private TextView textviewhistory,textviewresult;

    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat myformatter = new DecimalFormat("######.######");

    String history, currentresult;

    boolean dot = true;
    boolean btnACcontrol = true;

    boolean btnEQUALScontrol = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 =findViewById(R.id.btn0);
        btn1 =findViewById(R.id.btn1);
        btn2 =findViewById(R.id.btn2);
        btn3 =findViewById(R.id.btn3);
        btn4 =findViewById(R.id.btn4);
        btn5 =findViewById(R.id.btn5);
        btn6 =findViewById(R.id.btn6);
        btn7 =findViewById(R.id.btn7);
        btn8 =findViewById(R.id.btn8);
        btn9 =findViewById(R.id.btn9);

        btnADD =findViewById(R.id.btnADD);
        btnDIVIDE =findViewById(R.id.btnDIVIDE);
        btnMULTI =findViewById(R.id.btnMULTI);
        btnSUB =findViewById(R.id.btnSUB);

        btnAC =findViewById(R.id.btnAC);
        btnDELETE =findViewById(R.id.btnDELETE);
        btnEQUALS =findViewById(R.id.btnEQUALS);
        btnDOT =findViewById(R.id.btnDOT);

        textviewhistory =findViewById(R.id.textviewhistory);
        textviewresult =findViewById(R.id.textviewresult);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = null;
                status = null;
                textviewresult.setText("0");
                textviewhistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
                dot = true;
                btnACcontrol = true;

            }
        });

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textviewhistory.getText().toString();
                currentresult = textviewresult.getText().toString();
                textviewhistory.setText(history+currentresult+"+");
                if (operator)
                {
                    if (status == "multiplication")
                    {
                       multi();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        sub();
                    }
                    else
                    {
                        add();
                    }


                }
                status = "addition";
                operator = false;
                number = null;


            }
        });

        btnSUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textviewhistory.getText().toString();
                currentresult = textviewresult.getText().toString();
                textviewhistory.setText(history+currentresult+"-");

                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multi();
                    } else if (status == "division")
                    {
                        divide();
                    } else if (status == "addition")
                    {
                        add();
                    } else
                    {
                        sub();
                    }


                }
                status = "subtraction";
                operator = false;
                number = null;

            }
        });

        btnDOT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dot)
                {
                    if (number == null)
                    {
                        number = "0.";
                    }
                    else
                    {
                        number = number + ".";
                    }
                }

                textviewresult.setText(number);
                dot = false;

            }
        });

        btnDIVIDE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textviewhistory.getText().toString();
                currentresult = textviewresult.getText().toString();
                textviewhistory.setText(history+currentresult+"/");

                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multi();
                    } else if (status == "addition")
                    {
                        add();
                    } else if (status == "subtraction")
                    {
                        sub();
                    } else
                    {
                        divide();
                    }


                }
                status = "division";
                operator = false;
                number = null;

            }
        });

        btnEQUALS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator)
                {
                    if (status == "addition")
                    {
                        add();
                    }

                    else if (status == "subtraction")
                    {
                        sub();
                        
                    }
                    else if (status == "multiplication")
                    {
                        multi();

                    }
                    else if (status =="division")
                    {
                        divide();

                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textviewresult.getText().toString());
                    }

                }
                operator =  false;
                btnEQUALScontrol = true;

            }
        });

        btnMULTI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textviewhistory.getText().toString();
                currentresult = textviewresult.getText().toString();
                textviewhistory.setText(history+currentresult+"*");

                if (operator)
                {
                    if (status == "addition")
                    {
                        add();
                    } else if (status == "division")
                    {
                        divide();
                    } else if (status == "subtraction")
                    {
                        sub();
                    } else
                    {
                        multi();
                    }


                }
                status = "multiplication";
                operator = false;
                number = null;

            }
        });

        btnDELETE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnACcontrol)
                {
                    textviewresult.setText("0");
                }
                else
                {
                    number = number.substring(0,number.length()-1);
                    if (number.length() == 0)
                    {
                        btnDELETE.setClickable(false);
                    } else if (number.contains("."))
                    {
                        dot = false;

                    }
                    else
                    {
                        dot = true;
                    }


                    textviewresult.setText(number);
                }


            }
        });


    }
    public void numberClick(String view)
    {
        if (number==null)
        {
            number = view;
        }
        else if (btnEQUALScontrol)
        {
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        }


            else
        {
            number = number + view;
        }


        textviewresult.setText(number);
            operator = true;
            btnACcontrol = false;
            btnDELETE.setClickable(true);
            btnEQUALScontrol = false;

    }
    public void add()
    {
        lastNumber = Double.parseDouble(textviewresult.getText().toString());
        firstNumber = firstNumber + lastNumber;
        textviewresult.setText(myformatter.format(firstNumber));
        dot = true;
    }

    public void sub()
    {
        if (firstNumber == 0)
        {
            firstNumber = Double.parseDouble(textviewresult.getText().toString());
        }
        else
        {
            lastNumber = Double.parseDouble(textviewresult.getText().toString());
            firstNumber = firstNumber -  lastNumber;
        }

        textviewresult.setText(myformatter.format(firstNumber));
        dot = true;
    }

    public void multi()
    {
        if (firstNumber == 0)
        {

            firstNumber = 1;

            lastNumber = Double.parseDouble(textviewresult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else
        {

            lastNumber =  Double.parseDouble(textviewresult.getText().toString());
            firstNumber = firstNumber *  lastNumber;
        }
        textviewresult.setText(myformatter.format(firstNumber));
        dot = true;

    }

    public void divide()
    {
        if (firstNumber == 0)
        {

            lastNumber = Double.parseDouble(textviewresult.getText().toString());
            firstNumber =  lastNumber / 1;
        }
        else
        {
            lastNumber =  Double.parseDouble(textviewresult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        textviewresult.setText(myformatter.format(firstNumber));
        dot = true;

    }



}