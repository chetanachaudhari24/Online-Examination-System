
import ClientServer.ClientServer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */

public class QuestionFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form MainFrame
     */
    static int min=15;
    static int sec=00;
    Timer timer;
    static QuestionFrame Qframe=null;
    ArrayList<ClientServer> QuestionList=new ArrayList<ClientServer>();
    HashMap<Integer,ClientServer>AnswerList=new HashMap<Integer, ClientServer>();
    int index=0;
    static Iterator<ClientServer>itr;
    public QuestionFrame() throws IOException, ClassNotFoundException {
        initComponents();
        SubjectLabel.setText(MainFrame.din.readUTF());
        this.setTitle("Online Aptitude Test");
        Qframe=this;
        QuestionList.clear();
        OptionRadioButton1.setSelected(false);
        OptionRadioButton2.setSelected(false);
        OptionRadioButton3.setSelected(false);
        OptionRadioButton4.setSelected(false);
        for(int i=0;i<15;i++){
            ClientServer obj=new ClientServer(i+1,0,0);
            AnswerList.put(i+1, obj);
        }
        GetQuestion();
        DisplayQuestion();
        timer=new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sec==0)
                {
                    sec=60;
                    min--;       
                }
                if(min<0){
                    try {
                        result();
                    } catch (IOException ex) {
                        Logger.getLogger(QuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    min=0;
                    sec=0;
                    timer.stop();
                      
                        
                   
                }else
                {
                    sec--;
                    if(sec<10)
                           Seconds.setText("0"+sec);
                    else
                            Seconds.setText(""+sec);
                    
                    if(min<10)
                           Minutes.setText("0"+min);
                    else
                            Minutes.setText(""+min);

                }
            }
        });
        timer.start();
        
    }
    
    public void result() throws IOException
    {
          MainFrame.oout.writeObject(AnswerList);
          MainFrame.dout.writeInt(MainFrame.studentId);
          for(int i=1;i<=15;i++)
          {
              ClientServer obj=AnswerList.get(i);
          }
                         try {
                          ResultFrame  result = new ResultFrame();
                             result.setVisible(true);
                         setVisible(false);
                         dispose();
                         } catch (ClassNotFoundException ex) {
                             Logger.getLogger(QuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
                         }
    }
    public void GetQuestion() throws IOException, ClassNotFoundException{
        MainFrame.dout.writeUTF("Getting QuestionId for objective test");
        QuestionList=(ArrayList<ClientServer>) MainFrame.oin.readObject();
        itr=QuestionList.iterator();
        /*while(itr.hasNext()){
            ClientServer obj=itr.next();
            System.out.println("QuestionFrame.GetQuestion()");
            System.out.println(obj.QuestionNo+"  "+obj.QuestionContents);
        }*/
    }
    
    public void DisplayQuestion(){
        ClientServer obj;
        obj = QuestionList.get(index);
        NoLabel.setText(""+obj.QuestionNo);
        QuestionLabel.setText("<html>"+obj.QuestionContents+"</html>");
        OptionRadioButton1.setText(obj.Option1);
        OptionRadioButton2.setText(obj.Option2);
        OptionRadioButton3.setText(obj.Option3);
        OptionRadioButton4.setText(obj.Option4);
        ClientServer obj2;
        obj2=AnswerList.get(obj.QuestionNo);
        buttonGroup1.clearSelection();
       
        if(obj2.isAnswered==1) 
        {
            if(obj2.UserOption==1)
                //jRadioButton1.setSelected(true);
                  buttonGroup1.setSelected(OptionRadioButton1.getModel(), true);
            else if(obj2.UserOption==2){
                //jRadioButton2.setSelected(true);
                 
                 buttonGroup1.setSelected(OptionRadioButton2.getModel(), true);}
            else if(obj2.UserOption==3)
                //jRadioButton3.setSelected(true);
                 buttonGroup1.setSelected(OptionRadioButton3.getModel(), true);
            else
                //jRadioButton4.setSelected(true);
                 buttonGroup1.setSelected(OptionRadioButton4.getModel(), true);
        }
        /*else
        {
           buttonGroup1.clearSelection();
        }*/
        
    }
    
    
    public HashMap<Integer,ClientServer> GetAnswerList(){
        return AnswerList;
    }
    
    public static ClientServer GetTime(){
        ClientServer obj=new ClientServer(min, sec);
        return obj;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel();
        UpperPanel = new javax.swing.JPanel();
        AllTheBestLabel = new javax.swing.JLabel();
        Minutes = new javax.swing.JLabel();
        Seconds = new javax.swing.JLabel();
        ICON = new javax.swing.JLabel();
        Icon = new javax.swing.JLabel();
        Colon = new javax.swing.JLabel();
        QuestionNoLabel = new javax.swing.JLabel();
        NoLabel = new javax.swing.JLabel();
        SubjectLabel = new javax.swing.JLabel();
        QuestionLabel = new javax.swing.JLabel();
        LowerPanel = new javax.swing.JPanel();
        ReviewButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        EndTestButton = new javax.swing.JButton();
        OptionRadioButton1 = new javax.swing.JRadioButton();
        OptionRadioButton2 = new javax.swing.JRadioButton();
        OptionRadioButton3 = new javax.swing.JRadioButton();
        OptionRadioButton4 = new javax.swing.JRadioButton();
        Option1 = new javax.swing.JLabel();
        Option2 = new javax.swing.JLabel();
        Option3 = new javax.swing.JLabel();
        Option4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));

        UpperPanel.setBackground(new java.awt.Color(0, 0, 51));

        AllTheBestLabel.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        AllTheBestLabel.setForeground(new java.awt.Color(255, 255, 255));
        AllTheBestLabel.setText("ALL THE BEST!!");

        Minutes.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Minutes.setForeground(new java.awt.Color(255, 255, 255));
        Minutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minutes.setText("15");

        Seconds.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Seconds.setForeground(new java.awt.Color(255, 255, 255));
        Seconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Seconds.setText("00");

        ICON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clock-8-24.png"))); // NOI18N

        Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thumbs-up-3-32.png"))); // NOI18N

        Colon.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Colon.setForeground(new java.awt.Color(255, 255, 255));
        Colon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Colon.setText(":");

        javax.swing.GroupLayout UpperPanelLayout = new javax.swing.GroupLayout(UpperPanel);
        UpperPanel.setLayout(UpperPanelLayout);
        UpperPanelLayout.setHorizontalGroup(
            UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpperPanelLayout.createSequentialGroup()
                        .addComponent(Icon)
                        .addGap(18, 18, 18)
                        .addComponent(AllTheBestLabel)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpperPanelLayout.createSequentialGroup()
                        .addComponent(ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Minutes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Colon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Seconds)
                        .addGap(27, 27, 27))))
        );
        UpperPanelLayout.setVerticalGroup(
            UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AllTheBestLabel)
                    .addComponent(Icon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Seconds)
                        .addComponent(Minutes)
                        .addComponent(Colon)))
                .addContainerGap())
        );

        QuestionNoLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        QuestionNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuestionNoLabel.setText("Question No.");

        NoLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        NoLabel.setText("1");

        SubjectLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        SubjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SubjectLabel.setText("SUBJECT NAME");

        QuestionLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        QuestionLabel.setText("Question content");

        LowerPanel.setBackground(new java.awt.Color(0, 0, 51));

        ReviewButton.setBackground(new java.awt.Color(255, 255, 255));
        ReviewButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        ReviewButton.setForeground(new java.awt.Color(0, 0, 51));
        ReviewButton.setText("Review");
        ReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewButtonActionPerformed(evt);
            }
        });

        PreviousButton.setBackground(new java.awt.Color(255, 255, 255));
        PreviousButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        PreviousButton.setForeground(new java.awt.Color(0, 0, 51));
        PreviousButton.setText("Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setBackground(new java.awt.Color(255, 255, 255));
        NextButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        NextButton.setForeground(new java.awt.Color(0, 0, 51));
        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        EndTestButton.setBackground(new java.awt.Color(255, 255, 255));
        EndTestButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        EndTestButton.setForeground(new java.awt.Color(0, 0, 51));
        EndTestButton.setText("Submit Test");
        EndTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndTestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LowerPanelLayout = new javax.swing.GroupLayout(LowerPanel);
        LowerPanel.setLayout(LowerPanelLayout);
        LowerPanelLayout.setHorizontalGroup(
            LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LowerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EndTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LowerPanelLayout.setVerticalGroup(
            LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LowerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EndTestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        buttonGroup1.add(OptionRadioButton1);
        OptionRadioButton1.setText("jRadioButton1");
        OptionRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(OptionRadioButton2);
        OptionRadioButton2.setText("jRadioButton2");
        OptionRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(OptionRadioButton3);
        OptionRadioButton3.setText("jRadioButton3");
        OptionRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(OptionRadioButton4);
        OptionRadioButton4.setText("jRadioButton4");
        OptionRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionRadioButton4ActionPerformed(evt);
            }
        });

        Option1.setText("a.");

        Option2.setText("b.");

        Option3.setText("c.");

        Option4.setText("d.");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpperPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Option2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Option3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Option4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OptionRadioButton2)
                            .addComponent(OptionRadioButton1)
                            .addComponent(OptionRadioButton3)
                            .addComponent(OptionRadioButton4)))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(QuestionNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(QuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(UpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(SubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuestionNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptionRadioButton1)
                    .addComponent(Option1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptionRadioButton2)
                    .addComponent(Option2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptionRadioButton3)
                    .addComponent(Option3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptionRadioButton4)
                    .addComponent(Option4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(LowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OptionRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionRadioButton4ActionPerformed
        // TODO add your handling code here:
        ClientServer obj=new ClientServer(Integer.parseInt(NoLabel.getText()),1,4);
        AnswerList.replace(Integer.parseInt(NoLabel.getText()),obj);
    }//GEN-LAST:event_OptionRadioButton4ActionPerformed

    private void OptionRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionRadioButton3ActionPerformed
        ClientServer obj=new ClientServer(Integer.parseInt(NoLabel.getText()),1,3);
        AnswerList.replace(Integer.parseInt(NoLabel.getText()),obj);
    }//GEN-LAST:event_OptionRadioButton3ActionPerformed

    private void OptionRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionRadioButton2ActionPerformed
        // TODO add your handling code here:
        ClientServer obj=new ClientServer(Integer.parseInt(NoLabel.getText()),1,2);
        AnswerList.replace(Integer.parseInt(NoLabel.getText()),obj);
    }//GEN-LAST:event_OptionRadioButton2ActionPerformed

    private void OptionRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionRadioButton1ActionPerformed
        // TODO add your handling code here:
        ClientServer obj=new ClientServer(Integer.parseInt(NoLabel.getText()),1,1);
        AnswerList.replace(Integer.parseInt(NoLabel.getText()),obj);
    }//GEN-LAST:event_OptionRadioButton1ActionPerformed

    private void EndTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndTestButtonActionPerformed
        // TODO add your handling code here:
        Dialogbox end_test=new Dialogbox();
        end_test.setVisible(true);

        setVisible(false);
        this.dispose();
    }//GEN-LAST:event_EndTestButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        index++;

        if(index<15)
        {
            DisplayQuestion();
        }
        else
        JOptionPane.showMessageDialog(rootPane,"No more Questions!!","",0);
    }//GEN-LAST:event_NextButtonActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        // TODO add your handling code here:
        index--;
        if(index>=0){
            DisplayQuestion();
        }
        else
        JOptionPane.showMessageDialog(rootPane,"No more Questions!!","",0);
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void ReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewButtonActionPerformed
        // TODO add your handling code here:
        ReviewFrame review;
        try {
            review = new ReviewFrame();
             review.setVisible(true);
            setVisible(false);
       
        } catch (IOException ex) {
            Logger.getLogger(QuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_ReviewButtonActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuestionFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(QuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(QuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AllTheBestLabel;
    private javax.swing.JLabel Colon;
    private javax.swing.JButton EndTestButton;
    private javax.swing.JLabel ICON;
    private javax.swing.JLabel Icon;
    private javax.swing.JPanel LowerPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel Minutes;
    private javax.swing.JButton NextButton;
    private javax.swing.JLabel NoLabel;
    private javax.swing.JLabel Option1;
    private javax.swing.JLabel Option2;
    private javax.swing.JLabel Option3;
    private javax.swing.JLabel Option4;
    private javax.swing.JRadioButton OptionRadioButton1;
    private javax.swing.JRadioButton OptionRadioButton2;
    private javax.swing.JRadioButton OptionRadioButton3;
    private javax.swing.JRadioButton OptionRadioButton4;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JLabel QuestionLabel;
    private javax.swing.JLabel QuestionNoLabel;
    private javax.swing.JButton ReviewButton;
    private javax.swing.JLabel Seconds;
    private javax.swing.JLabel SubjectLabel;
    private javax.swing.JPanel UpperPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}
