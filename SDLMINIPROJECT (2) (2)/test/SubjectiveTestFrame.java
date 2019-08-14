import NaturalLanguageProcessing.*;
import ClientServer.ClientServer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
 * @author megha
 */
public class SubjectiveTestFrame extends javax.swing.JFrame {

    /**
     * Creates new form SubjectiveTestFrame
     */
    int min=20;
    int sec=0;
    Timer timer;
    int index=1;
    static SubjectiveTestFrame SFrame;
    static ArrayList<ClientServer>SubjectiveQuestionList=null;
     Iterator<ClientServer>sitr;
    static HashMap<Integer,ClientServer>SubjectiveAnswerList=new HashMap<Integer,ClientServer>();
    public SubjectiveTestFrame() throws IOException, ClassNotFoundException {
        initComponents();
        SubjectLabel.setText(MainFrame.din.readUTF());
        this.setTitle("Online Aptitude Test");
        SFrame=this;
         for(int i=0;i<10;i++){
             ClientServer obj=new ClientServer(0,"",0);
            SubjectiveAnswerList.put(i+1,obj);
        }
        GetQuestion();
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
                        ClientServer obj1=new ClientServer(0, AnswerTextArea.getText(),0);
                        SubjectiveAnswerList.replace(index,obj1);
                       
                        JOptionPane.showMessageDialog(rootPane,"times up!!","Stopped",0);
                        AnalyseAnswer();
                        min=0;
                        sec=0;
                        SubjectiveResultFrame subjectresultframe=new SubjectiveResultFrame();
                        subjectresultframe.setVisible(true);
                        setVisible(false);
                        dispose();
                       
                        timer.stop();
                    } catch (IOException ex) {
                        Logger.getLogger(SubjectiveTestFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SubjectiveTestFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
        
        DisplayQuestion();
    }

    public void AnalyseAnswer() throws IOException{
        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        sentimentAnalyzer.initialize();
        for(int i=1;i<=10;i++){
            ClientServer obj=SubjectiveAnswerList.get(i);
            String Answer=obj.Answer;
           
            if(Answer.length()>0 && Answer!=null)
            {
               
                    SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(Answer);
                    ClientServer obj1=new ClientServer(sentimentResult.getSentimentScore(), Answer,1);
                    SubjectiveAnswerList.replace(i,obj1);
            }
    }
      
    }
    
    public void GetQuestion() throws IOException, ClassNotFoundException{
        MainFrame.dout.writeUTF("Getting QuestionId for subjective test");
        System.out.println("SubjectiveTestFrame.GetQuestion()"+MainFrame.oin.available());
        SubjectiveQuestionList=(ArrayList<ClientServer>) MainFrame.oin.readObject();
        sitr=SubjectiveQuestionList.iterator();
        /*while(sitr.hasNext()){
            ClientServer obj=sitr.next();
            System.out.println(obj.QuestionNo+"  "+obj.QuestionContents);
        }*/
    }
    
    public void DisplayQuestion(){
        ClientServer obj;
        obj = SubjectiveQuestionList.get(index-1);
        QuestionNoLabel.setText(""+obj.QuestionNo);
        QuestionContentsLabel.setText("<html>"+obj.QuestionContents+"</html>");
        ClientServer obj2 = SubjectiveAnswerList.get(index);
        AnswerTextArea.setText(obj2.Answer);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        UpperPanel = new javax.swing.JPanel();
        AllTheBestLabel = new javax.swing.JLabel();
        Minutes = new javax.swing.JLabel();
        Seconds = new javax.swing.JLabel();
        ICON = new javax.swing.JLabel();
        Icon = new javax.swing.JLabel();
        Colon = new javax.swing.JLabel();
        LowerPanel = new javax.swing.JPanel();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        EndTestButton = new javax.swing.JButton();
        SubjectLabel = new javax.swing.JLabel();
        QuestionContentsLabel = new javax.swing.JLabel();
        QuestionNoLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AnswerTextArea = new javax.swing.JTextArea();
        QuestionNoLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));

        UpperPanel.setBackground(new java.awt.Color(0, 0, 51));

        AllTheBestLabel.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        AllTheBestLabel.setForeground(new java.awt.Color(255, 255, 255));
        AllTheBestLabel.setText("ALL THE BEST!!");

        Minutes.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Minutes.setForeground(new java.awt.Color(255, 255, 255));
        Minutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minutes.setText("20");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Seconds)
                        .addComponent(Minutes)
                        .addComponent(Colon)))
                .addContainerGap())
        );

        LowerPanel.setBackground(new java.awt.Color(0, 0, 51));

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
                .addGap(222, 222, 222)
                .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EndTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LowerPanelLayout.setVerticalGroup(
            LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LowerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EndTestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        SubjectLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        SubjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SubjectLabel.setText("Subject");
        SubjectLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        QuestionContentsLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        QuestionNoLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        QuestionNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuestionNoLabel.setText("no");

        AnswerTextArea.setColumns(20);
        AnswerTextArea.setRows(5);
        AnswerTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AnswerTextAreaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(AnswerTextArea);

        QuestionNoLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        QuestionNoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuestionNoLabel1.setText("Question No:");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpperPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuestionContentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(QuestionNoLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuestionNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(UpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SubjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuestionNoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuestionNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QuestionContentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    
    
    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        // TODO add your handling code here:
        //SubjectiveAnswerList.replace(index,AnswerTextArea.getText());
        ClientServer obj=new ClientServer(0,AnswerTextArea.getText(),0);
        SubjectiveAnswerList.replace(index,obj);
        System.out.println("SubjectiveTestFrame.PreviousButtonActionPerformed()"+index);
        index--;
        if(index-1>=0){
            AnswerTextArea.setText("");
            DisplayQuestion();
        }
        else
        JOptionPane.showMessageDialog(rootPane,"No more Questions!!","",0);
        
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        
       // SubjectiveAnswerList.replace(index,AnswerTextArea.getText());
        ClientServer obj=new ClientServer(0,AnswerTextArea.getText(),0);
        SubjectiveAnswerList.replace(index,obj);
        index++;

        if(index-1<10)
        {
            AnswerTextArea.setText("");
            DisplayQuestion();
        }
        else
        JOptionPane.showMessageDialog(rootPane,"No more Questions!!","",0);
    }//GEN-LAST:event_NextButtonActionPerformed

    private void EndTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndTestButtonActionPerformed
        try {
            // TODO add your handling code here:
            AnalyseAnswer();
            SubjectiveDialogbox end_test=new SubjectiveDialogbox();
            end_test.setVisible(true);
            setVisible(false);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(SubjectiveTestFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EndTestButtonActionPerformed

    private void AnswerTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AnswerTextAreaKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AnswerTextAreaKeyPressed

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
            java.util.logging.Logger.getLogger(SubjectiveTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectiveTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectiveTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectiveTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SubjectiveTestFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SubjectiveTestFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SubjectiveTestFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AllTheBestLabel;
    private javax.swing.JTextArea AnswerTextArea;
    private javax.swing.JLabel Colon;
    private javax.swing.JButton EndTestButton;
    private javax.swing.JLabel ICON;
    private javax.swing.JLabel Icon;
    private javax.swing.JPanel LowerPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel Minutes;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JLabel QuestionContentsLabel;
    private javax.swing.JLabel QuestionNoLabel;
    private javax.swing.JLabel QuestionNoLabel1;
    private javax.swing.JLabel Seconds;
    private javax.swing.JLabel SubjectLabel;
    private javax.swing.JPanel UpperPanel;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
