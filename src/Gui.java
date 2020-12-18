import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends Thread{

    @Override
    public void run() {
        setUpGui(800, 500);
        setUpButtonListeners();
        Needs.setter();
    }

    static JFrame frame = new JFrame("Pet Game");
    static JPanel moodP = new JPanel(new GridBagLayout());
    static JLabel moodL = new JLabel();
    static JPanel timeP = new JPanel(new GridBagLayout());
    static JLabel secondL = new JLabel();
    static int sec = 0;
    static JLabel minutesL = new JLabel();
    static int min = 0;
    static JLabel dotd = new JLabel(":");
    static JPanel hungryP = new JPanel(new GridBagLayout());
    static JLabel hungryCount = new JLabel(Integer.toString(Needs.hungry));
    static JButton hungryButton = new JButton("+1 Hungry");
    static JPanel hygieneP = new JPanel(new GridBagLayout());
    static JLabel hygieneCount = new JLabel(Integer.toString(Needs.hygiene));
    static JButton hygieneButton = new JButton("+1 Hygiene");
    static JPanel funP = new JPanel(new GridBagLayout());
    static JLabel funCount = new JLabel(Integer.toString(Needs.fun));
    static JButton funButton = new JButton("+1 Fun");
    static JPanel consoleP = new JPanel(new GridBagLayout());
    static JLabel consoleL = new JLabel();

    private static void timeWriter() {
        minutesL.setText("0");
        secondL.setText("0");
        Timer sTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sec == 59) {sec=0;secondL.setText("0");}
                secondL.setText(Integer.toString(++sec));
                Needs.checker();
            }
        });
        Timer mTimer = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minutesL.setText(Integer.toString(++min));
                Needs.checker();
            }
        });
        sTimer.start();
        mTimer.start();
    }

    public static void setUpGui(int w, int h) {
        ImageIcon appIcon = new ImageIcon("faceB.png");
        frame.setIconImage(appIcon.getImage());
        hungryCount.setFont(new Font("Canvas", Font.BOLD, 72));
        hygieneCount.setFont(new Font("Canvas", Font.BOLD, 72));
        funCount.setFont(new Font("Canvas", Font.BOLD, 72));
        consoleL.setFont(new Font("Canvas", Font.BOLD, 32));
        minutesL.setFont(new Font("Canvas", Font.BOLD, 62));
        secondL.setFont(new Font("Canvas", Font.BOLD, 62));
        dotd.setFont(new Font("Canvas", Font.BOLD, 62));
        moodP.add(moodL);
        consoleP.add(consoleL);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        hungryP.add(hungryButton, c);
        hygieneP.add(hygieneButton, c);
        funP.add(funButton, c);
        c.insets = new Insets(0,10,150,10);
        hungryP.add(hungryCount, c);
        hygieneP.add(hygieneCount, c);
        funP.add(funCount, c);
        timeP.add(minutesL);
        timeP.add(dotd);
        timeP.add(secondL);
        timeP.setAlignmentY(30);
        Container cp = frame.getContentPane();
        GridLayout lt = new GridLayout(2,3);
        cp.setLayout(lt);
        cp.add(timeP);
        cp.add(moodP);
        cp.add(consoleP);
        cp.add(hungryP);
        cp.add(hygieneP);
        cp.add(funP);
        timeWriter();
        frame.setSize(w, h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void setUpButtonListeners(){
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Needs.aq = Needs.hungry + Needs.hygiene + Needs.fun + 1;
                if (Needs.aq > 9) {
                    Needs.hungry = 3;
                    Needs.hygiene = 3;
                    Needs.fun = 3;
                }

                Object o = e.getSource();
                ImageIcon clock = new ImageIcon("clock.png");


                if (o == hungryButton ) {
                    if (consoleL.getIcon() != clock) {
                        if (Needs.hungry < 3) {
                            hungryButton.setVisible(false);
                            hygieneButton.setVisible(false);
                            funButton.setVisible(false);
                            consoleL.setText("");
                            consoleL.setIcon(clock);
                            Timer timer = new Timer( 3000, new ActionListener(){
                                @Override
                                public void actionPerformed( ActionEvent e ){
                                    consoleL.setIcon(new ImageIcon(""));
                                    ++Needs.hungry;
                                    Needs.setter();
                                    hungryButton.setVisible(true);
                                    hygieneButton.setVisible(true);
                                    funButton.setVisible(true);
                                }});
                            timer.setRepeats(false);
                            timer.start();
                        } else {
                            if (consoleL.getText() == "") {
                                consoleL.setText("This need is full!");
                                Timer timer = new Timer( 2000, new ActionListener(){
                                    @Override
                                    public void actionPerformed( ActionEvent e ){
                                        consoleL.setText("");
                                    }});
                                timer.setRepeats(false);
                                timer.start();
                            } else{}
                        }
                    } else {}
                } else if (o == hygieneButton) {
                    if (consoleL.getIcon() != clock) {
                        if (Needs.hygiene < 3) {
                            hungryButton.setVisible(false);
                            hygieneButton.setVisible(false);
                            funButton.setVisible(false);
                            consoleL.setText("");
                            consoleL.setIcon(clock);
                            Timer timer = new Timer( 3000, new ActionListener(){
                                @Override
                                public void actionPerformed( ActionEvent e ){
                                    consoleL.setIcon(new ImageIcon(""));
                                    ++Needs.hygiene;
                                    Needs.setter();
                                    hungryButton.setVisible(true);
                                    hygieneButton.setVisible(true);
                                    funButton.setVisible(true);
                                }});
                            timer.setRepeats(false);
                            timer.start();
                        } else {
                            if (consoleL.getText() == "") {
                                consoleL.setText("This need is full!");
                                Timer timer = new Timer( 2000, new ActionListener(){
                                    @Override
                                    public void actionPerformed( ActionEvent e ){
                                        consoleL.setText("");
                                    }});
                                timer.setRepeats(false);
                                timer.start();
                            } else{}
                        }
                    } else {}
                } else if (o == funButton) {
                    if (consoleL.getIcon() != clock) {
                        if (Needs.fun < 3) {
                            hungryButton.setVisible(false);
                            hygieneButton.setVisible(false);
                            funButton.setVisible(false);
                            consoleL.setText("");
                            consoleL.setIcon(clock);
                            Timer timer = new Timer( 3000, new ActionListener(){
                                @Override
                                public void actionPerformed( ActionEvent e ){
                                    consoleL.setIcon(new ImageIcon(""));
                                    ++Needs.fun;
                                    Needs.setter();
                                    hungryButton.setVisible(true);
                                    hygieneButton.setVisible(true);
                                    funButton.setVisible(true);
                                }});
                            timer.setRepeats(false);
                            timer.start();
                        } else {
                            if (consoleL.getIcon() != clock) {
                                consoleL.setText("This need is full!");
                                Timer timer = new Timer( 2000, new ActionListener(){
                                    @Override
                                    public void actionPerformed( ActionEvent e ){
                                        consoleL.setText("");
                                    }});
                                timer.setRepeats(false);
                                timer.start();
                            } else{}
                        }
                    } else {}
                }
            }
        };
        hungryButton.addActionListener(buttonListener);
        hygieneButton.addActionListener(buttonListener);
        funButton.addActionListener(buttonListener);
    }

    public static void setCounts() {
        // HUNGRY
        if (Needs.hungry == 3) {
            hungryCount.setText(Integer.toString(Needs.hungry));
            hungryCount.setForeground(Color.green);
        } else if (Needs.hungry == 2) {
            hungryCount.setText(Integer.toString(Needs.hungry));
            hungryCount.setForeground(Color.yellow);
        } else if (Needs.hungry == 1) {
            hungryCount.setText(Integer.toString(Needs.hungry));
            hungryCount.setForeground(Color.orange);
        } else if (Needs.hungry == 0) {
            hungryCount.setText(Integer.toString(Needs.hungry));
            hungryCount.setForeground(Color.red);
        }
        // HYGIENE
        if (Needs.hygiene == 3) {
            hygieneCount.setText(Integer.toString(Needs.hygiene));
            hygieneCount.setForeground(Color.green);
        } else if (Needs.hygiene == 2) {
            hygieneCount.setText(Integer.toString(Needs.hygiene));
            hygieneCount.setForeground(Color.yellow);
        } else if (Needs.hygiene == 1) {
            hygieneCount.setText(Integer.toString(Needs.hygiene));
            hygieneCount.setForeground(Color.orange);
        } else if (Needs.hygiene == 0) {
            hygieneCount.setText(Integer.toString(Needs.hygiene));
            hygieneCount.setForeground(Color.red);
        }
        // FUN
        if (Needs.fun == 3) {
            funCount.setText(Integer.toString(Needs.fun));
            funCount.setForeground(Color.green);
        } else if (Needs.fun == 2) {
            funCount.setText(Integer.toString(Needs.fun));
            funCount.setForeground(Color.yellow);
        } else if (Needs.fun == 1) {
            funCount.setText(Integer.toString(Needs.fun));
            funCount.setForeground(Color.orange);
        } else if (Needs.fun == 0) {
            funCount.setText(Integer.toString(Needs.fun));
            funCount.setForeground(Color.red);
        }
    }//ahoj

    public static void moodChecker() {
        Needs.aq = Needs.hungry + Needs.hygiene + Needs.fun;
        if (Needs.aq >= 7) {
            moodL.setIcon(new ImageIcon("faceA.png"));
        } else if ((Needs.aq < 7) && (Needs.aq >= 4)) {
            moodL.setIcon(new ImageIcon("faceB.png"));
        } else if ((Needs.aq < 4) && (Needs.aq >= 0)) {
            moodL.setIcon(new ImageIcon("faceC.png"));
        }
    }
}