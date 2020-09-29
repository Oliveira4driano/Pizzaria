/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Pizza;

/**
 *
 * @author Dev-2810
 */
public class TelaPizzaPrincipal extends javax.swing.JFrame {
    
    private final List<Pizza> lista = new ArrayList<>();
    private String texto;
    private final Pizza pizza = new Pizza();
    private static PrintService impressora;
    private String lst;
     
     public void semana(String s){
         
         switch(s){
             case "Seg" :
                 
                 lst ="SEG,TER,QUA,QUI,SEX,SAB,DOM";
                 System.out.println(lst.toString());
                 break;
             case "Ter" :
               
                 lst = "TER,QUA,QUI,SEX,SAB,DOM,SEG";
                 System.out.println(lst.toString());
                 break;
             case "Qua" :
                
                 lst="QUA,QUI,SEX,SAB,DOM,SEG,TER";
                 System.out.println(lst.toString());
                 break;
             case "Qui" :
                
                 lst="QUI,SEX,SAB,DOM,SEG,TER,QUA";
                 System.out.println(lst.toString());
                 break;
             case "Sex" :
                
                 lst = "SEX,SAB,DOM,SEG,TER,QUA,QUI";
                 System.out.println(lst.toString());
                 break;
             case "Sáb" :
               
                 lst="SAB,DOM,SEG,TER,QUA,QUI,SEX";
                 System.out.println(lst.toString());
                 break;
             case "Dom" :
                
                 lst="DOM,SEG,TER,QUA,QUI,SEX,SAB";
                 System.out.println(lst.toString());
                 break;
                 
             default : lst="";
         }
       
     }
      
		
    public void preencherEtiquetas(){
        labelMes.setText(pizza.getData());
        labelMassa.setText(pizza.getMassa());
        labelLote.setText(pizza.getLote());
        labelSEG.setText(pizza.getSemana().substring(0, 3));
        labelTER.setText(pizza.getSemana().substring(4, 7));
        labelQUA.setText(pizza.getSemana().substring(8, 11));
        labelQUI.setText(pizza.getSemana().substring(12, 15));
        labelSEX.setText(pizza.getSemana().substring(16, 19));
        LabelSAB.setText(pizza.getSemana().substring(20, 23));
        labelDOM.setText(pizza.getSemana().substring(24, 27));
    }


    public void preencherDados(){

        pizza.setMassa((String) comboMassa.getSelectedItem());
        pizza.setLote(campoLote.getText());
        pizza.setQuantidade(campoQtd.getText());
        pizza.setTemperatura((String) comboTemperatura.getSelectedItem());
        pizza.setImpressora((String) comboImpressora.getSelectedItem());
        
      
       
        if(!(jCalendar1.getDate()==null)){
                  
                Date data = jCalendar1.getDate();
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MMM");
                SimpleDateFormat formatador2 = new SimpleDateFormat("E");
                String novaData = formatador.format(data);
              
                String s = formatador2.format(data);
                pizza.setData(novaData);
               // System.out.println(s);
                semana(s);
          pizza.setSemana(lst);
            
         
        lista.add(pizza);
        
 
        texto = "CT~~CD,~CC^~CT~\n" +
                "^XA~TA000~JSN^LT0^MNW^MTT^PON^PMN^LH0,0^JMA^PR4,4~SD10^JUS^LRN^CI0^XZ\n" +
                "^XA\n" +
                "^MD"+pizza.getTemperatura()+"\n"+ 
                "^MMT\n" +
                "^PW400\n" +
                "^LL0240\n" +
                "^LS0\n" +
                "^FT7,35^A0N,23,24^FH\\^FD"+pizza.getSemana().substring(0, 3)+"^FS\n" +
                "^FT63,35^A0N,23,24^FH\\^FD"+pizza.getSemana().substring(4, 7)+"^FS\n" +
                "^FT118,35^A0N,23,24^FH\\^FD"+pizza.getSemana().substring(8, 11)+"^FS\n" +
                "^FT178,35^A0N,23,24^FH\\^FD"+pizza.getSemana().substring(12, 15)+"^FS\n" +
                "^FT229,35^A0N,23,24^FH\\^FD"+pizza.getSemana().substring(16, 19)+"^FS\n" +
                "^FT284,35^A0N,23,24^FH\\^FD"+pizza.getSemana().substring(20, 23)+"^FS\n" +
                "^FT339,35^A0N,23,24^FH\\^FD"+pizza.getSemana().substring(24, 27)+"^FS\n" +
                "^FT7,199^A0N,28,28^FH\\^FD"+pizza.getLote()+"^FS\n" +
                "^FT11,91^A0N,25,24^FH\\^FD"+pizza.getData()+"^FS\n" +
                "^FO0,140^GB337,0,2^FS\n" +
                "^FO114,1^GB0,237,2^FS\n" +
                "^FO170,1^GB0,239,2^FS\n" +
                "^FO335,1^GB0,239,2^FS\n" +
                "^FO225,1^GB0,237,2^FS\n" +
                "^FO281,1^GB0,239,2^FS\n" +
                "^FT126,189^A0N,23,24^FH\\^FDAte^FS\n" +
                "^FT126,217^A0N,23,24^FH\\^FD6h^FS\n" +
                "^FT186,189^A0N,23,24^FH\\^FDAte^FS\n" +
                "^FT186,217^A0N,23,24^FH\\^FD4h^FS\n" +
                "^FT242,189^A0N,23,24^FH\\^FDAte^FS\n" +
                "^FT242,217^A0N,23,24^FH\\^FD1h^FS\n" +
                "^FT305,127^A0B,20,19^FH\\^FDUso ^FS\n" +
                "^FT329,127^A0B,20,19^FH\\^FDImediato^FS\n" +
                "^FT126,100^A0N,34,33^FH\\^FD2h^FS\n" +
                "^FT178,100^A0N,34,33^FH\\^FD1h^FS\n" +
                "^FT343,159^A0N,45,45^FH\\^FD"+pizza.getMassa()+"^FS\n" +
                "^FT249,127^A0B,20,19^FH\\^FDUso ^FS\n" +
                "^FT273,127^A0B,20,19^FH\\^FDImediato^FS\n" +
                "^FT304,227^A0B,20,19^FH\\^FDUso ^FS\n" +
                "^FT328,227^A0B,20,19^FH\\^FDImediato^FS\n" +
                "^PQ"+pizza.getQuantidade()+",0,1,Y^XZ";
    }
        
       
    }
    
