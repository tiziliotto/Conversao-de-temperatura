import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;


public class ConvertTemperature extends JFrame implements ActionListener {
    private JPanel panelA, panelB, panelC, panelD, panelE;
    private JButton butConvert, butReset;
    private JRadioButton CelsiusIn, CelsiusOut, FahrenheitIn, FahrenheitOut, KelvinIn, KelvinOut;
    private JLabel input, inputEscala, output, outputEscala, titulo;
    private JTextField inputText, outputText;
    private ButtonGroup entrada, saida;


    public ConvertTemperature () {
        super("Conversor de temperaturas");
        this.setLayout (new BorderLayout ());
        
        //primeiro painel (ao norte)
        panelA = new JPanel();
        input = new JLabel("Entrada");
        inputText = new JTextField(15);
        
        panelA.add(input);
        panelA.add(inputText);
        this.getContentPane().add(panelA, "North");
        
        
        //segundo painel (ao oeste)
        panelB = new JPanel();
        panelB.setLayout(new BoxLayout(panelB, BoxLayout.Y_AXIS));
        inputEscala = new JLabel("Escala de entrada");
        ButtonGroup entrada = new ButtonGroup();
        CelsiusIn = new JRadioButton("Celsius");
        CelsiusIn.setActionCommand("CI");
        FahrenheitIn = new JRadioButton("Fahrenheit");
        FahrenheitIn.setActionCommand("FI");
        KelvinIn = new JRadioButton("Kelvin");
        KelvinIn.setActionCommand("KI");
        
        panelB.add(inputEscala);
        entrada.add(CelsiusIn);
        entrada.add(FahrenheitIn);
        entrada.add(KelvinIn);
        panelB.add(CelsiusIn);
        panelB.add(FahrenheitIn);
        panelB.add(KelvinIn);        
        this.getContentPane().add(panelB, "West");
        
        
        //terceiro painel (ao centro)
        panelC = new JPanel();
        titulo = new JLabel("Conversor de Temperaturas");
        
        panelC.add(titulo);
        this.getContentPane().add(panelC, "Center");
        
        
        //quarto painel (ao leste)
        panelD = new JPanel();
        panelD.setLayout(new BoxLayout(panelD, BoxLayout.Y_AXIS));
        outputEscala = new JLabel("Escala de saida");
        ButtonGroup saida = new ButtonGroup();
        CelsiusOut = new JRadioButton("Celsius");
        CelsiusOut.setActionCommand("CO");
        FahrenheitOut = new JRadioButton("Fahrenheit");
        FahrenheitOut.setActionCommand("FO");
        KelvinOut = new JRadioButton("Kelvin");
        KelvinOut.setActionCommand("KO");
        
        panelD.add(outputEscala);
        saida.add(CelsiusOut);
        saida.add(FahrenheitOut);
        saida.add(KelvinOut);
        panelD.add(CelsiusOut);
        panelD.add(FahrenheitOut);
        panelD.add(KelvinOut);        
        this.getContentPane().add(panelD, "East");
        
        
        //quinto painel (ao sul)
        panelE = new JPanel();
        //panelE.setLayout(new BoxLayout(panelE, BoxLayout.X_AXIS));
        butConvert = new JButton("Convert");
        butConvert.addActionListener(this);
        butConvert.setActionCommand("Convert");
        butReset = new JButton("Reset");
        butReset.addActionListener(this);
        butReset.setActionCommand("Reset");
        outputText = new JTextField(15);
        outputText.setEditable(false);
        
        panelE.add(butConvert);
        panelE.add(butReset);
        panelE.add(outputText);
        this.getContentPane().add(panelE, "South");  
        
        System.out.println("Entrada = "+inputText.getText());
    }    
    public void actionPerformed(ActionEvent e){
        double tempEntrada = Double.parseDouble(inputText.getText());
        double tempSaida=0;      
        if(e.getActionCommand() == "Convert"){
            if(entrada.getSelection().getActionCommand() == saida.getSelection().getActionCommand()){
                tempSaida = tempEntrada;
            }
            else{
                if(entrada.getSelection().getActionCommand() == "CI" && saida.getSelection().getActionCommand() == "FO"){
                    tempSaida = 32+(1.8*tempEntrada);
                }
                else if(entrada.getSelection().getActionCommand() == "CI" && saida.getSelection().getActionCommand() == "KO"){
                    tempSaida = 273+tempEntrada;
                }
                else if(entrada.getSelection().getActionCommand() == "FI" && saida.getSelection().getActionCommand() == "CO"){
                    tempSaida = (tempEntrada-32)/1.8;
                }
                else if(entrada.getSelection().getActionCommand() == "FI" && saida.getSelection().getActionCommand() == "KO"){
                    tempSaida = (((tempEntrada-32)/9)*5)+273;                
                }
                else if(entrada.getSelection().getActionCommand() == "KI" && saida.getSelection().getActionCommand() == "CO"){
                    tempSaida = tempEntrada-273;
                }
                else if(entrada.getSelection().getActionCommand() == "KI" && saida.getSelection().getActionCommand() == "FO"){
                    tempSaida = (((tempEntrada-273)/5)*9)+32;
                }   
                outputText.setText(Double.toString(tempSaida));
            }
        }
        else if(e.getActionCommand() == "Reset"){
            inputText.setText("");
            outputText.setText("");
            CelsiusIn.setSelected(true);
            FahrenheitOut.setSelected(true);
        }
    }   
}