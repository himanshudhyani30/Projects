import java.io.*;
import javax.swing.*;
import java.awt.*;

class Operation extends JFrame {
    Container c;
    JTextField TF;
    JLabel L, L2, L3, L4;
    JButton JB;
    Font f;

    Operation() {
        c = this.getContentPane();
        c.setLayout(null);

        // c.setBackground(Color.white);

        L = new JLabel("Enter Private Key");
        L.setBounds(50, 30, 150, 40);
        c.add(L);

        TF = new JTextField();
        TF.setBounds(200, 30, 150, 40);
        c.add(TF);

        L2 = new JLabel("Encryption / Decryption");
        L2.setBounds(50, 90, 150, 40);
        c.add(L2);

        f = new Font("Roboto", Font.BOLD, 20);
        JB = new JButton("Click here");
        JB.setBounds(200, 90, 150, 40);
        JB.setFont(f);
        c.add(JB);

        L3 = new JLabel("Please wait encryption/decryption process takes time");
        L3.setBounds(50, 160, 300, 40);
        c.add(L3);

        L4 = new JLabel("Made by- Himanshu Dhyani");
        L4.setBounds(230, 230, 170, 40);
        c.add(L4);

        JB.addActionListener(e -> {
            String text = TF.getText();
            int temp = Integer.parseInt(text);
            action(temp);
        });

    }

    public void action(int key) {
        JFileChooser filechooser = new JFileChooser();
        filechooser.showOpenDialog(null);
        File file = filechooser.getSelectedFile();
        try {
            FileInputStream FIS = new FileInputStream(file);
            byte[] data = new byte[FIS.available()];
            FIS.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            FIS.close();
            JOptionPane.showMessageDialog(null, "DONE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class ImageOperation {
    public static void main(String args[]) {
        Operation f = new Operation();
        f.setTitle("Image Encryption and Decryption");
        f.setBounds(500, 250, 400, 300);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}