    public void listaImpressora(){
       PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
       
    for (PrintService printer : printServices)
        //System.out.println("Printer: " + printer.getName()); 
        comboImpressora.addItem(printer.getName());
                   
  }
  // O metodo verifica se existe impressora conectada e a
    // define como padrao.
    public void detectaImpressoras() {

        try {
             // Localiza todas as impressoras com suporte a arquivos txt 
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            for (PrintService p: ps) {
                    while(p.getName().equals(pizza.getImpressora())){
                        
              //   if(p.getName() != null && p.getName().contains((String) ))
              //  if(p.getName().equals((String) comboImpressora.getSelectedItem())){
               // if (p.getName().contains("ZPL") || p.getName().contains("Zebra"))  {

	                System.out.println("Impressora : " + p.getName());
                        System.out.println("Impressora Selecionada: " + comboImpressora.getSelectedItem());
                    impressora = p;
                   
                    break;

                }

            }

        } catch (Exception e) {
             e.printStackTrace();
        }  
    }
    
    public synchronized boolean imprime(String texto) {
        
        // se nao existir impressora, entao avisa usuario
        // senao imprime texto
        if (impressora == null) {
            
            String msg = "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.";
	    JOptionPane.showMessageDialog(this,msg);   	
           // System.out.println(msg);

        } else {

            try {
                System.out.println("tela.TelaPizzaPrincipal.imprime()"+impressora);
                DocPrintJob dpj = impressora.createPrintJob();
                InputStream stream = new ByteArrayInputStream(texto.getBytes());

                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(stream, flavor, null);
                dpj.print(doc, null);

                return true;

            } catch (PrintException e) {

                e.printStackTrace();

            }

        }

        return false;

    }
    
    
    public void calibrar(){
         texto ="~JC";
        // jTextArea1.setText(texto);
        imprime(texto);
        texto="";
       
    }
    
    private void sobre() {
        
        JOptionPane.showMessageDialog(null, "\nDesenvolvedor: Adriano de oliveira"
                + " \nFone:(92)99292-1431"
                + "\n Email: oliveira.ifam@gmail.com"+
                "\nManaus-AM 2020\n"+
                "Banco: Bradesco"+
                " AG:482"+
                " CC: 33902-4"+
                "\nPaypal: aoliveira2810@gmail.com");
    }
    
