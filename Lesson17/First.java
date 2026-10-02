// 1.Окно JFrame с кнопкой «Сгенерировать», полем для вывода и двумя полями 
// ввода: «от» и «до». По нажатию на кнопку в метку выводится случайное число 
// из этого диапазона. Если в поля введено не число или «от» больше «до», 
// вывести сообщение об ошибке в ту же метку.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.random.RandomGenerator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
class First{
    public static void main(String[] args) {
        RandomGenerator g = RandomGenerator.getDefault();
        JFrame frame = new JFrame();
        JTextField from = new JTextField();
        JLabel fromLabel = new JLabel("from");
        JTextField to = new JTextField();
        JLabel toLabel = new JLabel("to");
        JButton button = new JButton("Generate");
        JLabel result = new JLabel();
        button.setBounds(150, 200, 220, 50);
        from.setBounds(50,75, 100, 20);
        fromLabel.setBounds(50,55,100,20);
        to.setBounds(300,75,100,20);
        toLabel.setBounds(300,55,100,20);
        result.setBounds(150,100,100,20);
        frame.add(from);
        frame.add(fromLabel);
        frame.add(to);
        frame.add(toLabel);
        frame.add(button);
        frame.add(result);
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                var a = Integer.parseInt(from.getText());
                var b = Integer.parseInt(to.getText());
                if(a>b){
                    result.setText(Integer.toString(g.nextInt(b,a)));
                }
                else{
                    result.setText(Integer.toString(g.nextInt(a,b)));
                }
                
            }
        });
    }
}