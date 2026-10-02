// 2.Окно с кнопкой «Клик» и меткой «Кликов: 0». Каждый клик увеличивает счётчик. 
// Добавь кнопку «Сброс», а когда счётчик дойдёт до 10, пусть метка меняет текст 
// на «Хватит кликать!».

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Second{
    static int counter = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton click = new JButton("Click");
        JButton drop = new JButton("Drop");
        JLabel counterLabel = new JLabel("0");
        
        counterLabel.setBounds(250,100,100,25);
        click.setBounds(250, 150, 120, 100);
        drop.setBounds(250, 350, 120,100);
        frame.setSize(500,500);
        frame.add(counterLabel);
        frame.add(drop);
        frame.add(click);
        frame.setLayout(null);
        frame.setVisible(true);
        click.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                counter+=1;
                if (counter>=10){
                    counterLabel.setText("Stop it!");
                }
                else{
                counterLabel.setText(Integer.toString(counter));}
            }
        });
        drop.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                counter=0;
                counterLabel.setText("0");
            }
        });

    }
}