    public TelaPizzaPrincipal() {
        initComponents();
         this.setLocationRelativeTo(null);
        listaImpressora();
        preencherDados();
        preencherEtiquetas();
        jPanelConfiguracao.setVisible(false);
       
       
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboMassa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        campoLote = new javax.swing.JTextField();
        campoQtd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel2 = new javax.swing.JPanel();
        comboImpressora = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        botaoCalibrar = new javax.swing.JButton();
        comboTemperatura = new javax.swing.JComboBox<>();
        botaoImprimir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanelConfiguracao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        painelImagemFundo1 = new tela.PainelImagemFundo();
        labelMassa = new javax.swing.JLabel();
        labelLote = new javax.swing.JLabel();
        labelMes = new javax.swing.JLabel();
        labelSEG = new javax.swing.JLabel();
        labelTER = new javax.swing.JLabel();
        labelQUA = new javax.swing.JLabel();
        labelQUI = new javax.swing.JLabel();
        labelSEX = new javax.swing.JLabel();
        LabelSAB = new javax.swing.JLabel();
        labelDOM = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Impressão de Etiquetas"));

        jLabel1.setText("Massa:");

        comboMassa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "10", "12", "14" }));

        jLabel2.setText("Lote:");

        campoLote.setText("BAT 6");

        campoQtd.setText("1");

        jLabel3.setText("Qtd etiq.:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Impressão"));

        jLabel4.setText("Temperatura. imprressora");

        botaoCalibrar.setText("Calibrar");
        botaoCalibrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCalibrarActionPerformed(evt);
            }
        });

        comboTemperatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        comboTemperatura.setSelectedIndex(11);

        botaoImprimir.setText("Imprimir");
        botaoImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37)
                        .addComponent(comboTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCalibrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(botaoImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(comboImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoCalibrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel6.setText("Ajuricaba Informática V1.5 ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboMassa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoQtd)
                            .addComponent(campoLote, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboMassa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jLabel6)
                .addGap(50, 50, 50))
        );

        jPanelConfiguracao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Etiqueta")));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanelConfiguracaoLayout = new javax.swing.GroupLayout(jPanelConfiguracao);
        jPanelConfiguracao.setLayout(jPanelConfiguracaoLayout);
        jPanelConfiguracaoLayout.setHorizontalGroup(
            jPanelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelConfiguracaoLayout.setVerticalGroup(
            jPanelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracaoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        painelImagemFundo1.setImg(new javax.swing.ImageIcon(getClass().getResource("/IMG/etiqueta.jpg")));

        labelMassa.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        labelMassa.setText("Massa");

        labelLote.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelLote.setText("lote");

        labelMes.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        labelMes.setText("mes");

        labelSEG.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        labelSEG.setText("sem");

        labelTER.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        labelTER.setText("sem");

        labelQUA.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        labelQUA.setText("sem");

        labelQUI.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        labelQUI.setText("sem");

        labelSEX.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        labelSEX.setText("sem");

        LabelSAB.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        LabelSAB.setText("sem");

        labelDOM.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        labelDOM.setText("sem");

        javax.swing.GroupLayout painelImagemFundo1Layout = new javax.swing.GroupLayout(painelImagemFundo1);
        painelImagemFundo1.setLayout(painelImagemFundo1Layout);
        painelImagemFundo1Layout.setHorizontalGroup(
            painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelImagemFundo1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMes)
                    .addComponent(labelLote))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImagemFundo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSEG)
                .addGroup(painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImagemFundo1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelMassa))
                    .addGroup(painelImagemFundo1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelTER)
                        .addGap(34, 34, 34)
                        .addComponent(labelQUA)
                        .addGap(18, 18, 18)
                        .addComponent(labelQUI)
                        .addGap(18, 18, 18)
                        .addComponent(labelSEX)
                        .addGap(18, 18, 18)
                        .addComponent(LabelSAB)
                        .addGap(18, 18, 18)
                        .addComponent(labelDOM)))
                .addGap(14, 14, 14))
        );
        painelImagemFundo1Layout.setVerticalGroup(
            painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelImagemFundo1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTER)
                        .addComponent(labelSEG))
                    .addGroup(painelImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSEX)
                        .addComponent(LabelSAB)
                        .addComponent(labelQUI)
                        .addComponent(labelQUA))
                    .addComponent(labelDOM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(labelMassa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(labelLote)
                .addGap(28, 28, 28))
        );

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");

        jMenuItem1.setText("Desenvolvedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelImagemFundo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(painelImagemFundo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCalibrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCalibrarActionPerformed
       preencherDados();
        detectaImpressoras();
        calibrar();
       
    }//GEN-LAST:event_botaoCalibrarActionPerformed

    private void botaoImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImprimirActionPerformed
        preencherDados();
        
        detectaImpressoras();
        //System.out.println(texto);
        //jLabel5.setVisible(true);
        imprime(texto);
       // jTextArea1.setText(texto);
       // jTextArea1.setEditable(false);
       preencherEtiquetas();
        texto="";
       
    }//GEN-LAST:event_botaoImprimirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        sobre();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPizzaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPizzaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPizzaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPizzaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPizzaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSAB;
    private javax.swing.JButton botaoCalibrar;
    private javax.swing.JButton botaoImprimir;
    private javax.swing.JTextField campoLote;
    private javax.swing.JTextField campoQtd;
    private javax.swing.JComboBox<String> comboImpressora;
    private javax.swing.JComboBox<String> comboMassa;
    private javax.swing.JComboBox<String> comboTemperatura;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelConfiguracao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelDOM;
    private javax.swing.JLabel labelLote;
    private javax.swing.JLabel labelMassa;
    private javax.swing.JLabel labelMes;
    private javax.swing.JLabel labelQUA;
    private javax.swing.JLabel labelQUI;
    private javax.swing.JLabel labelSEG;
    private javax.swing.JLabel labelSEX;
    private javax.swing.JLabel labelTER;
    private tela.PainelImagemFundo painelImagemFundo1;
    // End of variables declaration//GEN-END:variables

    
}
